package ex0814.map;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * Properties
 * 외부의 properties 확장자 파일을 끌어올 때 사용
 */
public class PropertiesExam {

    // 모두 String이기 때문에 타입을 Map이라 하지 않는다.(캐스팅을 많이 해야함)
    // 부모인 HashTable을 사용
    Properties pro = new Properties();

    public PropertiesExam() {
        // 저장은 잘 사용하지 않는다
        pro.setProperty("id", "im");
        pro.setProperty("age", "10");

        // 값 꺼내기
        for (String key : pro.stringPropertyNames()) {
            String value = pro.getProperty(key);
            System.out.println(key + " = " + value);
        }


    }

    /**
     * 외부의 ~.properties파일을 로딩하는 방법 2가지
     * 1) IO를 이용한 방법 - 꺼내서 계속 사용할 때 유리
     * 2) ResourceBundle을 이용한 방법 - 한번 읽고 값 쓴 후 쓸 일 없을 때 유리
     *
     *
     * 1. this.getClass().getResourceAsStream("info.properties")
     * -> 현재 클래스가 있는 위에서부터 경로를 설정
     *
     * 2. this.getClass().getClassLoader().getResourceAsStream("a.properties");
     * -> this.getClass() 호출하면 classes폴더를 기준(bin)으로 경로를 잡는다.
     *
     * 3. 프로젝트 내 resources폴더 존재 ==> 정적문서(환경설정문서, schema, xml 문서)
     *
     *
     * 웹프로젝트
     * 1) back - resources
     * 2) front  - resources/css, js,img
     *
     */

    // 1) IO를 이용한 방법
    public void test01() throws Exception {
        System.out.println("=======================");
        pro.clear();//초기화

        // load는 a.properties 의 key와 value를 Map 형태로 만들어준다.
//        pro.load(new FileInputStream("src/ex0814/map/a.properties"));

        //2. 클래스 위치한 패키지 내에서 파일 로딩할때 - / 생략(상대경로)
        //PropertiesExam.class 클래스가 있는 위치(폴더)가 기준이된다!!!
//        InputStream inputStream =
//            PropertiesExam.class.getResourceAsStream("a.properties");
//        pro.load(inputStream);

        //3.클래스 위치한 패키지 내에서 파일 로딩할때 - / 생략(상대경로)
//        InputStream inpupStream =
//            this.getClass().getResourceAsStream("a.properties");
//        pro.load(inpupStream);

        //4.ClassLoader의 모든 경로에서 파일 읽음. 보통 resources 폴더의 파일 읽을때 사용.
        InputStream inpupStream =
            //this.getClass().getClassLoader().getResourceAsStream("ex0220/map/info.properties");
            this.getClass().getClassLoader().getResourceAsStream("dbInfo.properties");

        pro.load(inpupStream);

        //모든 key정보 가져오기
        for (String key : pro.stringPropertyNames()) {
            //저장된 정보 조회
            String value = pro.getProperty(key);
            System.out.println(key + " = " + value);
        }
    }//test01 End


    //2) ResourceBundle을 이용한 방법
    public void test02() {
        System.out.println("---test02() -----");

        //ResourceBundle 는 ~.properties파일을 로딩하는 전용 클래스
        // 읽어와서 끝이면(1회용) Resource 번들 사용
        ResourceBundle rb = ResourceBundle.getBundle("dbInfo");//classes폴더를 기준으로 a.properties 로딩
        for (String key : rb.keySet()) {
            String value = rb.getString(key);
            System.out.println(key + " = " + value);
        }

    }

    public static void main(String[] args) throws Exception {
//        new PropertiesExam();

        PropertiesExam pe = new PropertiesExam();
        System.out.println("------");

//        pe.test01();

        pe.test02();
    }


}
