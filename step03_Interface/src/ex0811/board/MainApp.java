package ex0811.board;

public class MainApp {

    // 1. 필드를 이용한 다형성
    Board board; // Free or Qa or Upload
    BoardService boardService; // FreeBoardServiceImpl or QaBoardServiceImpl or UploadBoardServiceImpl

    public MainApp() {
        // 한가지 타입을 가지고 다양한 타입을 담을 수 있다

        board = new FreeBoard(1, "제목1", "작성자1", "내용1");
        boardService = new FreeBoardServiceImpl();
        test(boardService, board);
        /////////////////////////////////////////

        board = new QaBpard(2, "제목2", "작성자2", "내용2", false);
        boardService = new QaBoardServiceImpl();
        test(boardService, board);
        //////////////////////////////////////////

        board = new UploadBoard(3, "제목3", "작성자3", "내용3", "test.txt");
        boardService = new UploadBoardImpl();
        test(boardService, board);
    }

    public void test(BoardService service, Board board) { // 2. 매개변수를 이용한 다형성
        // service로 들어오는 Impl에 따라 해당 Impl에 재정의된 메소드들이 실행된다
        // interface가 implements한 클래스의 메소드를 불러와준다.
        service.insert(board);
        service.update(board);
        service.selectByNo(5);

        // interface 내에서 body가 있는 메소드
        service.delete(100);
        BoardService.selectAll();

        System.out.println("--------------------------");
    }

    public static void main(String[] args) {
        new MainApp();
    }

}
