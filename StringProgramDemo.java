package com.example.serialization;

import java.util.Arrays;
import java.util.HashMap;

public class StringProgramDemo {

	
	public static void main(String[] args) {

		System.out.println(StringProgram.reverseString("india"));
		
		StringProgram.isAnagram("Mother In Law", "Hitler Woman");
		 
		StringProgram.isAnagram("School MASTER", "The ClassROOM");
 
		StringProgram.isAnagram("DORMITORY", "Dirty Room");
 
		StringProgram.isAnagram("Toss", "Shot");
 
		StringProgram.isAnagram("joy", "enjoy");
		
		StringProgram.reverseEachWordOfString("Java J2EE JSP Servlets Hibernate Struts");
         
		StringProgram.reverseEachWordOfString("I am string not reversed");
		
    }

}
class StringProgram{
	
	//1.Reverse string using recursion
	public static String reverseString(String str){
		if(str==null || str.length() < 1){
			return str;
		}
		return reverseString(str.substring(1))+str.charAt(0);
	}
	/* base condition is when string is null or length is less than 1 then return string
	 * first we will take first character from string charAt(0) then append to 
	 * 
	 * i n d i a
	 *  ndia '+' i
		dia '+' n
		ia '+' d
		a '+' i
		 '+' a
	 * 
	 */
	
	public static void isAnagram(String s1, String s2)
    {
        //Removing white spaces from s1 and s2 and converting case to lower case
 
        String copyOfs1 = s1.replaceAll("\\s", "").toLowerCase();
 
        String copyOfs2 = s2.replaceAll("\\s", "").toLowerCase();
 
        //Initially setting status as true
 
        boolean status = true;
 
        if(copyOfs1.length() != copyOfs2.length())
        {
            //Setting status as false if copyOfs1 and copyOfs2 doesn't have same length
 
            status = false;
        }
        else
        {
            //Constructing a map containing character as a key and character occurrences as a value
 
            HashMap<Character, Integer> map = new HashMap<Character, Integer>();
 
            for (int i = 0; i < copyOfs1.length(); i++)
            {
                //Getting char from copyOfs1
 
                char charAsKey = copyOfs1.charAt(i);
 
                //Initializing char count to 0
 
                int charCountAsValue = 0;
 
                //Checking whether map contains this char
 
                if(map.containsKey(charAsKey))
                {
                    //If contains, retrieving it's count
 
                    charCountAsValue = map.get(charAsKey);
                }
 
                //Putting char and it's count to map with pre-incrementing char count
                charCountAsValue=charCountAsValue+1;
                map.put(charAsKey,charCountAsValue);
 
                //Getting char from copyOfs2
 
                charAsKey = copyOfs2.charAt(i);
 
                //Initializing char count to 0
 
                charCountAsValue = 0;
 
                //Checking whether map contains this char
 
                if(map.containsKey(charAsKey))
                {
                    //If contains, retrieving it's count
 
                    charCountAsValue = map.get(charAsKey);
                }
 
                //Putting char and it's count to map with pre-decrementing char count
                charCountAsValue=charCountAsValue-1;
                map.put(charAsKey, charCountAsValue);
            }
 
            //Checking each character and it's count
 
            for (int value : map.values())
            {
                if(value != 0)
                {
                    //If character count is not equal to 0, then setting status as false
 
                    status = false;
                }
            }
 
        }
 
        if(status)
        {
            System.out.println(s1+" and "+s2+" are anagrams");
        }
        else
        {
            System.out.println(s1+" and "+s2+" are not anagrams");
        }
    }
	
	public static void reverseEachWordOfString(String inputString)
    {
        String[] words = inputString.split(" ");
         
        String reverseString = "";
         
        for (int i = 0; i < words.length; i++) 
        {
            String word = words[i];
             
            String reverseWord = "";
             
            for (int j = word.length()-1; j >= 0; j--) 
            {
                reverseWord = reverseWord + word.charAt(j);
            }
             
            reverseString = reverseString + reverseWord + " ";
        }
         
        System.out.println(inputString);
         
        System.out.println(reverseString);
         
        System.out.println("-------------------------");
    }
}