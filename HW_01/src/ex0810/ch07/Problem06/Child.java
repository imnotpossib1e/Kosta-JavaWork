package ex0810.ch07.Problem06;

public class Child extends Parent {

    public int studentNo;

    // 부모 생성자를 호출해서 초기화를 진행해야 한다.
    public Child(String name, int studentNo) {
        // super(); 생략되어있는데 부모 클래스에 기본 생성자가 없다.
        super(name);
        // this.name = name;
        this.studentNo = studentNo;
    }
}
