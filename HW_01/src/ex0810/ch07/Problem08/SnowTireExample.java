package ex0810.ch07.Problem08;


/**
 * Ch.07 8번
 */
public class SnowTireExample {

    public static void main(String[] args) {
        SnowTire snowTire = new SnowTire();
        Tire tire = snowTire;

        snowTire.run();
        tire.run();
    }
}

// 출력
// 스노우 타이어가 굴러갑니다.
// 스노우 타이어가 굴러갑니다.
