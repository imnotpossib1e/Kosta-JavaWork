package ex0821.view;

import ex0821.controller.ProfileController;
import ex0821.dto.Profile;
import ex0821.service.ProfileService;
import java.sql.SQLOutput;
import java.util.PrimitiveIterator;
import java.util.Scanner;

public class MenuView {

    Scanner sc = new Scanner(System.in);
    ProfileController controller = new ProfileController();


    public void printMenu() {
        while (true) {
            System.out.println("다음 사항에 맞게 입력하여 주세요.");
            System.out.println("\t 몸무게 입력은 1번");
            System.out.println("\t 몸무게 검색은 2번");
            System.out.println("\t 몸무게 변경은 3번");
            System.out.println("\t 비밀번호 변경은 4번");
            System.out.println("\t 프로그램 종료는 5번");
            System.out.println("입력 후 Enter을 눌러 주세요.");
            System.out.print("메뉴 선택 : ");
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    this.inputProfile();
                    break;
                case "2":
                    this.searchProfile();
                    break;
                case "3":
                    this.updateWeight();
                    break;
                case "4":
                    this.updatePassword();
                    break;
                case "5":
                    System.exit(0);
                default:
                    System.out.println("메뉴를 다시 선택해 주세요.");
            }
        }
    }

    public void inputProfile() {
        System.out.println("\n이름을 입력해 주세요.");
        System.out.print("이름 : ");
        String name = sc.nextLine();
        System.out.println("\n몸무게를 입력해 주세요.");
        System.out.print("몸무게 : ");
        int weight = Integer.parseInt(sc.nextLine());
        System.out.println("\n비밀번호를 입력해 주세요.");
        System.out.print("비밀번호 : ");
        String password = sc.nextLine();

        Profile profile = new Profile(name, weight, password);

        controller.inputProfile(profile);
    }

    public Profile searchProfile() {
        int cnt = 0;
        System.out.println(cnt);
        while (cnt < 3) {

            System.out.println("\n검색할 이름을 입력해 주세요.");
            String name = sc.nextLine();
            System.out.println("\n비밀번호를 입력해 주세요.");
            String password = sc.nextLine();

            Profile searchProfile = controller.searchProfile(name, password);
            if (searchProfile != null) {
                return searchProfile;
            }
            System.out.println("비밀번호가 틀렸습니다.");
            cnt++;
        }
        return null;
    }

    public void updateWeight() {
        Profile searchProfile = this.searchProfile();

        if (searchProfile != null) {
            System.out.println("\t\t\t 변경할 몸무게를 입력해 주세요.");
            System.out.print("변경할 몸무게 : ");
            int newWeight = Integer.parseInt(sc.nextLine());

            controller.updateWeight(searchProfile, newWeight);
        }
    }

    public void updatePassword() {
        System.out.println("\n이름을 입력해 주세요.");
        System.out.print("이름 : ");
        String name = sc.nextLine();
        System.out.println("\n비밀번호를 입력해 주세요.");
        System.out.print("비밀번호 : ");
        String password = sc.nextLine();

        Profile profile = controller.updateSearchPassword(name, password);
        System.out.print("새로운 비밀번호 : ");
        String newPassword = sc.nextLine();
        controller.updatePassword(profile, newPassword);
    }
}
