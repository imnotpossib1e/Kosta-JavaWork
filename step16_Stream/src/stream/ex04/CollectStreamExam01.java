package stream.ex04;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectStreamExam01 {

    public static void main(String[] args) {
        List<Student> totalList = new ArrayList<>();
        totalList.add(new Student("장희정", "남", 92));
        totalList.add(new Student("하승현", "여", 87));
        totalList.add(new Student("오문정", "남", 95));
        totalList.add(new Student("김은영", "여", 93));

        //문제) 학생들중 남학생만 뽑아 새로운 List로 만들자

        System.out.println("1.학생들중 남학생만 뽑아 새로운 List로 만들자 - collect()");
        // 수정 가능, null값 허용
        List<Student> boyList = totalList.stream()
            .filter(s -> s.getGender().equals("남"))
            .collect(Collectors.toList());

        // 수정
        boyList.add(new Student("안녕", "남", 33));

        boyList.forEach(System.out::println);

        System.out.println("2.학생들중 남학생만 뽑아 새로운 List로 만들자 - toList()");
        // 수정 불가, null값 불허
        List<Student> boyList2 = totalList.stream()
            .filter(s -> s.getGender().equals("남"))
            .toList();

        // 수정 -> 에러 발생
//        boyList2.add(new Student("안녕", "남", 33));

        boyList2.forEach(System.out::println);

        System.out.println("----toMap<K, V> 사용해보자-------");
        System.out.println("3.학생들정보를 이름을 key , 점수를 value 만들이서 Map 리턴해보자");
        Map<String, Integer> stMap = totalList.stream()
            .collect(Collectors.toMap(Student::getName /*키*/, Student::getScore /*값*/));

        System.out.println(stMap);
    }

}














