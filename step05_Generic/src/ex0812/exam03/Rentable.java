package ex0812.exam03;

public interface Rentable<T> {

    // public abstract 메소드 정의
    // Car 타입,Home 타입 둘 다 들어갈 수 있에 제네릭 사용
    T rent();
}
