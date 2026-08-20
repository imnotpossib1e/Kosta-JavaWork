package ex0813;

/**
 * @FunctionalInterface -  메소드가 한개일 때 선언
 * 단, 기능이 있는 default, static이 있는 경우에도 쓸 수 있다.
 */
public interface AInterface {

    void aa();

    // 재정의가 필요 없는 메소드는 있어도 무관하다.
    default void ff() {
    }
}
