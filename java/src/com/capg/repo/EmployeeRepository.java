package com.capg.repo;
import com.capg.bean.*;

import java.time.LocalDate;
import java.util.*;
public class EmployeeRepository {
	private static final List<Employee> Reposit = new ArrayList<Employee>();
	private static final List<Department> Dep = new ArrayList<Department>();
	static {
		Dep.add( new Department(416,"Finance", 400));
		Dep.add( new Department(417,"Customer-Support", 600));
		Dep.add( new Department(418,"Sales", 800));
		Dep.add( new Department(419,"Help-Desk", 200));
		Dep.add( new Department(419,"Logistic", 200));
		Dep.add( new Department(419,"Food", 200));
		
	}
	
	static {
		
		Reposit.add(new Employee(101,"Saloni","Patil","Saloni33@gmail.com","7028995509",LocalDate.of(2021,06,15),"Analyst", 26824d, 200,"Sushila",Dep.get(0)));
		Reposit.add(new Employee(102,"Sandhesh","Darshani","Sand33@gmail.com","7028995478",LocalDate.of(2020,06,19),"Analyst", 26824d, 200,"Neeraj",Dep.get(3) ));
		Reposit.add(new Employee(106,"Pranjali","Mehta","Mehta21@gmail.com","9254995509",LocalDate.of(1980,02,05),"Design-Specialist", 260824d, 220,"Neeraj",Dep.get(2)));
		Reposit.add(new Employee(902,"Geeta","Pawar","PGeet21@gmail.com","7028426509",LocalDate.of(2002,8,12),"Developer", 126824d, 220,"Adam",Dep.get(2)));
		Reposit.add(new Employee(708,"Avneet","Bandhu","Avneet90@gmail.com","9528994409",LocalDate.of(2011,12,23),"Developer", 126824d, 221,"Adam",Dep.get(2)));
		Reposit.add(new Employee(107,"Satty","Gupta","Sattyi33@gmail.com","7045699550",LocalDate.of(2008,06,30),"Senior-Analyst", 29824d,0,null, null));
		
	}

	public static List<Employee> getReposit() {
	
		return Reposit;
	
	}

	public static List<Department> getDep() {
		return Dep;
	}
	
	
	
}
