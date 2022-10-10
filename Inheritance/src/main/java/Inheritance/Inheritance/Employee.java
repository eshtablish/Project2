package Inheritance.Inheritance;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@DiscriminatorValue("Employee")
public class Employee {
	@Id
	private int EmpId;
	private String EmpName;
	public int getEmpId() {
		return EmpId;
	}
	public String getEmpName() {
		return EmpName;
	}
	public void setEmpName(String empName) {
		EmpName = empName;
	}
	public void setEmpId(int empId) {
		EmpId = empId;
	}
	
	@Override
	public String toString() {
		return "Employee [EmpId=" + EmpId + ", EmpName=" + EmpName + "]";
	}
}
