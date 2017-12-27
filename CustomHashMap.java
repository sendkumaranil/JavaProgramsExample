package com.javaprograms;

import javax.naming.OperationNotSupportedException;

class Entry<K,V>{
	K key;
	V value;
	Entry<K,V> next;
	public Entry(K key,V value,Entry<K,V> next){
		this.key=key;
		this.value=value;
		this.next=next;
	}
}

public class CustomHashMap<K,V> {
	
	private Entry<K,V> head;
	private int capacity;
	private Entry[] table;
	private boolean isNullKeyAvailable=false;
	
	public CustomHashMap(){
		table=new Entry[10]; //default size map
	}
	public CustomHashMap(int capacity){
		this.capacity=capacity;
		table=new Entry[this.capacity]; //specific size map
	}
	
	private int hash(K key){
		int index=key.hashCode() % table.length;
		return index;
	}
	private boolean checkNullKey(K key){		
		if(key == null){						
			return true;
		}
		return false;
	}	
	
public V put(K key,V value){
		
		
		int index;
		if(checkNullKey(key)){
			//allowed only once null key
			if(isNullKeyAvailable){
				try {
					throw new OperationNotSupportedException("Null key allowed only once!!");
				} catch (OperationNotSupportedException e1) {					
					e1.printStackTrace();
					return null;
				}
			}else{
				isNullKeyAvailable=true;				
			}
			//index of null key is 0
			index=0;
		}else{
			//Calculate index here
			index=hash(key);			
		}
		//Create new entry here with key value pair
		Entry<K,V> newEntry=new Entry<K,V>(key,value,null);
		
		//get the firts node from table index
		Entry<K,V> headNode=table[index];
		//if there is no first node
		if(headNode==null){
			headNode=newEntry;
			table[index]=headNode;
		}else{
			Entry<K,V> curr=headNode;
			while(curr.next != null){
				if(curr.key.equals(newEntry.key)){
					V oldValue=curr.value;
					curr.value=newEntry.value;
					return oldValue;
				}
				curr=curr.next;
			}
			curr.next=newEntry;
			table[index]=curr;
		}		
		return null;
	}

public V get(K key){
	int index;
	if(checkNullKey(key)){
		index=0;
	}else{
		index=hash(key);
	}
	Entry<K,V> curr=table[index];
	while(curr!=null){
		//if key is null but null key is available in map then
		if(key == null && curr != null){
			V val=curr.value;
			return val;
		}else if(key == null && curr == null){
			return null;
		}
		
		if(curr.key.equals(key)){
			V val=curr.value;
			return val;
		}
		curr=curr.next;
	}		
	return null;
}

public V remove(K key){
	int index;
	if(checkNullKey(key)){
		index=0;
	}else{
		index=hash(key);
	}
	Entry<K,V> curr=table[index];
	Entry<K,V> head=table[index];
	Entry<K,V> prev=null;
	while(curr!=null){
		//if key is null but null key is available in map then
		if(key==null  && curr != null){
			V val=curr.value;
			table[index]=null;
			return val;
		}else if(key == null && curr == null){
			return null;
		}
		
		//if first node delete
		if(curr.key.equals(key) && prev ==null){
			V val=curr.value;
			head=curr.next;
			table[index]=head;
			return val;
		}else if(curr.key.equals(key)){
			V val=curr.value;
			prev.next = curr.next;
			table[index]=head;
			return val;
		}
		prev=curr;
		curr=curr.next;
	}
	return null;
}
public void print(){
	for(int i=0;i<table.length; i++){
		if(table[i]!=null){
			Entry<K,V> entry=table[i];
			while(entry != null){
				System.out.println("Key:"+entry.key+" Value:"+entry.value);
				entry=entry.next;
			}
		}
	}
}



public static void main(String[] args) {
	
	
	CustomHashMap<Integer,Integer> map=new CustomHashMap<Integer,Integer>();
	map.put(1, 10);
	map.put(2, 20);
	map.put(3, 30);
	map.put(4, 40);
	map.put(null, 50);
	//map.put(null, 60); //check null twice as key
	
	map.print();
	
	System.out.println(map.get(3));
	
	System.out.println(map.remove(null));
	
	map.print();
	
	System.out.println(map.get(null));
}


}
