//Sareh Jalalizad

//Simple Queue implementation based on algorithms 4th edition.
	 
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue <Item> implements Iterable<Item> {
	private Node<Item> first;    // beginning of queue
	private Node<Item> last;     // end of queue
	private int n;               // number of elements on queue

	private static class Node<Item> {
		private Item item;
		private Node<Item> next;
	}

	public Queue() {
		first = null;
		last  = null;
		n = 0;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public int size() {
		return n;
	}

	public void enqueue(Item item) {
		Node<Item> oldlast = last;
		last = new Node<Item>();
		last.item = item;
		last.next = null;
		if (isEmpty())
			first = last;
		else          
			oldlast.next = last;
		n++;
	}

	public Item dequeue() {
		if (isEmpty())
			throw new NoSuchElementException("Queue underflow");
		Item item = first.item;
		first = first.next;
		n--;
		if (isEmpty())
			last = null;
		return item;
	}  

	public Iterator<Item> iterator()  {
		return new ListIterator<Item>(first);  
	}


	@SuppressWarnings("hiding")
	private class ListIterator<Item> implements Iterator<Item> {
		private Node<Item> current;

		public ListIterator(Node<Item> first) {
			current = first;
		}

		public boolean hasNext(){
			return current != null;
		}
		public void remove(){
			throw new UnsupportedOperationException();
		}

		public Item next() {
			if (!hasNext()) 
				throw new NoSuchElementException();
			Item item = current.item;
			current = current.next; 
			return item;
		}
	}

}


