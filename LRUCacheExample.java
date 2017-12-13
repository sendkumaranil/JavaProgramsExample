package com.example.serialization;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheExample {

	
	public static void main(String[] args) {
		
		LRUCache cache=new LRUCache(5);
		cache.setPage(1, 1);
		cache.setPage(2, 2);
		cache.setPage(3, 3);
		cache.setPage(4, 4);
		cache.setPage(5, 5);
		
		cache.printCacheData();
		
		cache.setPage(6, 6);
		cache.printCacheData(); 
		
		Page page=cache.getPage(3);
		if(page != null){
			System.out.println("Requested Page:(X:"+page.getX()+","+" Y:"+page.getY()+")");
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
	Map<Integer,Page> hash=null;
    MyQueue queue=null;
    
	public LRUCache(int capacity){
		this.capacity=capacity;
		hash=new HashMap<>(capacity);
		queue=new MyQueue(capacity);
	}
	
	public void setPage(int x,int y){
		Page oldPage=hash.get(x);
		if(oldPage != null){	
			oldPage.setY(y);
			queue.remove(oldPage);
			queue.addFront(oldPage);
			
		}else{
			
			if(hash.size()==capacity){
				Page rem=queue.removeLast();
				hash.remove(rem.getX());
			}
			
			Page newPage=new Page(x, y);
			queue.addFront(newPage);
			hash.put(x, newPage);
		}
	}
	
	public Page getPage(int x){
		Page existPage=hash.get(x);
		if(existPage == null){
			return null;
		}
		queue.remove(existPage);
		queue.addFront(existPage);
		
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
	ListNode first=null;
	
	public MyQueue(int capacity){
		this.capacity=capacity;
	}
	
	public void addFront(Page page){
		if(length != capacity){
		
			ListNode node=new ListNode(page);
			if(first==null){
				first=node;
			}else{
				node.setNext(first);
				first=node;
			}
			length++;
		}		
	}
	
	public Page remove(Page page){
		Page temp=null;
		ListNode curr=first;
		ListNode prev=null;
		
		while(curr.getNext()!=null && curr.getPage().getX()!=page.getX()){
			prev=curr;
			curr=curr.getNext();
		}
		if(prev != null){
			prev.setNext(curr.getNext());
			temp=curr.getPage();
			length--;
		}else{
			temp=first.getPage();
			first=null;
			length--;
		}
		
		return temp;
	}
	
	public Page removeLast(){
		ListNode curr=first;
		ListNode prev=null;
		ListNode temp=null;
		while(curr.getNext() != null){
			prev=curr;
			curr=curr.getNext();
		}
		if(prev != null){
			temp=curr;
			prev.setNext(null);	
			length--;
		}else{
			temp=curr;
			first=null;
			length--;
		}				
		return temp.getPage();
	}
	
	public void printQ(){
		if(first!=null){
			ListNode curr=first;
			while(curr!=null){
				Page p=curr.getPage();
				System.out.print("("+p.getX()+","+p.getY()+") ");
				curr=curr.getNext();
			}
			System.out.println();
		}
	}
}

