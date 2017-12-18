package com.example.serialization;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectionImmutabilityDemo {

	public static void main(String[] args) {

		immutableListExampleTest();
		
		immutableMapExampleTest();
	}

	public static List<Integer> getList(List<Integer> list){
		
		List<Integer> list1=list;
		return list1;
		//do not use this above line, if you add this line then readOnlylist also get effected while changing to original list.
		
		//create new arralist and pass the incoming list in constructor.
		//return new ArrayList<>(list);
	}
	
	public static Map<Integer,String> getMap(Map<Integer,String> map){
		/*Map<Integer,String> mMap=map;
		return mMap;
		
		//Do not use this code otherwise our map will not be immutable map
		*/
		//create new map and copy each item of original map to the new map
		Map<Integer,String> newMap=new HashMap<>();
		for(Map.Entry<Integer, String> orgMap:map.entrySet()){
			newMap.put(orgMap.getKey(), orgMap.getValue());
		}
		return newMap;
		
	}
	
	public static void immutableListExampleTest(){
		List<Integer> mylist=new ArrayList<>();
		mylist.add(10);
		mylist.add(20);
		mylist.add(30);
		mylist.add(40);
		mylist.add(50);
		
		System.out.println("Original ArrayList:"+mylist);
		
		List<Integer> readOnlylist=getList(mylist);
		
		System.out.println("Read Only ArrayList:"+readOnlylist);
		
		//here we are changing the original list value;
		mylist.add(60);
		System.out.println("After changed original ArrayList:");
		System.out.println("Original ArrayList:"+mylist);
		System.out.println("Read Only ArrayList:"+readOnlylist);
	}
	
	public static void immutableMapExampleTest(){
		Map<Integer,String> originalMap=new HashMap<>();
		originalMap.put(1, "ONE");
		originalMap.put(2, "TWO");
		originalMap.put(3, "THREE");
		
		System.out.println("Original Map:"+originalMap);
		
		Map<Integer,String> immutableMap=getMap(originalMap);
		System.out.println("Immutable Map:"+immutableMap);
		
		originalMap.put(4, "FOUR");
		System.out.println("After changed original Map:");
		
		System.out.println("Original Map:"+originalMap);
		System.out.println("Immutable Map:"+immutableMap);
	}
}

//
/*OUTPUT:
Original ArrayList:[10, 20, 30, 40, 50]
Read Only ArrayList:[10, 20, 30, 40, 50]
After changed original ArrayList:
Original ArrayList:[10, 20, 30, 40, 50, 60]
Read Only ArrayList:[10, 20, 30, 40, 50, 60]
Original Map:{1=ONE, 2=TWO, 3=THREE}
Immutable Map:{1=ONE, 2=TWO, 3=THREE}
After changed original Map:
Original Map:{1=ONE, 2=TWO, 3=THREE, 4=FOUR}
Immutable Map:{1=ONE, 2=TWO, 3=THREE}
*/