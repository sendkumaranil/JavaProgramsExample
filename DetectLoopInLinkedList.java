package com.example.serialization;


public class DetectLoopInLinkedList {

	MyNode first;
	
	public void print(){
		if(first==null){
			System.out.println("List is empty!!");
			return;
		}
		MyNode curr=first;
		while(curr != null){
			System.out.print(curr.data +" ->");
			curr=curr.next;
		}
	}
	public void detectLoopAndRemove(MyNode first){
		MyNode slowptr=first;
		MyNode fastptr=first;
		
		while(fastptr!=null){
			slowptr=slowptr.next;
			fastptr=fastptr.next.next;
			
			if(slowptr == fastptr){
				System.out.println("\nOps!! List has loop! going to delete loop");
				removeLoop(slowptr,first);
				return;
			}
		}
	}
	
	private void removeLoop(MyNode slowptr, MyNode first) {
		 MyNode ptr1 = null, ptr2 = null;
		 
	        /* Set a pointer to the beging of the Linked List and
	         move it one by one to find the first node which is
	         part of the Linked List */
	        ptr1 = first;
	        while (true) {
	 
	            /* Now start a pointer from where loop_node detected and check if it ever
	             reaches ptr2 */
	            ptr2 = slowptr;
	            while (ptr2.next != slowptr && ptr2.next != ptr1) {
	                ptr2 = ptr2.next;
	            }
	 
	            /* If ptr2 reahced ptr1 then there is a loop. So break the
	             loop */
	            if (ptr2.next == ptr1) {
	                break;
	            }
	 
	            /* If ptr2 did't reach ptr1 then try the next node after ptr1 */
	            ptr1 = ptr1.next;
	        }
	 
	        /* After the end of loop ptr2 is the last node of the loop. So
	         make next of ptr2 as NULL */
	        ptr2.next = null;		
	}
	
	public static void main(String[] args) {
		DetectLoopInLinkedList list=new DetectLoopInLinkedList();
		list.first=new MyNode(10);
		list.first.next=new MyNode(20);
		list.first.next.next=new MyNode(30);
		list.first.next.next.next=new MyNode(40);
		list.first.next.next.next.next=new MyNode(50);
		
		list.print();
		
		//making llop for the list for testing
		list.first.next.next.next.next.next=list.first.next.next;
		
		list.detectLoopAndRemove(list.first);

		list.print();
	}

}
class MyNode{
	int data;
	MyNode next;
	public MyNode(int data){
		this.data=data;
	}
}