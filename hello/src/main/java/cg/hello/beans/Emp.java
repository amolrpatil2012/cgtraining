package cg.hello.beans;

import java.util.List;
import java.util.Map;

public class Emp {
	
	private int empid;
	private String empName;
	private int empSalary;
	private Address address;
	private List<String> mobileNos;
	private Map<String,String> skills; 
	
	public List<String> getMobileNos() {
		return mobileNos;
	}
	public void setMobileNos(List<String> mobileNos) {
		this.mobileNos = mobileNos;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(int empSalary) {
		this.empSalary = empSalary;
	}
	
	
	
	public Emp(int empid, String empName, int empSalary, Address address, List<String> mobileNos,
			Map<String, String> skills) {
		super();
		this.empid = empid;
		this.empName = empName;
		this.empSalary = empSalary;
		this.address = address;
		this.mobileNos = mobileNos;
		this.skills = skills;
	}
	public Map<String, String> getSkills() {
		return skills;
	}
	public void setSkills(Map<String, String> skills) {
		this.skills = skills;
	}
	public Emp() {}
	@Override
	public String toString() {
		return "Emp [empid=" + empid + ", empName=" + empName + ", empSalary=" + empSalary + ", address=" + address
				+ ", mobileNos=" + mobileNos + ", skills=" + skills + "]";
	}
	

}
