package ex0821;

import java.io.Serializable;

/**
 * Serializable 구현한 객체는 직렬화 대상이 된다.
 * 즉, 파일에 직렬화해서 저장할 수 있다
 */
public class Member implements Serializable {

    // 기존에 알고있던 객체인지(수정되었는지) 판단하는 시리얼 번호
    private static final long serialVersionUID = 1L;

    private String id;
    private int age;
    private transient String addr;

    public Member() {

    }

    public Member(String id, int age, String addr) {
        this.id = id;
        this.age = age;
        this.addr = addr;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        sb.append("id='").append(id).append('\'');
        sb.append(", age=").append(age);
        sb.append(", addr='").append(addr).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
