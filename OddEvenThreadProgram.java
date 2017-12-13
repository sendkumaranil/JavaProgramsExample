package com.examples.concurrency;

public class OddEvenThreadProgram {

	
	public static void main(String[] args) {

		final int limit=25;
		final PrintEvenOddNumber evenOddPrinter=new PrintEvenOddNumber(limit);
		
		Thread evenThread=new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				for(int i=0;i<limit;i++){
					evenOddPrinter.printEven();
				}
			}
		},"EVEN");
		
		Thread oddThread=new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				for(int i=0;i<limit;i++){
					evenOddPrinter.printOdd();
				}
			}
		},"ODD");
		
		evenThread.start();
		oddThread.start();
	}
}
class PrintEvenOddNumber{
	private int count=0;
	private int limit=0;	
	private volatile int flag=1;
	
	public PrintEvenOddNumber(int limit){
		this.limit=limit;
	}
	
	public synchronized int printEven(){
		//wait until odd printer print his job
		while(flag != 2){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		count++;
		if(count <=limit){
			System.out.println(Thread.currentThread().getName()+":"+count);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
		}		
		flag=1;// set toggle to provide chance to run other thread
		notifyAll(); // awake the odd printer
		return count;
	}
	
	public synchronized int printOdd(){
		//wait until even printer print his job.
		while(flag != 1){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		count++;
		if(count <=limit){
			System.out.println(Thread.currentThread().getName()+":"+count);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}		
		flag=2;// set toggle to provide chance to run other thread
		notifyAll(); // awake the odd printer
		return count;
	}
}