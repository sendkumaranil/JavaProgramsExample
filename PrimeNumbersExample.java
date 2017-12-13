package com.example.serialization;

public class PrimeNumbersExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int limit=100;
		for(int i=2;i<=limit;i++){
			if(isPrime(i)){
				System.out.println(i);
			}
		}
		
		
		Integer I1=5;
		Integer I2=5;
		Integer I3=132;
		Integer I4=132;
		
		System.out.println("I1==I2:"+(I1==I2));
		System.out.println("I3==I4:"+(I3==I4));
		//show();
		//dotask();
		
		doSomeTask(null); //only call most specific method which prefer the type of Object
		
		int[] num={12,2,-1,0,2,1,6,3,5,11,9,18};
		secondHighestValueFromArray(num);
	}

	private static boolean isPrime(int num){
		for(int i=2;i<num;i++){
		
			if((num%i)==0){
				return false;
			}
		}
		return true;
	}
	
	public static int show(){
		return (true?null:0);
	}
	
	public static int dotask(){
		while(true); //we can also write if method does not return any thing
	}
	
	public static void doSomeTask(Object obj){
		System.out.println("I am object");
	}
	public static void doSomeTask(String str){
		System.out.println("I am string");
	}
	/*public static void doSomeTask(Integer intr){
		System.out.println("I am Integer");
	}*/ //if we add one more method of subtype of Object then compile-time error ambugity will occurred
	
	public static void secondHighestValueFromArray(int[] arr){
		
		int highest=1;//Integer.MIN_VALUE;
		int secondHighest=0;//Integer.MAX_VALUE;
		
		for(int i=0;i<arr.length;i++){
			//CASE-1: when current element is greater than highest value then assing current element to highest and old highest value to secondhighest.
			if(arr[i] > highest){
				secondHighest=highest;
				highest=arr[i];
			}
			//CASE-2:when current element is less than highest but greater than secondhighest then assign current element to secondhighest.
			if(arr[i] < highest && arr[i] > secondHighest ){
				secondHighest=arr[i];
			}
		}
		System.out.println("Second Highest:"+secondHighest);
	}
}

