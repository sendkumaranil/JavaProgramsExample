package com.examples.concurrency;

public class DeadLockExample {

	
	public static void main(String[] args) {
		final DeadLock deadLockExample=new DeadLock();
		final DeadLockSolution deadLockSolExample=new DeadLockSolution();
		
		Thread t1=new Thread(new Runnable() {
			
			@Override
			public void run() {
				deadLockExample.method1();
				//deadLockSolExample.method1();//uncomment and comment above line
				
			}
		},"Thread-1");

		Thread t2=new Thread(new Runnable() {
					
					@Override
					public void run() {
						deadLockExample.method2();
						//deadLockSolExample.method1(); //uncomment and comment above line
					}
		},"Thread-2");
		
		t1.start();
		t2.start();
				
	}

}

class DeadLock{
	
	public void method1(){
		synchronized(String.class){
			
			System.out.println(Thread.currentThread().getName()+" has acquried String.class");
			System.out.println(Thread.currentThread().getName()+" is going to acquire Integer.class ....");
			
			synchronized(Integer.class){
				System.out.println(Thread.currentThread().getName()+" has acquired Integer.class");
			}
		}
	}
	public void method2(){		    
			synchronized(Integer.class){
				
				System.out.println(Thread.currentThread().getName()+" has acquried Integer.class");
				System.out.println(Thread.currentThread().getName()+" is going to acquire String.class ....");
								
				synchronized(String.class){
					System.out.println(Thread.currentThread().getName()+" has acquired String.class");
				}
			}
	}
}
//Solution
class DeadLockSolution{
	
	public void method1(){
		synchronized(String.class){
			
			System.out.println(Thread.currentThread().getName()+" has acquried String.class");
			System.out.println(Thread.currentThread().getName()+" is going to acquire Integer.class ....");
			
			synchronized(Integer.class){
				System.out.println(Thread.currentThread().getName()+" has acquired Integer.class");
			}
		}
	}
	public void method2(){
		    //same order of method1
			synchronized(String.class){
				
				System.out.println(Thread.currentThread().getName()+" has acquried Integer.class");
				System.out.println(Thread.currentThread().getName()+" is going to acquire String.class ....");
				
				//Same order of method1
				synchronized(Integer.class){
					System.out.println(Thread.currentThread().getName()+" has acquired String.class");
				}
			}
	}
}