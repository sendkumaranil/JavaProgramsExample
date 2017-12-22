package com.example.serialization;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheExample {

	
	public static void main(String[] args) {
		
		Page page1=new Page(10,10);
		Page page2=new Page(20,20);
		Page page3=new Page(30,30);
		Page page4=new Page(40,40);
		Page page5=new Page(50,50);
		Page page6=new Page(60,60);
		
		Page page7=new Page(70,70);//this page does not exist in cache and we request it first time
		
		LRUCache cache=new LRUCache(5);
		cache.setPage(page1);
		cache.setPage(page2);
		cache.setPage(page3);
		cache.setPage(page4);
		cache.setPage(page5);//capacity reached
		
		cache.printCacheData();
		
		cache.setPage(page6); //new request
		
		cache.printCacheData(); 
		
		Page reqPage=cache.getPage(page3); //existing request
		if(reqPage != null){
			System.out.println("Requested Page:(X:"+reqPage.getX()+","+" Y:"+reqPage.getY()+")");
		}else{
			System.out.println("Page doesn't exist in cache.");
		}
		
		cache.printCacheData();
		
		Page reqPage2=cache.getPage(page7); //existing request
		if(reqPage2 != null){
			System.out.println("Requested Page:(X:"+reqPage2.getX()+","+" Y:"+reqPage2.getY()+")");
		}else{
			System.out.println("Page doesn't exist in cache.");
		}
		
		cache.printCacheData();
		
	}

}
/**
 * 
 * @author anil_kumar
 * 
 *@category
 *LRU: Least recently used cache
 *Behavior:In ‘First In First Out’ approach, OS selects the page which is oldest in cache and swaps that it with new page.
 *In ‘Least Recently Used’ approach, OS selects the page which was not accessed for longest period of time
 *If a page is entered in cache first, it is first candidate to go out if it not accessed again in that duration. 
 *So the additional condition is that we need to keep track when the page was accessed.
 *
 *@Implementation: we will use two data structure Queue for FIFO and hash map for hashing and tracking.
 */
class LRUCache{
	private int capacity;
	Map<Page,Page> hash=null; //here we can also use set instead of map
    MyQueue queue=null;
    
	public LRUCache(int capacity){
		this.capacity=capacity;
		hash=new HashMap<>(capacity);
		queue=new MyQueue(capacity);
	}
	
	public void setPage(Page page){
		Page oldPage=hash.get(page);
		if(oldPage != null){				
			queue.remove(oldPage); //if page already in queue then remove from queue
			queue.enqueue(oldPage);	// and enter to the rear.
		}else{
			
			//if queue (cache) full and coming new request
			if(hash.size()==capacity){
				Page rem=queue.dequeue(); //remove from queue
				hash.remove(rem); // remove same page from hash
			}
			//add new entry to both queue and hash
			queue.enqueue(page);
			hash.put(page, page);
		}
	}
	
	public Page getPage(Page page){
		Page existPage=hash.get(page);
		//if requested page doesn't exist
		if(existPage == null){
			return null;
		}
		//if exist then remove from queue and enter to rear
		queue.remove(existPage);
		queue.enqueue(existPage);
		
		return existPage;
	}
	
	public void printCacheData(){
		queue.printQ();		
	}
	public void printHashData(){
		System.out.println(hash);
	}
}

//This Page request which have x and y cordinate.
class Page{
	private int x;
	private int y;
	
	public Page(int x,int y){
		this.x=x;this.y=y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	//override equal and hashcode to match page object
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Page other = (Page) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}	
}

//Simple single linked list which have two properties: data and reference address of next node
class ListNode{
	private Page page;
	private ListNode next;
	
	public ListNode(Page page){
		this.page=page;
	}

	public ListNode getNext() {
		return next;
	}

	public void setNext(ListNode next) {
		this.next = next;
	}
		
	public Page getPage(){
		return page;
	}
}

/*Create Queue Data Structure using linked list.
which have following operations:
remove element from last
add element to the front
remove specific element from queue
print queue element. 
*/
class MyQueue{
	private int capacity;
	private int length;
	ListNode front=null;
	ListNode rear=null;
	
	public MyQueue(int capacity){
		this.capacity=capacity;
	}
	
	//add to rear
	public void enqueue(Page page){
		if(length != capacity){
		
			ListNode newNode=new ListNode(page);
			if(front==null){
				front=rear=newNode;
			}else{
				rear.setNext(newNode);				
				rear=newNode;
			}
			length++;
		}		
	}
	
	//remove specific node
	public Page remove(Page page){
		ListNode temp=null;
		ListNode curr=front;
		ListNode prev=null;
		
		while(curr.getNext()!=null && !curr.getPage().equals(page)){
			prev=curr;
			curr=curr.getNext();
		}
		//check if first node is not
		if(prev != null){
			temp=curr;
			prev.setNext(curr.getNext());			
			length--;
		}else{
			temp=front;
			front=null;
			length--;
		}
		
		return temp.getPage();
	}
	
	//remove from front
	public Page dequeue(){
		ListNode temp=front;
		//if queue(cache) not exist
		if(front == null){			
			return null;
		}	
		front=front.getNext();	
		length--;
		return temp.getPage();
	}
	
	public void printQ(){
		if(front!=null){
			ListNode curr=front;
			while(curr!=null){
				Page p=curr.getPage();
				System.out.print("Page("+p.getX()+","+p.getY()+") ");
				curr=curr.getNext();
			}
			System.out.println();
		}
	}
}

