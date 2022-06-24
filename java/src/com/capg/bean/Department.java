package com.capg.bean;

public class Department {
		private Integer Department_Id;
		private String Department_Name;
		private Integer Manager_Id;
		
		public Department(Integer department_Id, String department_Name, Integer manager_Id) {
			super();
			Department_Id = department_Id;
			Department_Name = department_Name;
			Manager_Id = manager_Id;
		}
		public Integer getDepartment_Id() {
			return Department_Id;
		}
		public String getDepartment_Name() {
			return Department_Name;
		}
		public Integer getManager_Id() {
			return Manager_Id;
		}
		public void setDepartment_Id(Integer department_Id) {
			Department_Id = department_Id;
		}
		public void setDepartment_Name(String department_Name) {
			Department_Name = department_Name;
		}
		public void setManager_Id(Integer manager_Id) {
			Manager_Id = manager_Id;
		}
		@Override
		public String toString() {
			return "Department [Department_Id=" + Department_Id + ", Department_Name=" + Department_Name
					+ ", Manager_Id=" + Manager_Id + "]";
		}
		
		
}
