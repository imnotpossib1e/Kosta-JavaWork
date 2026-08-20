package ex0814.set;

public class Member {

    private String name;
    private int age;
    private String addr;

    public Member() {

    }

    public Member(String name, int age, String addr) {
        this.name = name;
        this.age = age;
        this.addr = addr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Member{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", addr='").append(addr).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        System.out.println(1);

        // 객체는 모두 해시코드를 갖고있다.
        // 이름이 같지 않게 하고싶다 -> 이름의 해시코드 리턴
        // 나이도 같지 않게 하고싶다 -> 나이를 더한다(int는 해시코드가 없다)
        return name.hashCode() + age;
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println(2);

        // 텍스트가 달라도 해시코드가 같을 수 있다
        // 따라서 equals에서 2차 비교를 해준다
        if (obj instanceof Member m) {
            // 인수의 문자열과 내가 갖고있는 문자열 비교
            return name.equals(m.getName()) && age == m.getAge();
        }

        // 캐스팅 안 된 경우 false
        return false;
    }
}
