package ex0812.exam02;

public class MainApp {

    public static void main(String[] args) {
        // 상품 생성
        Product<Tv, String> p1 = new Product<Tv, String>();
        p1.setKind(new Tv());
        p1.setModel("삼성 tv");

        // 타입 캐스팅 없이 사용 가능
        Tv tv = p1.getKind();
        String model = p1.getModel();

        /////////////////////////////////////////////////

        Product<Video, Integer> p2 = new Product<Video, Integer>();
        p2.setKind(new Video());
        p2.setModel(5); // autoboxing

        Video video = p2.getKind();
        int model2 = p2.getModel(); // unboxing
    }

}
