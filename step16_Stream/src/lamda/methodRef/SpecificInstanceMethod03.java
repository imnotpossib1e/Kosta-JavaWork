package lamda.methodRef;

import java.util.function.BiFunction;

public class SpecificInstanceMethod03 {

    public static void main(String[] args) {
        // 기존방식
        // String: 매개변수1 String: 매개변수2 Boolean: 리턴타입
        BiFunction<String, String, Boolean> beforeEquals = new BiFunction<>() {
            @Override
            public Boolean apply(String s1, String s2) {
                return s1.equals(s2);
            }
        };

        //1. 람다식변경해보자
        BiFunction<String, String, Boolean> beforeEquals2 = (s1, s2) -> s1.equals(s2);

        //2. 메소드 참조로 변경해보자
        BiFunction<String, String, Boolean> beforeEquals3 = String::equals;

        //3. 호출해보자
        System.out.println(beforeEquals.apply("ss", "aa"));
        System.out.println(beforeEquals2.apply("ss", "aa"));
        System.out.println(beforeEquals3.apply("ss", "aa"));

    }
} 


