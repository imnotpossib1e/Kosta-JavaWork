package ex0810.abstract_final;

abstract class Animal{
    int legs;

    // 기능이 모호한 경우 abstract 메소드로 만든다
    // 선언부만 만들고 기능을 명확히 정의하지 못하는 경우
    public abstract void sound();
    public abstract void run();

    public void eat(){
        System.out.println("잘 먹는다.");
    }
}

// abstract 메소드를 상속받으려면 abstract 메소드들을 override 해줘야한다.
class Dog extends Animal{
    @Override
    public void sound(){
        System.out.println("멍멍");
    }

    @Override
    public void run(){
        System.out.println("잘 뛴다.");
    }

}

class Cat extends Animal{

    @Override
    public void sound() {
        System.out.println("야옹");
    }

    @Override
    public void run() {
        System.out.println("잘 뛰고 잘 올라간다.");
    }
}

class Pig extends Animal{

    @Override
    public void sound() {
        System.out.println("꿀꿀");
    }

    @Override
    public void run() {
        System.out.println("못 뛴다.");
    }

    @Override
    public void eat(){
        System.out.println("모든 것들을 잘 먹는다");
    }
}

public class AbstractExam {

    // 매개변수를 이요한 다형성
    public static void test(Animal animal){ // Cat or Dog or Pig -> 다형성으로 Animal을 넣는다.
        // 각 동물의 메소드 호출 - 부모타입이지만 재정의된 메소드는 자식 부분이 호출
        animal.sound();
        animal.eat();
        animal.run();
    }

    public static void main(String[] args) {
        Animal an = null;
        an = new Dog(); // 필드를 이용한 다형성
        test(an);

        an = new Cat();
        test(an);

        an = new Pig();
        test(an);
    }

}
