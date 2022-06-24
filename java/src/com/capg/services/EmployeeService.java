package com.capg.services;
import java.util.stream.*;
import com.capg.repo.*;
import com.capg.bean.Employee;
import com.capg.bean.Department;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.TextStyle;
import java.util.*;

public class EmployeeService {
	
	public static void main(String [] args) {
		List<Employee> list = EmployeeRepository.getReposit();
		List<String> depts = new ArrayList<>();
		List<Integer> max_emp = new ArrayList<>();
		
		
		//1-sum employee salaries of all employees
		System.out.println("Sum of salary of all employees\n");
		Optional<Double> salary = list.stream().map(n->n.getSalary()).reduce((total,elements)->total+elements);
		System.out.println("Sum of Salaries :"+salary.get());
		System.out.println("\n-----------------------------------------------------------------------------------------");

		//2-Number of Employees in each department
		System.out.println("Number of Employees in each department\n");
		Map<String, List<Employee>> count = list.stream().filter((n)->n.getDepartment()!=null).collect(Collectors.groupingBy(((Employee)->Employee.getDepartment().getDepartment_Name())));
		for(String name : count.keySet()) {
			System.out.println(name + " :  "+count.get(name).size());
			max_emp.add(count.get(name).size());
			depts.add(name);
		}
		System.out.println("\n-----------------------------------------------------------------------------------------");

		//3-Department with maximum Employees
		System.out.println("\nDepartment with maximun Employees\n");
		Integer max = max_emp.stream().max(Integer::compare).get();
		for(String name : count.keySet()) {
			if(count.get(name).size()==max) {
				System.out.println(name);
			}
		}
		System.out.println("\n-----------------------------------------------------------------------------------------");
		
		//15-Departments without Employees
		System.out.println("Departments without Employees\n");
		List<String> departments = EmployeeRepository.getDep().stream().map(n->n.getDepartment_Name()).collect(Collectors.toList());
		List<String> difference = departments.stream().filter(n->!depts.contains(n)).collect(Collectors.toList());
		difference.forEach(System.out::println);
		System.out.println("\n-----------------------------------------------------------------------------------------");

		//4-Senior most
		System.out.println("Senior-Most Employee\n");
	    Integer max_year = list.stream().map((n)-> Period.between(n.getHireDate(),LocalDate.now()).getYears()).max(Integer::compare).get();
	    List<Employee> senior_most = list.stream().filter((n)-> Period.between(n.getHireDate(),LocalDate.now()).getYears()==max_year).collect(Collectors.toList());
	    senior_most.forEach(System.out::println);
	    System.out.println("\n-----------------------------------------------------------------------------------------");
	

		//5-employees with no department
		List<Employee> emp = list.stream().filter((n)->n.getDepartment()==null).collect(Collectors.toList());
		System.out.println("Employees without any department\n");
		emp.forEach(System.out::println);
		System.out.println("\n-----------------------------------------------------------------------------------------");
	   
		//6-Date and Day of joining of employees
		System.out.println("Hiring information \n");
		list.forEach((n)->System.out.println("Name : "+n.getFirstName()+" "+n.getLastName()+" | Date-of-Joining : "+n.getHireDate().getDayOfMonth()+"| Joining-Day :"+n.getHireDate().getDayOfWeek()));
		System.out.println("\n-----------------------------------------------------------------------------------------");
									
		 //7-employee name with duration
	    System.out.println("\nList employee name and duration of their service in months and days.\n");
	    list.forEach((n)->{ int years = Period.between(n.getHireDate(),LocalDate.now()).getYears();  System.out.println("Name : "+n.getFirstName()+" "+n.getLastName()+" |Months : "+((Period.between(n.getHireDate(),LocalDate.now()).getMonths())+years*12)+" |Days : "+Period.between(n.getHireDate(),LocalDate.now()).getDays());});
		System.out.println("\n-----------------------------------------------------------------------------------------");
	   
	    //8-sorting by employee id
	    Comparator<Employee> cmp = (e1,e2)->  e1.getEmployeeId()- e2.getEmployeeId();
	    System.out.println("\nsorted by employee id\n");
	    list.stream().sorted(cmp).forEach(System.out::println);
	    System.out.println("\n-----------------------------------------------------------------------------------------");
	  
	    //9-sorting by department id 
	    System.out.println("\nsorted by Department id\n");
	    Comparator<Employee> dep = (e1,e2)-> e1.getDepartment().getDepartment_Id()-e2.getDepartment().getDepartment_Id();
	    list.stream().filter((n)->n.getDepartment()!=null).sorted(dep).forEach(System.out::println);
	    System.out.println("\n-----------------------------------------------------------------------------------------");
	   
	    //10-sorting by first name
	    System.out.println("\nsorted by First Name\n");
	    Comparator<Employee> fname = (e1,e2)-> e1.getFirstName().compareTo(e2.getFirstName());
	    list.stream().sorted(fname).forEach(System.out::println);
	    System.out.println("\n-----------------------------------------------------------------------------------------");

	    //11-employee name, salary and salary increased by 15%. 
	    System.out.println("\n15% increased salary\n");
		list.forEach((n)->System.out.println("Name : "+n.getFirstName()+" "+n.getLastName()+" |Salary : "+n.getSalary()+" |Increased Salary : "+(n.getSalary()*0.15+n.getSalary())));
	    System.out.println("\n-----------------------------------------------------------------------------------------");
	  
	    //12-employee name with duration
	    System.out.println("\nList employee name and duration of their service in months and days.\n");
	    list.forEach((n)->{ int years = Period.between(n.getHireDate(),LocalDate.now()).getYears();  System.out.println("Name : "+n.getFirstName()+" "+n.getLastName()+" |Months : "+((Period.between(n.getHireDate(),LocalDate.now()).getMonths())+years*12)+" |Days : "+Period.between(n.getHireDate(),LocalDate.now()).getDays());});
	    System.out.println("\n-----------------------------------------------------------------------------------------");

	    //13-manager name of employees
	    System.out.println("Employees with their reporting manager\n");
	    list.forEach((n)->{if(n.getManagerId()!=0)System.out.println(n.getFirstName()+" "+n.getLastName()+" reports to "+n.getManager_Name());});
	    System.out.println("\n-----------------------------------------------------------------------------------------");

	    //14-employees without manager
	    List<Employee> no_manager = list.stream().filter((n)->n.getManagerId()==0).collect(Collectors.toList());
		System.out.println("\nEmployees without Manager\n");
	    no_manager.forEach(System.out::println);
	    System.out.println("\n-----------------------------------------------------------------------------------------");
	
	   //16-Friday joining employees
	    System.out.println("Who joined on Friday\n");
	    list.forEach(n->{if(n.getHireDate().getDayOfWeek().getValue()==5)System.out.println("Name : "+n.getFirstName()+" "+n.getLastName());});
	    System.out.println("\n-----------------------------------------------------------------------------------------");

	    getSubordinates (list) ;
	    
	    }
	//manager's subordinates
	   static void getSubordinates (List<Employee> list) {
		 System.out.println("\nEnter the name of Manager\n");
		 Scanner sc = new Scanner(System.in);
		 String name =sc.next();
		 System.out.println("Subordinates of "+(name.substring(0,1).toUpperCase()+name.substring(1))+" :\n");
		  for(Employee emp:list)
		  {
			  if(emp.getDepartment()!=null  && emp.getManager_Name().toLowerCase().equals(name.toLowerCase()))
				  System.out.println(emp.getFirstName()+" "+emp.getLastName());
		  }
			  
	   }
	   }
