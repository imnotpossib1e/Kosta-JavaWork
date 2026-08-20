package ex0811.ch08.Problem6;

interface Soundable {

    public String sound();
}

class Dog implements Soundable {

    @Override
    public String sound() {
        return "멍멍";
    }
}

class Cat implements Soundable {

    @Override
    public String sound() {
        return "야옹";
    }
}

/**
 * 6번
 */
public class SoundableExample {

    public static void printSound(Soundable soundable) {
        System.out.println(soundable.sound());
    }

    public static void main(String[] args) {
        printSound(new Cat());
        printSound(new Dog());
    }
}
