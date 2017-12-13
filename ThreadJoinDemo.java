package com.example.serialization;

class MyThreadDemo implements Runnable{
	
	@Override
	public void run() {
		System.out.println("I am "+Thread.currentThread().getName()+" doing job..");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}	
		System.out.println("hey!! I have completed my job bye!");
	}
}
public class ThreadJoinDemo {
	
	public static void main(String[] args) throws Exception {

		Thread t1=new Thread(new MyThreadDemo(), "FIRST");
		Thread t2=new Thread(new MyThreadDemo(), "SECOND");
		Thread t3=new Thread(new MyThreadDemo(), "THIRD");
				
		t1.start();
		t1.join(); //wait thread2 untill thread1 completed job
		t2.start();
		t2.join(); //wait thread3 untill thread2 completed job
		t3.start();
		t3.join(); //wait main thread untill thread3 completed job
		
		//main thread
		System.out.println("I am "+Thread.currentThread().getName());
				
	}	
}
/*
OUTPUT: 
I am FIRST doing job..
hey!! I have completed my job bye!
I am SECOND doing job..
hey!! I have completed my job bye!
I am THIRD doing job..
hey!! I have completed my job bye!
I am main
*/
