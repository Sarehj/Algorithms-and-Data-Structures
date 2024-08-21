//Sareh Jalalizad
//Implements binary search tree.
//Time complexity is N.

// N = 100, time taken by an average of 10 tests: 0.030 , word "of"
// N = 200, time taken by an average of 10 tests: 0.033 , word "Chapter"
// N = 400, time taken by an average of 10 tests: 0.035 , word "Chapter"
// N = 800, time taken by an average of 10 tests: 0.038 , word "the"
// N = 1000, time taken by an average of 10 tests: 0.041 , word "the"

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Scanner;

	
	//Binary search Tree
	public class Two2<Key extends Comparable<Key>, Value>{
	    
	   
		private Node root; // root of BST


	   // Stores the key and value of each element in the binary tree as well as pointing to nodes at lower
	   // branches of the binary tree.
	   
	    private class Node
	    {
	        private Key key;          // sorted by key       
	        private Value val;        // associated value
	        private Node left, right; // left and right subtrees
	        private int N ;            // number of nodes in subtree rooted here

	      
	        
	        
	       // key is the identifier of each <>Node</>.
	       // val is the value of a specific key.
	       // N keeps track of the number of keys in the binary tree.
	        public Node(Key key, Value val, int N){
	            this.key = key; 
	            this.val = val; 
	            this.N = N;
	        }
	    }

	 


		// Returns the size of the tree.
	    public int size(){
	       
	    	return size(root);
	    }

	    
	   //Recursive method called by size to count the number of nodes below a specific Node
	   //of the tree (the subtree).
	   // x is the node from which to count the number of nodes.
	   // return number of key-value pairs in BST rooted at x.  
	    private int size(Node x){
	      
	    	if (x == null)
	        	return 0;
	        else 
	        	return x.N;
	    }

	    
	  //return is the value of the given key. Null if key not present in tree.
	    public Value get(Key key){
	        
	    	return get(root, key);
	    }

	    
	    
	 // Recursive method for getting the value of a given key.
	 // x is the node from who's subtree you search for the given keys value.
	 // key is the key which value is of interest.
	 // Return value associated with key in the subtree rooted at x;
	    private Value get(Node x, Key key){ 
	       
	    	// return null if key is not in subtree rooted at x.
	        if (x == null) 
	        	return null;
	         
	        int cmp = key.compareTo(x.key);
	       
	        if (cmp < 0) 
	        
	        	return get(x.left, key);
	       
	        else if (cmp > 0) 
	           
	        	return get(x.right, key);
	        
	        else 
	        
	        	return x.val;
	    }

	    
	    
	    //Inserts a given key and its value to the binary tree.
	    //key is the key being inserted.
	    //val is the value of the given key.
	    public void put(Key key, Value val){
	      
	    	root = put(root, key, val);
	    }
	    
	  
	    
	 //Updates a keys value if the key is rooted at the subtree of Node x. If key not present in subtree
	 //it gets inserted to the left or right side of the subtree depending of the size of the given key.
	 //x is the node from which the current subtree is rooted from.
	 //key is the key being inserted to the tree.
	 //value is the value of the key of interest.
	    private Node put(Node x, Key key, Value val){
	  
	        if (x == null) 
	            
	        	return new Node(key, val, 1);

	        int cmp = key.compareTo(x.key);
	       
	        if (cmp < 0) 
	           
	        	x.left = put(x.left, key, val);
	        
	        else if (cmp > 0) 
	           
	        	x.right = put(x.right, key, val);
	       
	        else 
	           
	        	x.val = val;
	        
	        x.N = size(x.left) + size(x.right) + 1;
	       
	        
	        return x;      //return is the node of the given key.
	    }

	 
	  //Returns the smallest key of the tree.
	    public Key min()
	    {
	        return min(root).key;
	    }

	 
	  //Returns the smallest key of the current subtree.
	    private Node min(Node x)
	    {
	        if (x.left == null) return x;
	       
	        return min(x.left);
	    }

	  
	  //Returns the largest key of the tree.
	    public Key max()
	    {
	        return max(root).key;
	    }

	    
	   //Returns the largest key of the current subtree.
	    private Node max(Node x)
	    {
	        if (x.right == null) return x;
	        return max(x.right);
	    }


	   
	   //States if a tree contains a given key.
	   //return true if the tree contains the given key. False if not.
	    public boolean contains(Key key) {
			if (key == null) {
				throw new IllegalArgumentException("Argument to contains() cannot be null");
			}
			return get(key) != null;
	    }
	    
	  
	    
	    
	  //Specifies how many keys less then the given key value is in the subtree of the node with the given key.
	  //return is the number of keys less than the subtree of the given key value.
	    public int rank(Key key)
	    { 
	        return rank(key, root); 
	    }

	    
	  //Returns the number of keys that have a less key value in the subtree rooted at the node x.
	    private int rank(Key key, Node x){ 
	        if (x == null) 
	           
	        	return 0;
	        
	        int cmp = key.compareTo(x.key);
	       
	        if (cmp < 0) 
	           
	        	return rank(key, x.left);
	       
	        else if (cmp > 0) 
	           
	        	return 1 + size(x.left) + rank(key, x.right);
	        
	        else return 
	        
	        		size(x.left);
	    }

	 
	    // Returns all the keys in the table.
	    public Iterable<Key> keys()
	    { 
	        return keys(min(), max());
	    }

	    
	  //Returns all keys in the symbol table in the given range,
	  // as an  Iterable
	    public Iterable<Key> keys(Key lo, Key hi)
	    {
	        Queue<Key> queue = new LinkedList<>();
	        keys(root, queue, lo, hi);
	       
	        return queue;       //return is all the keys in a queue.
	    }

	    
	   //Puts all keys of the tree in a queue in the order of priority.
	   //x is the root of the current subtree.
	   //queue is the queue with all the keys.
	   //lo is the smallest key of the tree.
	   //hi is the largest key of the tree. 
	    private void keys(Node x, Queue<Key> queue, Key lo, Key hi)
	    {
	        if (x == null) 
	        	return;
	        
	        int cmplo = lo.compareTo(x.key);
	        int cmphi = hi.compareTo(x.key);
	       
	        if (cmplo < 0) 
	        
	        	keys(x.left, queue, lo, hi);
	       
	        if (cmplo <= 0 && cmphi >= 0) 
	        
	        	queue.add(x.key);
	        
	        if (cmphi > 0) 
	        
	        	keys(x.right, queue, lo, hi);
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
	
	    @SuppressWarnings("resource")
		public static void main(String[] args) throws FileNotFoundException  {
		
	    	File file = new File ("C:\\Users\\sareh\\Desktop\\Lab3\\Input.txt");
	    	Scanner sc = new Scanner(file);

			int minlen = 1; // key-length cutoff
	        Stopwatch timer = new Stopwatch();

	        
	        
			Two2<String, Integer> st = new Two2<String, Integer>();
			
			
			while (sc.hasNext()) { // Build symbol table and count frequencies.
			
				String word = sc.next(); 
				
				if (word.length() < minlen)
				
					continue; // Ignore short keys.
				
				if (!st.contains(word))
					
					st.put(word, 1);    //Key inserted first time
				
				else
				
					st.put(word, st.get(word) + 1);   //Key was already found
	        }
		
			// Find a key with the highest frequency count.
			
			String max = "";
			st.put(max, 0);
			
			for (String word : st.keys())
				
				if (st.get(word) > st.get(max))
					max = word;
	      
			
			System.out.println(max + " " + st.get(max) + "\n");
	        
	        double time = timer.elapsedTime();
	       
	        System.out.println("\n"+"The Binary Search Tree time: " + time);

		}

}
