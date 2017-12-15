package com.example.serialization;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

final class MyImmutableClassWithMapField{
	private final int id;
	private final String name;
	private final Map<String,String> testMap;
	
	//Constructor which intializing the above properties using shallow copy
	/*public MyImmutableClass(int id, String name, Map<String, String> testMap) {		
		this.id = id;
		this.name = name;
		this.testMap = testMap;
	}*/
	
	//Constructor which intializing the above properties using deep copy
	public MyImmutableClassWithMapField(int id, String name, Map<String, String> hm) {		
		this.id = id;
		this.name = name;
		//making deep copy of map
		HashMap<String,String> tempMap=new HashMap<String,String>();
		String key;
		Iterator<String> it = hm.keySet().iterator();
		while(it.hasNext()){
			key=it.next();
			tempMap.put(key, hm.get(key));
		}
		this.testMap=tempMap;
	}
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Map<String, String> getTestMap() {
		//return testMap;
		
		HashMap<String,String> tempMap=new HashMap<String,String>();
		String key;
		Iterator<String> it = testMap.keySet().iterator();
		while(it.hasNext()){
			key=it.next();
			tempMap.put(key, testMap.get(key));
		}		
		return tempMap;
	}
	
}

public class ImmutablityDemoWithMapField {

	public static void main(String[] args) {
		Map<String, String> hMap = new HashMap<String,String>();
		hMap.put("1", "first");
		hMap.put("2", "second");
		
		String strValue = "original";
		
		int intValue=10;
		
		MyImmutableClassWithMapField immutableObj = new MyImmutableClassWithMapField(intValue,strValue,hMap);
		
		//Lets see whether its copy by field or reference
		System.out.println(strValue==immutableObj.getName());
		System.out.println(hMap == immutableObj.getTestMap());
		//print the immutableObj values
		System.out.println("immutableObj id:"+immutableObj.getId());
		System.out.println("immutableObj name:"+immutableObj.getName());
		System.out.println("immutableObj testMap:"+immutableObj.getTestMap());
		//change the local variable values
		intValue=20;
		strValue="modified";
		hMap.put("3", "third");
		//print the values again
		System.out.println("immutableObj id after local variable change:"+immutableObj.getId());
		System.out.println("immutableObj name after local variable change:"+immutableObj.getName());
		System.out.println("immutableObj testMap after local variable change:"+immutableObj.getTestMap());
		
		Map<String, String> hmTest = immutableObj.getTestMap();
		hmTest.put("4", "new");
		
		System.out.println("immutableObj testMap after changing variable from get methods:"+immutableObj.getTestMap());

	}
}
/*//OUTPUT:
	
true
true
immutableObj id:10
immutableObj name:original
immutableObj testMap:{1=first, 2=second}
immutableObj id after local variable change:10
immutableObj name after local variable change:original
immutableObj testMap after local variable change:{1=first, 2=second, 3=third}
immutableObj testMap after changing variable from get methods:{1=first, 2=second, 3=third, 4=new}*/

//Now going through deep copy and change the constructor as below
/*public MyImmutableClass(int id, String name, Map<String, String> hm) {		
	this.id = id;
	this.name = name;
	//making deep copy of map
	HashMap<String,String> tempMap=new HashMap<String,String>();
	String key;
	Iterator<String> it = hm.keySet().iterator();
	while(it.hasNext()){
		key=it.next();
		tempMap.put(key, hm.get(key));
	}
	this.testMap=tempMap;
}

public Map<String, String> getTestMap() {
	//return testMap;
	
	HashMap<String,String> tempMap=new HashMap<String,String>();
	String key;
	Iterator<String> it = testMap.keySet().iterator();
	while(it.hasNext()){
		key=it.next();
		tempMap.put(key, testMap.get(key));
	}		
	return tempMap;
}*/

//OUTPUT:
/*
true
false
immutableObj id:10
immutableObj name:original
immutableObj testMap:{1=first, 2=second}
immutableObj id after local variable change:10
immutableObj name after local variable change:original
immutableObj testMap after local variable change:{1=first, 2=second}
immutableObj testMap after changing variable from get methods:{1=first, 2=second}
*/
