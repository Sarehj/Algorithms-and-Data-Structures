//Sareh Jalalizad

//Implement  hashcode() function for strings in Java distributes the hashcodes for the words found in the text.
//Prints its content to see how well distributed it is.

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
@SuppressWarnings("unchecked")

//Creates a hash table of ordered arrays (binary search) 
//and prints out sizes of all ordered arrays


	public class Three<Key, Value> {

	    private int n;       // number of key-value pairs
	    private int m;       // hash table size
	    private Node[] st;   // array of linked-list symbol tables

	   
	    // a helper linked list data type
	    private static class Node {
	        private Object key;
	        private Object val;
	        private Node next;

	       
	        public Node(Object key, Object val, Node next)  {
	            this.key  = key;
	            this.val  = val;
	            this.next = next;
	        }
	    }

	    // create separate chaining hash table
	    public Three() {
	        this(997);
	    }

	   
	  
	    // create separate chaining hash table with m lists
	    public Three(int m) {
	       
	    	this.m = m;         //size of this hash table
	        st = new Node[m];
	    }


	    // hash value between 0 and m-1
	    private int hash(Key key) {
	    	
	    	// masks off sign bit and returns remainder when dividing by hash table size (m)
	        return (key.hashCode() & 0x7fffffff) % m;   
	    }

	    // return number of key-value pairs in symbol table
	    public int size() {
	        return n;
	    }

	    // is the symbol table empty?
	    public boolean isEmpty() {
	       
	    	return size() == 0;
	    }

	
	    // if symbol tree at st[] contains word returns true
	    public boolean contains(Key key) {
	       
	    	 if (key == null) throw new IllegalArgumentException("argument to contains() is null");
	    	return get(key) != null;
	    }

	   
	   // return value associated with key, null if no such key
		public Value get(Key key) {
	     
	        if (key == null) throw new IllegalArgumentException("argument to get() is null");
	        
	    	int i = hash(key);
	        
	    	for (Node x = st[i]; x != null; x = x.next) {
	        
	    		if (key.equals(x.key)) 
	            
	    			return (Value) x.val;
	        }
	       
	    	return null;
	    }

	    // insert key-value pair into the table overwriting the old 
	    // value with the new value if the symbol table already contains the specified key.
	    // Deletes the specified key (and its associated value) from this symbol table
	    // if the specified value is null.
	    public void put(Key key, Value val) {
	       
	    	 if (key == null) throw new IllegalArgumentException("first argument to put() is null");
	    	 
	    	if (val == null) {
	    		delete(key);
	            return;
	        }
	       
	    	int i = hash(key);
	      
	    	for (Node x = st[i]; x != null; x = x.next) {
	        
	    		if (key.equals(x.key)) {
	            
	    			x.val = val;
	             
	    			return;
	            }
	        }
	      
	    	n++;
	        st[i] = new Node(key, val, st[i]);
	    }

	    
	    
	    // delete key and its associated value from the symbol table (if the key is in this symbol table)
	  public void delete(Key key) {
	        throw new UnsupportedOperationException("delete not currently supported");
	    }

	  
	 
	  // return all keys as an Iterable
	  public Iterable<Key> keys()  {
	       
		  Queue<Key> queue = new LinkedList<Key>();
	      
		  for (int i = 0; i < m; i++) {
	            for (Node x = st[i]; x != null; x = x.next) {
	               
	            	queue.add((Key) x.key);
	            }
	        }
	      
		  return queue;
	    }

	  
   //Prints its content to see how well distributed it is.
	  public void printh () {
		
		  for (int i = 0; i < st.length ; i++) {
				
			  int size = 0;
			  Node linkedlist = st[i];
				
			  while( linkedlist != null){
					
				  size++;
				  linkedlist = linkedlist.next;
				}
			
			  System.out.println(size);
			}
		}

	  
	  
	    public static class Stopwatch{
	        private final long start;

	        public Stopwatch(){
	            start = System.nanoTime(); //Initializes a new stopwatch
	        }
	        
	        //Returns the elapsed time in seconds 
	       
	        public double elapsedTime(){
	            long now = System.nanoTime();
	            return (now - start)/1000000.0 ;
	        }
	    }
	    

      //test client.
	  @SuppressWarnings("resource")
	public static void main(String[] args) throws FileNotFoundException  {
			
	    	File file = new File ("C:\\Users\\sareh\\Desktop\\Lab3\\Input.txt");
	    	Scanner sc = new Scanner(file);
			
	        Stopwatch timer = new Stopwatch();

	        Three<String, Integer> st = new Three<String, Integer>(97);

	        for (int i = 0; sc.hasNext(); i++) {
	        
	        	String key = sc.next();
	            st.put(key, i);
	        }
	        

	        st.printh();

	            double time = timer.elapsedTime();
	            System.out.println("Distributes the hashcodes time: " + time);

	    }
}
