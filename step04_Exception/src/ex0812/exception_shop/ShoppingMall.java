package ex0812.exception_shop;

public class ShoppingMall {

    public void ageCheck(int age) throws NoKidsException {

        // throw(던지기)
        if (age < 18) {
            throw new NoKidsException(age + "살 출입 금지");
        } else {
            System.out.println(age + "살 입장하신 걸 환영합니다.");
        }

        // 직접 처리
//        try {
//            if (age < 18) {
//                throw new NoKidsException("성인만 오세요.");
//            }
//        } catch (NoKidsException e) {
//            System.out.println(e.getMessage());
//        }

    }
}
