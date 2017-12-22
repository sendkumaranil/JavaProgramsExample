package com.example.serialization;

public class LinkedQueue {

	
	class Node{
		int data;
		Node next;
	}
	private int MAX_SIZE=5;
	private int size=0;
	private Node front;
	private Node rear;
	
	//add to rear
	public void enqueue(int data){
	
		if(size == MAX_SIZE){
			System.out.println("Queue is full!");
			return;
		}
		//create new node
		Node temp=new Node();
		temp.data=data;
		temp.next=null;
		size++;
		
		if(front == null){
			front=rear=temp;
			return;
		}
		//put temp node to rear next and move rear to temp.
		rear.next=temp;
		rear=temp;		
	}
	
	//remove from front
	public int dequeue(){
		
		if(front == null){
			System.out.println("Queue is empty!");
			return -1;
		}
		Node temp=front;
		front=front.next;
		size--;
		
		return temp.data;
	}
	
	
	public static void main(String[] args) {
		
		LinkedQueue queue=new LinkedQueue();
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		queue.enqueue(50);
		queue.enqueue(60);
		System.out.println("Dequeued:"+queue.dequeue());
		System.out.println("Dequeued:"+queue.dequeue());
		System.out.println("Dequeued:"+queue.dequeue());
		System.out.println("Dequeued:"+queue.dequeue());
		System.out.println("Dequeued:"+queue.dequeue());
		System.out.println("Dequeued:"+queue.dequeue());
	}

}
