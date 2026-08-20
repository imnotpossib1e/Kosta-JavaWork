package ex0812.exam01;

public class MainApp {

    public static void main(String[] args) {

        // Generic 사용 이전 -> Object 사용
        /*
        Box box = new Box();

        box.setContent("상품1"); // 저장
        // Object를 사용했기 때문에 캐스팅 필요
        if (box.getContent() instanceof String s) {
            System.out.println(s);
        }

        // board 클래스 저장
        box.setContent(new Board());
        if (box.getContent() instanceof Board b) {
            System.out.println(b.getBno());
        }
         */

        /**
         * Generic 사용
         */
        Box<String> box = new Box<String>();
        box.setContent("앙녕");
        String content = box.getContent();
        System.out.println(content);

        Box<Board> box2 = new Box<Board>();
        box2.setContent(new Board());
        Board board = box2.getContent();
        System.out.println(board.getBno());

        // 포장 클래스
        int i = 5;
        Integer it = i; // AutoBoxing
        int j = it; // unboxing

        Integer a = 5;
        int b = a;
    }

}
