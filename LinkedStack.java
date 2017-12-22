package com.example.serialization;

public class LinkedStack {
	
	class Node{
		int data;
		Node next;
	}
	
	private Node first;
	private int MAX_SIZE=5;
	private int size=0;
	
	//add first
	public void push(int data){
		if(size == MAX_SIZE){
			System.out.println("Stack is Overflow!!");
			return;
		}
		//create new node with incoming data
		Node temp=new Node();
		temp.data=data;
		temp.next=null;
		size++;
		
		if(first == null){
			first=temp;			
			return;
		}
		
		temp.next=first;
		first=temp;		
	}
	
	//remove first
	public int pop(){
		
		if(first == null){
			System.out.println("Stack is underflow!!");
			return -1;
		}
		Node temp=first;
		first=first.next;
		size--;
		return temp.data;
	}
	
	public static void main(String[] args) {

		LinkedStack stack=new  LinkedStack();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		stack.push(60);
		
		System.out.println("poped:"+stack.pop());
		System.out.println("poped:"+stack.pop());
		System.out.println("poped:"+stack.pop());
		System.out.println("poped:"+stack.pop());
		System.out.println("poped:"+stack.pop());
		System.out.println("poped:"+stack.pop());		
	}
}
