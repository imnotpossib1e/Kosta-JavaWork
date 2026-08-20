package ex0810.ch07.Problem10;

import javax.crypto.Mac;

/**
 * Ch.07 10번
 */
/* abstract 메소드가 있는 abstract 클래스를 상속받으려면
자식 클래스를 abstract 클래스로 선언하거나 부모 클래스의 abstract 메소드를 재정의해줘야한다.*/
public abstract class Machine {

    public void powerOn() {
    }

    public void powerOff() {
    }

    public abstract void work();
}

/*
class Computer extends Machine {

    public void work() {

    }
}
*/


abstract class Computer extends Machine {

}