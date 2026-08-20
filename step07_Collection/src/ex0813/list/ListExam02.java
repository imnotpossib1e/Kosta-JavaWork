package ex0813.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

// 생성해서 사용하기
public class ListExam02 {

    List<Integer> list = new ArrayList<Integer>(5);
//    List는 다 같은 메소드를 사용한다
//    List<Integer> list = new LinkedList<Integer>();
//    List<Integer> list = new Vector<Integer>(5);


    ListExam02() {

        // 데이터 추가
        list.add(5);
        list.add(10);
        list.add(2);
        list.add(3);
        list.add(5);

        // ArrayList 저장된 객체의 수
        System.out.println("저장된 객체의 수 = " + list.size());

        // 개선된 for문
        // 다형성으로 인해 내가 곧 부모. 따라서 this를 사용
        for (int value : list) {
            System.out.println(value);
        }

        System.out.println("this = " + list); // this.toString() 호출

        // 제거
        list.remove(2); // 인덱스
        System.out.println("제거 후 this = " + list);

        // 정렬
        Collections.sort(list); // 오름차순
        System.out.println("정렬 후 this = " + list);
        Collections.sort(list, Collections.reverseOrder()); // 내림차순
        System.out.println("내림차 정렬 후 this = " + list);
    }

    public static void main(String[] args) {
        new ListExam02();
    }
}
