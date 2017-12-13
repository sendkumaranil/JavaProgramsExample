package com.example.serialization;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public class ComparatorDemo {

	public static void main(String[] args) {

		MyEmployee emp1=new MyEmployee();
		emp1.setEmpid(1004);
		emp1.setEmpname("Mukund");
		emp1.setSalary(4500.12f);
		
		MyEmployee emp2=new MyEmployee();
		emp2.setEmpid(1003);
		emp2.setEmpname("Bihari");
		emp2.setSalary(2500.12f);
		
		MyEmployee emp3=new MyEmployee();
		emp3.setEmpid(1005);
		emp3.setEmpname("Anil");
		emp3.setSalary(1500.12f);
		
		MyEmployee emp4=new MyEmployee();
		emp4.setEmpid(1002);
		emp4.setEmpname("Verma");
		emp4.setSalary(7514.12f);
		
		MyEmployee emp5=new MyEmployee();
		emp5.setEmpid(1001);
		emp5.setEmpname("Trish");
		emp5.setSalary(4500.12f);
		
		List<MyEmployee> myemplist=new ArrayList<MyEmployee>();
		myemplist.add(emp1);
		myemplist.add(emp2);
		myemplist.add(emp3);
		myemplist.add(emp4);
		myemplist.add(emp5);
		
		System.out.println("Before sorting:");
		for(MyEmployee emp:myemplist){
			System.out.println("EmpId:"+emp.getEmpid());
			System.out.println("Empname:"+emp.getEmpname());
			System.out.println("Salary:"+emp.getSalary());
		}
		System.out.println("---------After sorting by Id:----------");
		//class implementation
		//Collections.sort(myemplist,new EmployeeSortById());
		
		//Anonymously implementetion
		Collections.sort(myemplist,new Comparator<MyEmployee>(){
			@Override
			public int compare(MyEmployee emp1, MyEmployee emp2) {
				if(emp1.getEmpid() < emp2.getEmpid()){
					return 1; //return -1 asseending order
				}else if(emp1.getEmpid() > emp2.getEmpid()){
					return -1; // return 1 assecending order
				}
				return 0;
			}
		});
		
		for(MyEmployee emp:myemplist){
			System.out.println("EmpId:"+emp.getEmpid());
			System.out.println("Empname:"+emp.getEmpname());
			System.out.println("Salary:"+emp.getSalary());
		}
		System.out.println("--------After sort by Name:-----------");
		
		Collections.sort(myemplist,new EmployeeSortByName());
		
		for(MyEmployee emp:myemplist){
			System.out.println("EmpId:"+emp.getEmpid());
			System.out.println("Empname:"+emp.getEmpname());
			System.out.println("Salary:"+emp.getSalary());
		}
		
		System.out.println("--------After sort by Salary:---------");
		
		Collections.sort(myemplist,new EmployeeSortBySalary());
		
		for(MyEmployee emp:myemplist){
			System.out.println("EmpId:"+emp.getEmpid());
			System.out.println("Empname:"+emp.getEmpname());
			System.out.println("Salary:"+emp.getSalary());
		}
	}
}
class MyEmployee{
	private int empid;
	private String empname;
	private float salary;
	
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
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
}

/*class EmployeeSortById implements Comparator<MyEmployee>{

	@Override
	public int compare(MyEmployee emp1, MyEmployee emp2) {
		if(emp1.getEmpid() < emp2.getEmpid()){
			return 1; //return -1 asseending order
		}else if(emp1.getEmpid() > emp2.getEmpid()){
			return -1; // return 1 assecending order
		}
		return 0;
	}
}*/

class EmployeeSortByName implements Comparator<MyEmployee>{
	
	public int compare(MyEmployee emp1, MyEmployee emp2) {
		
		if(emp1.getEmpname().compareTo(emp2.getEmpname()) < 1){
			return -1; //return -1 descending order 
		}else if(emp1.getEmpname().compareTo(emp2.getEmpname()) > 1){
			return 1; // return 1 descending order
		}
		
		return 0;
	}
}

class EmployeeSortBySalary implements Comparator<MyEmployee>{
	
	public int compare(MyEmployee emp1, MyEmployee emp2) {
		
		if(emp1.getSalary() < emp2.getSalary()){
			return -1; //return 1 descending order
		}else if(emp1.getSalary() > emp2.getSalary()){
			return 1; //return -1 descending order
		}
		
		return 0;
	}
}