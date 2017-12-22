package com.example.serialization;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class StringAnagram {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String s1="Dormitory";
		String s2="Dirty Room";
		if(isAnagram(s1,s2)){
			System.out.println(s1+" and "+s2+" are anagram");
		}else{
			System.out.println(s1+" and "+s2+" are not anagram");
		}
		
	}

	public static boolean isAnagram(String s1,String s2){
		boolean status=true;
		s1=s1.replaceAll("\\s", "").toLowerCase();
		s2=s2.replaceAll("\\s","").toLowerCase();		
		
		Map<Character,Integer> map=new HashMap<>();
		
		
		if(s1.length() !=s2.length())			
			return false;
		
		for(int i=0;i<s1.length();i++){
			int countIncrement=0;
			Character s1_char=s1.charAt(i);			
			if(map.containsKey(s1_char)){
				countIncrement=map.get(s1_char);
			}
			countIncrement=countIncrement+1;
			map.put(s1_char, countIncrement);
			
			int countDecrement=0;
			Character s2_char=s2.charAt(i);			
			if(map.containsKey(s2_char)){
				countDecrement=map.get(s2_char);
			}
			countDecrement=countDecrement-1;
			map.put(s2_char, countDecrement);
			
		}
		for(Integer val:map.values()){
			if(val !=0){
				status=false;break;
			}
		}
		return status;
	}
}
