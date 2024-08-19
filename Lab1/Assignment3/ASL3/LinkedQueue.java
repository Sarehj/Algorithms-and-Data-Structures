//Task 3
//Sareh Jalalizad
// Implement a generic iterable FIFO-queue based on a double linked list.
// This is FIFO queue, so adds elements at the back of the queue and removes elements from the front.
// enqueue(Item) adds an Item (generic)
//  dequeue() removes an Item from queue (if queue is not empty)
//  ToString(LinkedList) transforms a queue of char into a string

//Code for iterator from the book from Algorithms, 4th ed. Sedgewick & Wayne


import java.util.Iterator;



public class LinkedQueue<Item> implements Iterable<Item> {
	
	private int N;     //number of elements on queue
	private Node first;  //beginning of queue
	private Node last;   //end of queue
	
  private class Node { 
	  
	   Item item;
	   Node next;
	   Node prev;
  }

  // Initializes an empty queue
  public LinkedQueue() {
	  
	  first = null;
	  last = null;
	  N = 0;

  }
  
  //check is queue empty?return true if this queue is empty;
  //false otherwise
  public boolean isEmpty() {
	  return first == null;
  }
  
  //Returns the number of items in this queue.
  public int size() {
	  return N;
  }
  
 
  //Adds the item to queue (in last index)(FIFO)
  public void enqueue(Item item) {
	  
	  Node oldlast = last;   // save old last and creates a new last
	  last = new Node();
	  last.item = item;    //sets value of new last
	  last.next = null;    //since last is last index in the queue set next pointer to null
	  
	  if(first == null) {   // when queue is empty
		 first = last;   //last and first is same so item added in both last and first 
	     first.prev = null;
	  }
		 else {
	       oldlast.next = last;
	      last.prev = oldlast;
	  }

	  N++;      //When a new item is added to the list the size increases by one.
	  
	  
  }
  


   //Remove the item on queue(that was least recently added) 
  public void dequeue() {
	   
	   first = first.next;
   
	  if (isEmpty())    
		 last = null;
	   
	 
	   N--;      //When a item is removed to the list the size decreases by one.
   }
   
     
   
   //Returns an iterator that iterates over the items in this queue in FIFO order
   public Iterator<Item> iterator()  {
       return new LinkedIterator();  
   }
   
   
   //An iterator
   private class LinkedIterator implements Iterator<Item> {
	   
	   private Node current = first;
	   public boolean hasNext() {
		   return current != null;
	   }
       public Item next() {
    	   Item item = current.item;
    	   current = current.next;
    
    	   return item;	   
       }
   }
   
// A method that iterates through the list and represents the items between brackets
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		for(Item item : this) {      
			sb.append("[" + item + "]  ");
			
		}
		return sb.toString();
	}
	  
   
   
   //test client
   public static void main(String[] args) {
	   
	   LinkedQueue<Character> c = new LinkedQueue<Character>();
	   
	   c.enqueue('A');
	   System.out.println(c.toString());
	   c.enqueue('B');
	   System.out.println(c.toString());
	   c.enqueue('C');
	   System.out.println(c.toString());
	   c.enqueue('D');
	   System.out.println(c.toString());
	   c.enqueue('E');
	   System.out.println(c.toString());
	   c.dequeue();
	   System.out.println(c.toString());
	   c.enqueue('F');
	   System.out.println(c.toString());
	   c.enqueue('g');
	   System.out.println(c.toString());
	   c.dequeue();
	   System.out.println(c.toString());
	   c.dequeue();
	   System.out.println(c.toString());
	   c.dequeue();
	   System.out.println(c.toString());
	 
   }


   
   
}


