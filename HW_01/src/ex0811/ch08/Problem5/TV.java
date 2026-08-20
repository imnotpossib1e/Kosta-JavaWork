package ex0811.ch08.Problem5;

interface Remocon {

    public void powerOn();
}

/**
 * 5번
 */
public class TV implements Remocon {

    @Override
    public void powerOn() {
        System.out.println("TV 전원을 켰습니다.");
    }

    public static void main(String[] args) {
        Remocon r = new TV();
        r.powerOn();
    }

}
