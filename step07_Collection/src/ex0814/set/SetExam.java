package ex0814.set;

import com.sun.source.tree.Tree;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * 생성해서 Set - HashSet 사용하기
 */
public class SetExam {

    // HashSet 생성
//    Set<String> set = new HashSet<String>();

    // TreeSet 생성
//    Set<String> set = new TreeSet<String>();
    // TreeSet 역순 정렬 생성
    Set<String> set = new TreeSet<String>(Collections.reverseOrder());

    // 생성자를 만들어줘야 셋에 접근할 수 있다
    // 생성자에서 초기 데이터 설정 등...
    public SetExam(String[] data) {
        for (String s : data) {
            // 데이터 추가
            boolean re = set.add(s); // 중복 불가
            System.out.println(s + " add 후 결과 = " + re);
        }
        System.out.println("최종 결과 = " + set); // set.toString()
        System.out.println("저장된 개수 = " + set.size());

        // 요소 꺼내기
        System.out.println("요소 꺼내기");
        // Iterator는 자료구조 안에 있는 데이터를 꺼낼 수 있는 메소드 제공
        Iterator<String> it = set.iterator();

        while (it.hasNext()) { // hasNext()는 다음 요소가 있으면 true 리턴
            String s = it.next();
            System.out.println(s);
        }

        // 개선된 for문으로 변경
        System.out.println("----개선된 for문----");
        for (String s : set) {
            System.out.println(s);
        }

        // 요소 제거
        System.out.println("--- 요소 제거---");
        boolean re = set.remove("e");
        System.out.println("re = " + re);
        System.out.println("제거된 후 = " + set);

        // 있는지 없는지 체크
        re = set.contains("a");
        System.out.println("re = " + re);
    }

    public static void main(String[] args) {
        new SetExam(args);
    }
}
