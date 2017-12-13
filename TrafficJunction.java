package com.examples.concurrency;

class NewThread extends Thread { 
boolean suspendFlag; 

NewThread(String threadname, ThreadGroup tgOb) { 
	super(tgOb, threadname); 	
	suspendFlag = false; 
	
	start(); // Start the thread 
} 
// This is the entry point for thread. 
	public void run() { 
		try { 
			while(true){				
				synchronized(this) { 
					while(suspendFlag) { 
						wait(); 
					} 
				} 
			}
		}catch (Exception e) { 
				System.out.println("Some Problem With Vechicle " + getName()); 
		} 	
	} 

	void mysuspend() { 
		suspendFlag = true; 
	} 
	
	synchronized void myresume() { 
		suspendFlag = false; 
		notifyAll(); 
	} 
} 

class TrafficJunction { 
	public static void main(String args[]) { 	
		boolean isRedRoad1=false;
		boolean isRedRoad2=true;
		
		ThreadGroup road1 = new ThreadGroup("Road 1"); 
		ThreadGroup road2 = new ThreadGroup("Road 2"); 
		
		NewThread car_r1 = new NewThread("CAR", road1); //register vechicles with road-1
		NewThread bike_r1 = new NewThread("BIKE", road1); 
		
		NewThread bus_r2 = new NewThread("BUS", road2); //register vechicles with road-2
		NewThread truck_r2 = new NewThread("TRUCK", road2); 
		
		
		
		System.out.println("List of Vechicles running on Road-1");
		road1.list();
		System.out.println("List of Vechicles running on Road-2");
		road2.list(); 
		
		System.out.println(); 
				
		
		Thread road1Vechicles[] = new Thread[road1.activeCount()]; 
		road1.enumerate(road1Vechicles); // get all threads in group 
		
		Thread road2Vechicles[] = new Thread[road2.activeCount()]; 
		road2.enumerate(road2Vechicles); // get all threads in group 
		
		while(true){
			while(isRedRoad2){		
				//================ [ YELLOW LIGHT ] ====================
				try {
					System.out.println("Yellow Light!! Be Ready all vechicles of Road 1"); 
					Thread.sleep(2000);
				} catch (InterruptedException e1) {					
					e1.printStackTrace();
				}
				
				//================ [ RED LIGHT ] ====================
				
				String vech_r2="";
				for(int i = 0; i < road2Vechicles.length; i++) { 
					
					vech_r2=vech_r2+road2Vechicles[i].getName()+",";
					
					((NewThread)road2Vechicles[i]).mysuspend(); // suspend each thread 
				}
				System.err.println("Red Light!! "+vech_r2+" are waiting on Road 2"); 
				
				//================ [ GREEN LIGHT ] ====================
				if(!isRedRoad1){
					System.out.println("Green Light!! Running all vechicles of Road 1"); 
					for(int i = 0; i < road1Vechicles.length; i++) { 
						((NewThread)road1Vechicles[i]).myresume(); // resume threads in group} 
					}
				}
				try { 
					Thread.sleep(10000); 
					isRedRoad2=false;
					isRedRoad1=true;
									
				} catch (InterruptedException e) { 
					System.out.println("Traffice Junction interrupted."); 
				}
			}
			
			while(isRedRoad1){
				//================ [ YELLOW LIGHT ] ====================
				try {
					System.out.println("Yellow Light!! Be Ready all vechicles of Road 2"); 
					Thread.sleep(2000);
				} catch (InterruptedException e1) {					
					e1.printStackTrace();
				}
				
				//================ [ RED LIGHT ] ====================
				String vech_r1="";				
				for(int i = 0; i < road1Vechicles.length; i++) { 
					
					vech_r1=vech_r1+road1Vechicles[i].getName()+",";
					
					((NewThread)road1Vechicles[i]).mysuspend(); // suspend each thread 
				}
				System.err.println("Red Light!! "+vech_r1+" are waiting on Road 1"); 
				
				//================ [ GREEN LIGHT ] ====================
				if(!isRedRoad2){
					System.out.println("Green Light!! Running all vechicles of Road 2"); 
					for(int i = 0; i < road2Vechicles.length; i++) { 
						((NewThread)road2Vechicles[i]).myresume(); // resume threads in group}
					}
				}
				
				try { 
					Thread.sleep(5000); 
					isRedRoad2=true;
					isRedRoad1=false;
				} catch (InterruptedException e) { 
					System.out.println("Traffice Junction interrupted."); 
				}
			}	
			
		}
	}
}