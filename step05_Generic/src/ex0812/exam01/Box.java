package ex0812.exam01;
// Generic 사용 이전 -> Object 사용
/*
public class Box {
    // content 안에 들어갈 내용이 숫자, 문자 등등 객체로 다양하다
    // -> 최고 객체인 Object 사용
    private Object content;

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }


}
*/

// Generic 사용

/**
 * Generic은 결정되지 않은 타입을 실행 시 구체적인 타입으로 결정하는 것
 * <p>
 * <>안에 대문자 알파벳으로 선언
 */
public class Box<T> {

    private T content;

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }
}