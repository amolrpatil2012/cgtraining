package cg.jdbcdemo;

public class Emp {

	private int empid;
	private String empname;
	private int empsalary;
	public Emp(int empid, String empname, int empsalary) {
		super();
		this.empid = empid;
		this.empname = empname;
		this.empsalary = empsalary;
	}
	@Override
	public String toString() {
		return "Emp [empid=" + empid + ", empname=" + empname + ", empsalary=" + empsalary + "]";
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public int getEmpsalary() {
		return empsalary;
	}
	public void setEmpsalary(int empsalary) {
		this.empsalary = empsalary;
	}
}
