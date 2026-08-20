package ex0812.exception_shop;

public class NoKidsException extends Exception {

    public static int cnt;

    public NoKidsException() {
        super("애들은 가라");
        cnt++;
    }

    // 메시지 커스텀
    public NoKidsException(String message) {
        super(message);
        cnt++;
    }
}
