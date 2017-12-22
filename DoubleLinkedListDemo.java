package com.example.serialization;

public class DoubleLinkedListDemo {

	
	class Node{
		int data;
		Node next;
		Node prev;
	}
	
	private Node first;
	
	public void add(int data){
		
		//creating new node
		Node newNode=new Node();
		newNode.data=data;
		newNode.next=null;
		newNode.prev=null;
				
		if(first == null){
			first=newNode;
			return;
		}
		
		Node curr=first;
		while(curr.next !=null){
			curr=curr.next;
		}
		curr.next=newNode;
		newNode.prev=curr;
		
	}
	
	public int remove(int data){
		
		if(first == null){
			System.out.println("List is empty!!");
			return -1;
		}
		Node curr=first;
		while(curr.next != null && curr.data != data){
			curr=curr.next;
		}
		
		//check if first node
		if(curr.prev == null){
			Node temp=curr;
			curr=curr.next;
			first=curr;		
			return temp.data;
		}
		Node prev=curr.prev;
		prev.next=curr.next;
		
		return curr.data;
	}
	
	public void print(){
		if(first==null){
			System.out.println("List is empty!!");
			return;
		}
		Node curr=first;
		while(curr != null){
			System.out.print(curr.data +" ->");
			curr=curr.next;
		}
	}
	
	public static void main(String[] args) {
		
		DoubleLinkedListDemo dblLinkedlist=new DoubleLinkedListDemo();
		dblLinkedlist.add(10);
		dblLinkedlist.add(20);
		dblLinkedlist.add(30);
		dblLinkedlist.add(40);
		
		dblLinkedlist.print();
		
		dblLinkedlist.remove(30);
		System.out.println("\nAfter removed");
		dblLinkedlist.print();
		
	}

}
