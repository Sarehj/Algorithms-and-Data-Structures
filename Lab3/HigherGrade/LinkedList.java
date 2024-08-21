//Task 4
//	Sareh Jalalizad
// Task Four Implement a generic iterable linked list which allows the user to insert and remove
// elements to/from the front and back end of the queue. 
// addfirst(Item) adds an Item to the end of the queue (generic)
// removefirst() removes an Item from the beginning of the queue 
// addlast(Item) adds an Item at the end of the queue
// removelast() removes an Item from the end of the queue
// ToString(LinkedList) transforms a queue of char into a string

//Code for iterator from the book from Algorithms, 4th ed. Sedgewick & Wayne

import java.util.*;


public class LinkedList<Item> implements Iterable<Item> {
	private Node first;			//first element of the list
	private Node last;			//last element of the list
	private int N ;            //number of elements on list
	
	
    private class Node {
         Node next;
         Node prev;
         Item item;
    }
    
 // Initialises an empty queue
    public LinkedList() {
    	first = new Node();
    	last = new Node();
    	N = 0;
    }
    
    //check is queue empty?return true if this queue is empty;
    //false otherwise
    public boolean isEmpty() {
    	return N == 0;
    }
    
    //Returns the number of items in this list.
    public int size() {
    	return N;
    }
    
    
    //Adds the item to list at the beginning of list
    // If the linked list is filled the first time,
    // we just add the Item to the first node and create a circular linked list between the two nodes first and last.
     public void addfirst(Item item) {  	
   
    	if(first.item == null) {
    		first.item = item;
	    		
    		if(isEmpty()) {     
	    		first.next = last;
	    		last.next = first;
	    		}    		
    	}
	    		else {
    		
	       Node oldfirst = first;     // save old first and creates a new first
    		first = new Node();
    		first.item = item;        //set value
    		first.next = oldfirst;
    		last.next = first;
    	}
    	N++;            //When a item is added to the list the size increases by one.
    }
    
  //Remove the item on linked list
  //returns the item of the deleted node.
    public Item removefirst() {    	
    	
    	Item returnItem = first.item;
    	first = first.next;
    	last.next = first;
    	
    	N--;               //When a node is deleted the size decreases by one.
    	
    	return returnItem;
    }
	
 //If the linked list is filled the first time  
 // we just add the Item to the last node and create a circular linked list between the two nodes first and last.
    public void addlast(Item item) {
    	
         	last.item = item;        
	   
         	if(isEmpty()) {
	    	
         		last.next = first;
	    	    first.next = last;
	      		
    	} else {
    	
    		Node oldlast = last;   
    		last = new Node();
    		last.item = item;        //sets value of new last
    		last.next = first;
    		oldlast.next = last;
    	}
    	
         	N++;           // When a item is added to the list the size increases by one.
    }
    
    //Remove the item on linked list
    //returns the item of the deleted node.
    public Item removelast() {
    	
    	Item returnItem = last.item;    	
    	last = last.prev;
    	first.prev = last;
    	N--;
    	
    	return returnItem;
    }
    
   // A method that iterates through the list and represents the items between brackets
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		for(Item item : this) {
			sb.append("[" + item + "]  ");
			
		}
		return sb.toString();
	}

	
	//Returns an iterator that iterates over the items
    public Iterator<Item> iterator() {
		return new ListIterator(); 
		}
	
	private class ListIterator implements Iterator<Item> {
		private Node current = first;
		private int index = 0;
		
		public boolean hasNext() {
		return index < N;
		}
		
		public Item next() {
			Item item = current.item;
			current = current.next;
			index++;
			return item;
		}
	}
	
	
	// Main class that test the linked list implementation of a Character linked list.
	 
	public static void main(String[] args) {
		LinkedList<Character> c = new LinkedList<Character>();
		
		System.out.println("Add at start:");
		c.addfirst('A');
		System.out.println(c.toString());
		c.addfirst('B');
		System.out.println(c.toString());
		c.addfirst('C');
		System.out.println(c.toString());
		
		System.out.println("add at last:");
		c.addlast('D');
		System.out.println(c.toString());
		c.addlast('E');
		System.out.println(c.toString());
		c.addlast('F');
		System.out.println(c.toString());
		c.addlast('G');
		System.out.println(c.toString());
	
		System.out.println("Delete from start:");
		c.removefirst();
		System.out.println(c.toString());
		
		System.out.println("Delete from end:");
		c.removelast();
		System.out.println(c.toString());
		
		System.out.println("The size of the stack: " + c.N);
	}


		
	}
