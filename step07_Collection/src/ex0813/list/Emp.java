package ex0813.list;

/**
 * 사원정보
 * Collections.sort를 사용하기 위해 Comparable 구현
 */
public class Emp implements Comparable<Emp> {

    private int empno; // 사원 번호
    private String ename; // 사원 이름
    private int age; // 나이
    private String addr; // 주소

    public Emp() {

    }

    public Emp(int empno, String ename, int age, String addr) {
        this.empno = empno;
        this.ename = ename;
        this.age = age;
        this.addr = addr;
    }

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
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
        final StringBuffer sb = new StringBuffer("Emp{");
        sb.append("empno=").append(empno);
        sb.append(", ename='").append(ename).append('\'');
        sb.append(", age=").append(age);
        sb.append(", addr='").append(addr).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int compareTo(Emp o) {
        // 자기 자신 - 매개변수 (오름차순)
//        return empno - o.getEmpno();
        // 매개변수 - 자기 자신 (내림차순)
        return o.getEmpno() - empno;
    }
}
