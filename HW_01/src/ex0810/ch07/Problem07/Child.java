package ex0810.ch07.Problem07;

import ex0810.ch07.Problem07.Parent;

public class Child extends Parent {

    public String name;

    public Child() {
        this("홍길동");
        System.out.println("Child() call");
    }

    public Child(String name) {
        this.name = name;
        System.out.println("Child(String name) call");
    }

}
