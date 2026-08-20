package ex0813.exam05;

/**
 * 강좌를 등록하는 객체
 */
public class Course {

    // 타입을 사용할 때 와일드 카드 사용

    /**
     * 모든 사람을 허용(등록)
     */
    public void register01(Applicant<?> applicant) { // 와일드카드 - 모든 타입 허용
        System.out.println(applicant.getKind().getClass().getSimpleName() + "신청 완료 - register01");
    }

    /**
     * 직장인만 허용(등록)
     */
    public void register02(Applicant<? super Worker> applicant) { // 와일드카드 - 하한(직장인만) 허용
        System.out.println(applicant.getKind().getClass().getSimpleName() + "신청 완료 - register02");
    }


    /**
     * 학생들만 허용(등록)
     */
    public void register03(Applicant<? extends Student> applicant) { // 와일드카드 - 상한(학생만) 허용
        System.out.println(applicant.getKind().getClass().getSimpleName() + "신청 완료 - register03");
    }
}
