//Task 5
// 	Sareh Jalalizad
// A queue with a method to choose which element in the list you want to delete.
// Each list element is generic of type Item
// ToString(LinkedList) transforms a queue into a string
//  dequeue removes a char from position pos of the queue and returns
//  enqueue adds a char to the end of the queue

import java.util.*;


public class LinkedListR<Item> implements Iterable<Item> {
	
	private Node first;    //beginning of queue
	private Node last;     //end of queue
	private int N;         //number of elements on queue
	
	
	
    private class Node {
        private Node next;
        private Item item;
    }
    
	
    public LinkedListR() {
    	first = new Node();
    	last = new Node();
    	N = 0;
    }
    
	
    //check is queue empty?return true if this queue is empty;
    //false otherwise
    public boolean isEmpty() {
    	return N == 0;
    }
    
	
  //Returns the number of items in this queue
    public int size() {
    	return N;
    }
    
    
    //Adds the item to queue (in last index)
    public void enqueue(Item item) {
    	
    	Node oldlast;
    	oldlast = last;          // save old last and creates a new last
    	last = new Node();
    	last.item = item;        //sets value of new last
    	last.next = null;        //since last is last index in the queue set next pointer to null
    	
    	if(isEmpty()) {          // when queue is empty
    		first = last;        //last and first is same so item added in both last and first
    	} 
    else {
    	
    		oldlast.next = last;
    	}
    	N++;
    }
    
    // A method that delete the k:th node in the list.

    public Item deleteNode(int pos) {  //position tells which element should be deleted, at the given position.
    	
    	Node newNode = first;
    	int counter = 1;
    	while (counter < (pos-1)) {
    		newNode = newNode.next;
    		counter++;
    	}
    	
    	//returns the item of the deleted node.
    	Item returnItem = newNode.item;			
    	Node current = newNode.next;
    	newNode.next = current.next;
    	
    	N--;                         //When a node is deleted the size decreases by one.
    	
    	return returnItem;
    }
    
	// A method that iterates through the list and represents the items between brackets 
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		for(Item item : this) {
			sb.append("[" + item + "]");
		}
		return sb.toString();
	}	
	
	// A iterator of the stack that iterates through the list.
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
	
	// test the linked list implementation of a Character list.
	 
	public static void main(String[] args) {
		LinkedListR<Character> c = new LinkedListR<Character>();
		
		c.enqueue('a');
		System.out.println(c.toString());
		c.enqueue('b');
		System.out.println(c.toString());
		c.enqueue('c');
		System.out.println(c.toString());
		c.enqueue('d');
		System.out.println(c.toString());
		
		System.out.println("The size of the stack: " + c.N);
		
		System.out.println("Delete element 3");
		c.deleteNode(3);
		System.out.println(c.toString());
		System.out.println("Delete element 2");
		c.deleteNode(2);
		System.out.println(c.toString());
		
		System.out.println("The size of the stack: " + c.N);
	}
}




