package ex0813.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListExam03 extends ArrayList<Emp> {

    public ListExam03() {
        // 사원 저장
        super.add(new Emp(20, "김이름", 20, "서울"));
        super.add(new Emp(10, "qwe", 50, "대전"));
        super.add(new Emp(40, "asd", 40, "서울"));
        super.add(new Emp(30, "zxc", 90, "대구"));
        super.add(new Emp(50, "rty", 26, "경기"));
    }

    /**
     * 저장된 모든 사원의 정보 검색
     * Emp 타입의 리스트 리턴
     * 구현체를 ArrayList로 고정하지 않고, List 인터페이스 타입으로 반환한다.
     * 이렇게 하면 내부 구현이 ArrayList → LinkedList 등으로 바뀌어도
     * 메서드 시그니처에 영향을 주지 않아 유지보수가 쉬워진다.
     */
    public List<Emp> selectAll() {
        return this;
    }

    /**
     * 사원의 사원번호에 해당하는 사원정보 검색
     *
     * @return 잇으면 Emp 객체, 없으면 null
     */
    public Emp selectByEmpno(int empno) {
        for (Emp e : this) {
            if (e.getEmpno() == empno) {
                return e;
            }
        }
        return null;
    }

    /**
     * 주소를 인수로 전달받아 동일한 주소에 해당하는 사원 정보 검색
     * 0개 이상의 배열을 갖는 자료구조는 List를 사용
     */
    public List<Emp> selectByAddr(String addr) {
        List<Emp> re = new ArrayList<Emp>();
        for (Emp e : this) {
            if (e.getAddr().equals(addr)) {
                re.add(e);
            }
        }
        return re;
    }

    /**
     * 사원번호를 기준으로 사원 정보 정렬하기
     *
     * Integer는 이미 Comparable을 구현한 객체
     * sort를 하기 위한 객체는 반드시 Comparable을 구현한 객체여야 한다.
     */
    public List<Emp> sortByEmpno() {
        // 원본 리스트 복사
        List<Emp> shallowCopy = new ArrayList<Emp>(this);
        // Collections.sort를 쓰려면 리스트 요소는 반드시 Comparable을 구현해야한다.
        // -> Emp 클래스에 Comparable 을 구현하고 재정의
        Collections.sort(shallowCopy);
        return shallowCopy;
    }


    /**
     * 나이를 기준으로 사원 정보 정렬하기
     */
    public List<Emp> sortByAge() {
        List<Emp> shallowcopy = new ArrayList<Emp>(this);
        // 람다 사용 X
//        Collections.sort(shallowcopy, new Test());

        // 익명 이너 타입 선언
//        Collections.sort(shallowcopy, new Comparator<Emp>() {
//            @Override
//            public int compare(Emp o1, Emp o2) {
//                return o2.getAge() - o1.getAge(); // 내림차순
//            }
//        });

        // Lambda식 사용
        Collections.sort(shallowcopy, (o1, o2) -> (o1.getAge() - o2.getAge()));

        return shallowcopy;
    }


    public static void main(String[] args) {
        // 리스트 객체 생성
        ListExam03 ex = new ListExam03();

        // Emp 타입의 리스트를 받음
        List<Emp> list = ex.selectAll();
        for (Emp e : list) {
            System.out.println(e);
        }

        System.out.println("2. 사원번호에 해당하는 사원정보 검색");
        Emp e = ex.selectByEmpno(40);
        System.out.println(e);

        System.out.println("3. 주소에 해당하는 정보");
        List<Emp> findList = ex.selectByAddr("서울");
        System.out.println(findList);

        System.out.println("4. 사원번호 순으로 정렬");
        List<Emp> sortedList = ex.sortByEmpno();
        for (Emp emp : sortedList) {
            System.out.println(emp);
        }

        System.out.println("5. 정렬 후 전체 검색");
        List<Emp> list2 = ex.selectAll();
        for (Emp e2 : list2) {
            System.out.println(e2);
        }

        System.out.println("6. 나이 순으로 정렬");
        List<Emp> sortedList2 = ex.sortByAge();
        for (Emp emp : sortedList2) {
            System.out.println(emp);
        }
    }
}
//
//class Test implements Comparator<Emp> {
//
//    @Override
//    public int compare(Emp o1, Emp o2) {
//        return o1.getAge() - o2.getAge(); // 오름차 순
//    }
//}
