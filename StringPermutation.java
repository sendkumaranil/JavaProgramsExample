package com.example.serialization;

public class StringPermutation {

	
	public static void main(String[] args) {
		String s="ABC";
		
		int n=s.length();
		permute(s,0,n-1); //0=startIndex and n-1= endIndex		
	}
	
	static int count=0;
	public static void permute(String str,int startIndex,int endIndex){
		
		if(startIndex == endIndex)
		{
			System.out.println(str);				
		}
		else
		{
			for(int i=startIndex;i<=endIndex;i++){
				str=swap(str,startIndex,i);
				permute(str,startIndex+1,endIndex);				
				str=swap(str,startIndex,i);//backtracking				
			}
			
		}
	}
	private static String swap(String str, int i, int j) {
		
		char temp;
		char[] charArr=str.toCharArray(); //['A','B','C'] sample
		temp=charArr[i];
		charArr[i]=charArr[j];
		charArr[j]=temp;		
		return String.valueOf(charArr);
	}
}

