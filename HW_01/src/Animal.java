// 추상화


interface Animal {

    String sound();
}

class Dog implements Animal {

    @Override
    public String sound() {
        return "멍멍";
    }
}

class Cat implements Animal {

    @Override
    public String sound() {
        return "야옹";
    }
}

// 기능이 추가로 인한 클래스가 추가되어도 수정할 필요 X

class PrintSound {

    void print(Animal animal) {
        System.out.println(animal.sound());
    }
}

//class PrintSound {
//
//    void print(Animal animal) {
//        if (animal instanceof Cat) {
//            System.out.println("야옹");
//        } else if (animal instanceof Dog) {
//            System.out.println("멍멍");
//        }
//    }
//}


class Main {

    public static void main(String[] args) {
        PrintSound printSound = new PrintSound();

        Animal cat = new Cat();
        Animal dog = new Dog();

        printSound.print(cat);
        printSound.print(dog);
    }
}
