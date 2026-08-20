package ex0810.superkeyword;

class Animal {
    int age = 5;
    String bodyColor = "blue";

    public void sound() {
        System.out.println("super의 sound call");
    }

    public void eat() {
        System.out.println("super의 eat call");
    }

}

class Cat extends Animal { // Cat is a Animal 성립
    int age = 10;
    int weight;

    @Override // annotation @: 클래스, 메소드, 필드 위에 선언
    public void sound() {
        System.out.println("Cat의 sound call");
    }

    public void run() {
        System.out.println("Cat이 run call");
    }

    public void test() {
        System.out.println(age);
        System.out.println(this.age);
        System.out.println(super.age);

        System.out.println("------------------------------------");

        System.out.println(bodyColor);
        System.out.println(this.bodyColor);
        System.out.println(super.bodyColor);

        System.out.println("------------------------------------");

        System.out.println(weight);
        System.out.println(this.weight);
//			System.out.println(super.weight); // error 부모에 없는 필드

        System.out.println("------메소드 호출------");

        sound();
        this.sound();
        super.sound();

        System.out.println("---------------------");

        eat();
        this.eat();
        super.eat();

        System.out.println("---------------------");

        run();
        this.run();
//		super.run(); // error 부모에 없는 메소드

    }
}

public class InheritanceFieldMethodExam {


    public static void main(String[] args) {

//			Cat cat = new Cat();
//			cat.test();
        int a;

				
        Cat cat = new Cat(); // 부모것도 자식것도 사용 가능
        System.out.println(cat.age); // 10
        System.out.println(cat.bodyColor); // blue
        System.out.println(cat.weight); // 0

        cat.sound(); // Cat
        cat.eat(); // Animal
        cat.run(); // Cat

        System.out.println("----------다형성-----------------");
        Animal an = new Cat(); // 부모것만 사용 가능 - 재정의된 메소드는 자식것 사용 가능
        System.out.println(an.age); // 5
        System.out.println(an.bodyColor); // blue
//		System.out.println(an.weight); // error -> 자식 필드 접근 불가능 -> 캐스팅 필요

        an.sound(); // Cat -> 부모타입이더도 재정의된 메소드는 자식 메소드 호출
        an.eat(); // Animal
//		an.run(); // error -> 캐스팅 필요

        System.out.println("an주소 = " + an);

        // Object Down Casting
//		if (an instanceof Cat) {
//			Cat c = (Cat) an;
//			System.out.println("c 주소 = " + c);
//			System.out.println(c.weight);
//			c.run();
//		}

        // 내부적으로 바로 캐스팅해주는 새로운 문법
        // true일때만 담아준다
        if (an instanceof Cat c) {
            System.out.println("c주소 = " + c);
            System.out.println(c.weight);
            c.run();
        }

    }

}
