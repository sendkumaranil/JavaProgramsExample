package com.example.serialization;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableDemo {

	
	public static void main(String[] args) {

		Student student1=new Student();
		student1.setName("Krish");
		student1.setRollno(1007);
		
		Student student2=new Student();
		student2.setName("Jay");
		student2.setRollno(1002);
		
		Student student3=new Student();
		student3.setName("Anil");
		student3.setRollno(1005);
		
		Student student4=new Student();
		student4.setName("Smriti");
		student4.setRollno(1003);
		
		Student student5=new Student();
		student5.setName("Binod");
		student5.setRollno(1001);
		
		List<Student> stdlist=new ArrayList<Student>();
		
		stdlist.add(student1);
		stdlist.add(student2);
		stdlist.add(student3);
		stdlist.add(student4);
		stdlist.add(student5);
		System.out.println("before sort");
		
		for(Student s:stdlist){
			System.out.println("Name:"+s.getName());
			System.out.println("RollNo:"+s.getRollno());
		}
		System.out.println("After sort:");
		Collections.sort(stdlist);
		
		for(Student s:stdlist){
			System.out.println("Name:"+s.getName());
			System.out.println("RollNo:"+s.getRollno());
		}
	}
}
class Student implements Comparable<Student>{
	private String name;
	private int rollno;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	
	@Override
	public int compareTo(Student std) {
		if(this.rollno < std.rollno){
			return -1;
		}else if(this.rollno > std.rollno){
			return 1;
		}
		return 0;	
	}
}