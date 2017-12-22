package com.example.serialization;


public class LinkedListDemo {
	
	public static void main(String[] args) {
		MySingleLinkedList mylist=new MySingleLinkedList();
		mylist.addNode(10);
		mylist.addNode(20);
		mylist.addNode(30);
		mylist.addNode(40);
		mylist.addNode(50);
		mylist.addNode(60);
		
		mylist.printList();
		
		System.out.println();
		mylist.printMiddle();
		
		System.out.println();
		mylist.reverse();
	}

}
class MySingleLinkedList{
	private  Node first;
	static class Node{
		int data;
		Node next;
	}
	public  void addNode(int data){
		Node newNode=new Node();
		newNode.data=data;
		newNode.next=null;
		
		if(first == null){
			first=newNode;
			return;
		}
		Node currNode=first;
		while(currNode.next != null){
			currNode=currNode.next;
		}
		currNode.next=newNode;
	}
	
	public void printList(){
		Node currNode=first;
		while(currNode != null){
			System.out.print(currNode.data+" ->");
			currNode=currNode.next;
		}
	}
	public void printMiddle(){
		Node slowPtr=first;
		Node fastPtr=first;
		while(fastPtr !=null){
			fastPtr=fastPtr.next.next;
			slowPtr=slowPtr.next;			
		}
		System.out.println("Middle:"+slowPtr.data);		
	}
	public void reverse(){
		Node prev=null;
		Node temp=null;
		Node curr=first;
		while(curr !=null){	
			temp=prev;			
			prev=curr;
			curr=curr.next;	
			prev.next=temp;								
		}
		while(prev !=null){
			System.out.print(prev.data+"<-");
			prev=prev.next;
		}
	}
}