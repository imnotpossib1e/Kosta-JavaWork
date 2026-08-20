package ex0814.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class MapExam {

    // HashMap은 정렬 X
    Map<String, Integer> map = new HashMap<String, Integer>();
    // TreeMap은 key값 기준 정렬해준다
//    Map<String, Integer> map = new TreeMap<String, Integer>();

    public MapExam() {
        map.put("이름", 10);
        map.put("이름4", 20);
        map.put("이름2", 10);
        map.put("이름이", 30);
        map.put("이름", 10); // key가 중복되면 덮어쓰기가 된다 -> 이전 A의 value값이 10이 됨

        System.out.println("저장된 개수 = " + map.size());
        System.out.println("map = " + map);

        System.out.println("--- key와 value 분리 ---");

        // 먼저 key의 정보들을 추출한다
        // key 값들을 Set으로 꺼내옴
        Set<String> keys = map.keySet();
        Iterator<String> it = keys.iterator();
        while (it.hasNext()) {
            String key = it.next();
            int value = map.get(key);
            System.out.println(key + " = " + value);
        }
        // 개선된 for문
        for (String key : map.keySet()) {
            int value = map.get(key);
            System.out.println(key + " = " + value);
        }

        System.out.println("---Entry 형태로 조회하기---");
        Set<Map.Entry<String, Integer>> set = map.entrySet();
        for (Map.Entry<String, Integer> e : set) {
            String key = e.getKey();
            Integer i = e.getValue();
            System.out.println(key + " ==> " + i);
        }

        // 삭제
        Integer re = map.remove("이름9"); // 삭제한 value 리턴, 존재하지 않으면 null 리턴
        System.out.println("re = " + re);
        System.out.println("map = " + map);

    }

    public static void main(String[] args) {
        new MapExam();
    }
}
