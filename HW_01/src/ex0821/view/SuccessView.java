package ex0821.view;

import ex0821.dto.Profile;

public class SuccessView {

    /**
     * 성공 메세지 출력
     *
     * @param message
     */
    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printSearchProfile(Profile profile) {
        System.out.println("***************************************************");
        System.out.println(
            "\t\t\t 현재 " + profile.getName() + "님의 몸무게는 " + profile.getWeight() + " Kg 입니다.");
        System.out.println("***************************************************");
    }

    public static void printSearchPassword(Profile profile) {
        System.out.println("***************************************************");
        System.out.println(
            "\t\t\t 현재 " + profile.getName() + "님의 비밀번호는 " + profile.getPassword() + "  입니다.");
        System.out.println("\t\t\t변경할 비밀번호를 입력해 주세요.");
        System.out.println("***************************************************");
    }
}
