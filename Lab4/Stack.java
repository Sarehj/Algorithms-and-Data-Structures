//Sareh Jalalizad

//Simple stack implementation based on algorithms 4th edition.
	 
import java.util.Iterator;


	public class Stack<Item> implements Iterable<Item> {
	    private Node<Item> first;     // top of stack

	    // helper linked list class
	    private static class Node<Item> {
	        private Item item;
	        private Node<Item> next;
	    }

	    
	  //Initializes an empty stack. 
	    public Stack() {
	        first = null;
	    }



	  // Adds the item to this stack.
	    public void push(Item item) {
	        Node<Item> oldfirst = first;
	        first = new Node<Item>();
	        first.item = item;
	        first.next = oldfirst;

	    }



	  // Returns an iterator to this stack that iterates through the items in LIFO order.
	    public Iterator<Item> iterator() {
	        return new ListIterator(first);
	    }

	    // an iterator, doesn't implement remove() since it's optional
	    private class ListIterator implements Iterator<Item> {
	        private Node<Item> current;

	        public ListIterator(Node<Item> first) {
	            current = first;
	        }

	        public boolean hasNext() {
	            return current != null;
	        }

	        public Item next() {

	            Item item = current.item;
	            current = current.next;
	            return item;
	        }
	    }

}
