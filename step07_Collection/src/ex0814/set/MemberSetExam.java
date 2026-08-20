package ex0814.set;

import java.util.HashSet;
import java.util.Set;

public class MemberSetExam {

    Set<Member> set = new HashSet<Member>();

    // 생성자 필수
    public MemberSetExam() {
        /**
         * 다른 객체라도 hashCode() 메소드의 리턴값(주소값)이 같고,
         * equals() 메소드가 true를 리턴면 동일한 객체라고 판단, 중복 저장하지 않음
         * -> Member 타입에서 hashCode와 equals를 오버라이딩 해준다
         */
        set.add(new Member("희정", 10, "서울"));
        set.add(new Member("유진", 20, "대전"));
        set.add(new Member("유진", 23, "부산"));

        System.out.println("저장된 객체의 수 = " + set.size());

    }

    public static void main(String[] args) {
        // 메인 메소드에 생성 필수
        new MemberSetExam();
    }
}
