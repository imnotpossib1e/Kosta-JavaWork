package ex0812.exception_shop;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random r = new Random();

        for (int i = 0; i < 10; i++) {
            int age = r.nextInt(55) + 1;
            try {
                new ShoppingMall().ageCheck(age);
            } catch (NoKidsException e) {
                System.out.println(e.getMessage());
            }

        }

        System.out.println(NoKidsException.cnt);
    }

}
