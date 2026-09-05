package kosta.db.dto;

// empno, ename, job, sal, hiredate
public class EmpDTO {

    private int empNO;
    private String eName;
    private String job;
    private int sal;
    private String hireDate;

    public EmpDTO() {

    }

    public EmpDTO(int empNO, String eName, String job, int sal, String hireDate) {
        this.empNO = empNO;
        this.eName = eName;
        this.job = job;
        this.sal = sal;
        this.hireDate = hireDate;
    }

    public int getEmpNO() {
        return empNO;
    }

    public void setEmpNO(int empNO) {
        this.empNO = empNO;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getSal() {
        return sal;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("EmpDTO{");
        sb.append("empNO=").append(empNO);
        sb.append(", eName='").append(eName).append('\'');
        sb.append(", job='").append(job).append('\'');
        sb.append(", sal=").append(sal);
        sb.append(", hireDate='").append(hireDate).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
