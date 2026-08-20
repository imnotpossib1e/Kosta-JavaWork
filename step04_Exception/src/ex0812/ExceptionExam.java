package ex0812;

public class ExceptionExam {

    public static void main(String[] args) {
        System.out.println("**** Exception Test ****");

        System.out.println("args = " + args);
        try {
            System.out.println("args[0] = " + args[0]); // 배열 경계 벗어남 -> 에러

            int convertNo = Integer.parseInt(args[0]);
            System.out.println("숫자로 변환 = " + convertNo);
            int result = 100 / convertNo;
            System.out.println("나눈결과 = " + result);

            // catch를 여러개 작성할때는 반드시 서브클래스 먼저 작성한다.
        } catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
            // e를 출력하면 `발생한 예외 클래스 이름: 발생한 예외 메시지` 출력
            System.out.println("인수의 값을 전달해주세요 => s" + e); // e.toString() 호출

        } catch (NumberFormatException e) {
            System.out.println("숫자만 입력하세요 => " + e.getMessage()); // 예외 객체가 담고있는 에러메시지를 반환

        } catch (Exception e) { // 모든 예외르 처리해주는 곳
            System.out.println("예외가 발생했어요");
            // 개발자를 위한 메소드(예외 정보를 detail하게 추적할 수 있다.) -> 개발할떄 사용, 배포모드에서는 제거 필수
            // 발생한 예외들을 StackTrace에서 추적 가능
            e.printStackTrace();
        } finally {
            System.out.println("예외 발생 여부 관계 없이 무조건 실행");
        }

        System.out.println("**** Exception End ****");
    }

}
