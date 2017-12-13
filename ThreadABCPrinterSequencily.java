package com.examples.concurrency;

public class ThreadABCPrinterSequencily {

	
	public static void main(String[] args) {
		final ABCPrinter printer=new ABCPrinter();
		final int limit=10;
		
		//Thread A which print A
		Thread aPrinter=new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=0;i<limit;i++){
					printer.printA();
				}				
			}
		});
		
		//Thread B which print B
		Thread bPrinter=new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=0;i<limit;i++){
					printer.printB();
				}				
			}
		});
				
		//Thread C which print C
		Thread cPrinter=new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=0;i<limit;i++){
					printer.printC();
				}				
			}
		});
						
		aPrinter.start();
		bPrinter.start();
		cPrinter.start();
		
	}
}

class ABCPrinter{
	private volatile int flag=1;			
	
	public synchronized void printA(){
		while(flag != 1){
			try {
				wait();
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
		}
		System.out.print("A ");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
		flag=2;
		notifyAll();
	}
	
	public synchronized void printB(){
		while(flag != 2){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.print("B ");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		flag=3;
		notifyAll();
	}
	
	public synchronized void printC(){
		while(flag != 3){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.print("C ");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		flag=1;
		notifyAll();
	}	
}