package ex0807.report.inheritance;

public abstract class Employee {
	private int empNo;
	private String empName;
	private String job;
	private int mgr;
	private String hiredate;
	private String deptName;

	public Employee() {

	}

	public Employee(int empNo, String empName, String job, int mgr, String hiredate, String deptName) {
		this.empNo = empNo;
		this.empName = empName;
		this.job = job;
		this.mgr = mgr;
		this.hiredate = hiredate;
		this.deptName = deptName;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getMgr() {
		return mgr;
	}

	public void setMgr(int mgr) {
		this.mgr = mgr;
	}

	public String getHiredate() {
		return hiredate;
	}

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(empNo);
		builder.append(" | ");
		builder.append(empName);
		builder.append(" | ");
		builder.append(job);
		builder.append(" | ");
		builder.append(mgr);
		builder.append(" | ");
		builder.append(hiredate);
		builder.append(" | ");
		builder.append(deptName);
		return builder.toString();
	}

	public abstract void message();
}
