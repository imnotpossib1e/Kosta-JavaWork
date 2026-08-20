package ex0807.report.inheritance;

public class PartTime extends Employee {
	private int timePay;

	public PartTime() {

	}

	public PartTime(int empNo, String empName, String job, int mgr, String hiredate, String deptName, int timePay) {
		super(empNo, empName, job, mgr, hiredate, deptName);
		this.timePay = timePay;
	}

	public int getTimePay() {
		return timePay;
	}

	public void setTimePay(int timePay) {
		this.timePay = timePay;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append(" | ");
		builder.append(timePay);
		return builder.toString();
	}

	@Override
	public void message() {
		System.out.printf("%s사원은 비정규직입니다.\n", getEmpName());
	}

}
