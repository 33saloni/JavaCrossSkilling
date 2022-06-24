package com.capg.bean;
import java.time.LocalDate;
public class Employee {
	private Integer employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private LocalDate hireDate;
	private String designation;
	private Double salary;
	private Integer managerId;
	private Department department;
	private String Manager_Name;
	public Employee(Integer employeeId, String firstName, String lastName, String email, String phoneNumber,
			LocalDate hireDate, String designation, Double salary, Integer managerId,String M_name, Department department) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.hireDate = hireDate;
		this.designation = designation;
		this.salary = salary;
		this.managerId = managerId;
		this.department = department;
		this.Manager_Name = M_name;
	}
	public Integer getEmployeeId() {
		return employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getEmail() {
		return email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public LocalDate getHireDate() {
		return hireDate;
	}
	public String getDesignation() {
		return designation;
	}
	public Double getSalary() {
		return salary;
	}
	public Integer getManagerId() {
		return managerId;
	}
	public  Department getDepartment() {
		return department;
	}
	
	public String getManager_Name() {
		return Manager_Name;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", phoneNumber=" + phoneNumber + ", hireDate=" + hireDate + ", designation=" + designation
				+ ", salary=" + salary + ", managerId=" + managerId + ", department=" + department + "]";
	}
	
}
