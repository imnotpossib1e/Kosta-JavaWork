package test;


abstract class Animal {

    abstract String sound();
}

class Dog extends Animal {

    @Override
    String sound() {
        return "야옹";
    }
}

class Cat extends Animal {

    @Override
    String sound() {
        return "멍멍";
    }
}

class PrintSound {

    void print(Animal animal) {
        System.out.println(animal.sound());
    }
}


class Main {

    public static void main(String[] args) {
        PrintSound print = new PrintSound();

        Animal cat = new Cat();
        Animal dog = new Dog();

        print.print(cat);
        print.print(dog);
    }
}
