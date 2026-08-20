package ex0813.list;

import java.util.ArrayList;
import java.util.Collections;

// 상속받아서 사용하기
public class ListExam01 extends ArrayList<Integer> {

    ListExam01() {
        // ArrayList의 기본 생성자 호출
        // super() // 기본 10개 공간 생성
        super(5); // 5개 공간을 만든다

        // 데이터 추가
        super.add(5);
        this.add(10);
        add(2);
        add(3);
        add(2);
        add(8);
        add(9);
        add(1);

        // ArrayList 저장된 객체의 수
        System.out.println("저장된 객체의 수 = " + super.size());

        // 요소 꺼내기
//        for (int i = 0; i < super.size(); i++) {
//            int value = super.get(i);
//            System.out.println(value);
//        }

        // 개선된 for문
        // 다형성으로 인해 내가 곧 부모. 따라서 this를 사용
        for (int value : this) {
            System.out.println(value);
        }

        System.out.println("this = " + this); // this.toString() 호출

        // 제거
        super.remove(2); // 인덱스
        System.out.println("제거 후 this = " + this);

        // 정렬
        Collections.sort(this); // 오름차순
        System.out.println("정렬 후 this = " + this);
        Collections.sort(this, Collections.reverseOrder()); // 내림차순
        System.out.println("내림차 정렬 후 this = " + this);
    }

    public static void main(String[] args) {
        new ListExam01();
    }
}
