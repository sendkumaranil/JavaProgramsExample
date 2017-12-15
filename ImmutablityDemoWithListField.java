package com.example.serialization;

import java.util.ArrayList;
import java.util.List;

final class MyImmutableClassWithListField{
	private final int id;
	private final String name;
	private final List<String> myList;
	
	/*//Constructor intialize properties using shallow copy
	public MyImmutableClassWithListField(int id, String name,List<String> myList) {		
		this.id = id;
		this.name = name;
		this.myList = myList;
	}*/
	
	//Constructor intialize properties using Deep copy
	public MyImmutableClassWithListField(int id, String name,List<String> myList) {		
		this.id = id;
		this.name = name;
		List<String> tempList=new ArrayList<>();
		tempList.addAll(myList);
		this.myList = tempList;
	}
		
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public List<String> getMyList() {
		//return myList;
		List<String> tempList=new ArrayList<>();
		tempList.addAll(myList);
		return tempList;
	}
}

public class ImmutablityDemoWithListField {
	
	public static void main(String[] args) {
		List<String> testList=new ArrayList<>();
		testList.add("A");
		testList.add("B");
		testList.add("C");
		
		int intValue=10;
		String strValue="original";
		
		MyImmutableClassWithListField immutableObj=new MyImmutableClassWithListField(intValue, strValue, testList);
		
		//Lets see whether its copy by field or reference
		System.out.println(strValue==immutableObj.getName());
		System.out.println(testList == immutableObj.getMyList());
		//print the immutableObj values
		System.out.println("immutableObj id:"+immutableObj.getId());
		System.out.println("immutableObj name:"+immutableObj.getName());
		System.out.println("immutableObj testList:"+immutableObj.getMyList());
		//change the local variable values
		intValue=20;
		strValue="modified";
		testList.add("D");
		//print the values again
		System.out.println("immutableObj id after local variable change:"+immutableObj.getId());
		System.out.println("immutableObj name after local variable change:"+immutableObj.getName());
		System.out.println("immutableObj testMap after local variable change:"+immutableObj.getMyList());
		
		List<String> newlist=immutableObj.getMyList();
		newlist.add("E");
		System.out.println("immutableObj testMap after changing variable from get methods:"+immutableObj.getMyList());
	}

}
//OUTPUT with shallow copy constructor intialization
/*
true
true
immutableObj id:10
immutableObj name:original
immutableObj testList:[A, B, C]
immutableObj id after local variable change:10
immutableObj name after local variable change:original
immutableObj testMap after local variable change:[A, B, C, D]
immutableObj testMap after changing variable from get methods:[A, B, C, D, E]*/

//OUTPUT with deep copy constructor intialization
/*
true
false
immutableObj id:10
immutableObj name:original
immutableObj testList:[A, B, C]
immutableObj id after local variable change:10
immutableObj name after local variable change:original
immutableObj testMap after local variable change:[A, B, C]
immutableObj testMap after changing variable from get methods:[A, B, C]
*/