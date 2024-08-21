//Sareh Jalalizad

//Another way to implement the higher grade assignment


import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;




public class BST<Key extends Comparable<Key>, Value extends Comparable<Value>>{
    //BST
    private Node root; // root of BST
    
    // Stores the key and value of each element in the binary tree as well as pointing to nodes at lower
	// branches of the binary tree.    

    private class Node
    {
        private Key key; // key       
        private Value val; // associated value
        private Node left, right; // links to subtrees
        private int N; // # nodes in subtree rooted here

        
        
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
     public int sizeBst(){
         
    	 return sizeBst(root);
    }

     
     //Recursive method called by size to count the number of nodes below a specific Node
	 //of the tree (the subtree).
     // x is the node from which to count the number of nodes.
     //return is the number of NOdes below a specific node.	  
      private int sizeBst(Node x){
          
    	  if (x == null) 
    		  return 0;
          
    	  else 
    		  return x.N;
    }

     //return is the value of the given key. Null if key not present in tree. 
      public Value getBst(Key key){
           
    	  return getBst(root, key);
    }

      
      // Recursive method for getting the value of a given key.
	  // x is the node from who's subtree you search for the given keys value.
      // key is teh key which value is of interest.
	  // return is the value of the given key.
	  // Return value associated with key in the subtree rooted at x;
       private Value getBst(Node x, Key key){ // Return value associated with key in the subtree rooted at x;
           // return null if key not present in subtree rooted at x.
         
    	   if (x == null) 
    		   
    		   return null;
           
    	    int cmp = key.compareTo(x.key);
           
    	   if (cmp < 0) 
             
    		   return getBst(x.left, key);
          
    	   else if (cmp > 0) 
           
    		   return getBst(x.right, key);
        
    	   else 
           
    		   return x.val;
    }

   
       //Inserts a given key and its value to the binary tree.
	   //key is the key being inserted.
	   //val is the value of the given key.
       public void putBst(Key key, Value val){
      
    	   root = putBst(root, key, val);
    }
    
       
       
  	    //Updates a keys value if the key is rooted at the subtree of Node x. If key not present in subtree
		//it gets inserted to the left or right side of the subtree depending of the size of the given key.
		//x is the node from which the current subtree is rooted from.
		//key is the key being inserted to the tree.
		//value is the value of the key of interest.
       private Node putBst(Node x, Key key, Value val){
   
        if (x == null) 
      
        	return new Node(key, val, 1);

        int cmp = key.compareTo(x.key);
        
        if (cmp < 0) 
        
        	x.left = putBst(x.left, key, val);
        
        else if (cmp > 0) 
       
        	x.right = putBst(x.right, key, val);
        
        else 
        
        	x.val = val;
        
        x.N = sizeBst(x.left) + sizeBst(x.right) + 1;
      
        return x;
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
		
    	   return getBst(key) != null;
    }
  
      
        
  	  //Specifies how many keys less then the given key value is in the subtree of the node with the given key.
      //return is the number of keys less then then the subtree of the given key value.     
       public int rank(Key key)
    { 
        return rank(key, root); 
    }

       
       
    //Returns the number of keys that have a less key value in the subtree rooted at the node x.   
      private int rank(Key key, Node x)
    { 
        if (x == null) 
            return 0;
      
        int cmp = key.compareTo(x.key);
        
        if (cmp < 0) 
        
        	return rank(key, x.left);
        
        else if (cmp > 0) 
        
        	return 1 + sizeBst(x.left) + rank(key, x.right);
        
        else return 
        
        		sizeBst(x.left);
    }

      
    //Makes a queue of all the keys in the tree.   
       public Iterable<Key> keys()
    { 
        return keys(min(), max());
    }

   
       
       public Iterable<Key> keys(Key lo, Key hi)
    {
        Queue<Key> queue = new Queue<>();
        keys(root, queue, lo, hi);
       
        return queue;      //return is all the keys in a queue.
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

    
       
   //Function to return a certain range of frequency ranking
    public void rankN(int n, int x){                            
      
    	BST<Key, Value> st = new BST<Key, Value>();      //copy BST
        LinkedList<Key> list = new LinkedList<Key>();    //Linked list to store ranking in order
        
        Key iteKey = null;
        Value iteVal = null;

        for(int i = 0; i < x; i++){           //only do this for the upper value of the range
            for(Key key : this.keys()){       //iterate through original BST
            	
            	//Update temp Key and temp Value to the root's key and value if copy BST does not store the node
                if(iteKey == null && !st.contains(key)){  
                   
                	iteKey = key;
                    iteVal = this.getBst(key);
                }
            
                //Update temp Key and temp Value if the current node has greater value
                //and the copy BST does not store the current node
                //this will return the greatest value node on first iteration,
                //next greatest value node on the second and so on
                if(iteVal.compareTo(this.getBst(key)) < 0 && !st.contains(key)){
                
                	iteKey = key;      
                    iteVal = this.getBst(key);    }
            }
           
            st.putBst(iteKey, iteVal);    //add current node to copy BST so that the next time it iterates it won't consider this node
            if(!list.contains(iteKey)){   //add it to the linked list; this list will be in value order
                list.add(iteKey);
            }
        
            iteKey = null;               //set temp value to null for next iteration.
        }

        for(int i = 0; i < n; i++){
            list.removeFirst();         //remove the first nodes to satisfy the user's input range
        }

        ListIterator<Key> iterator = list.listIterator(0); 

        System.out.println("The " + (list.size() + 1 )+"th most common word" );
      
        while(iterator.hasNext()){
            
        	Key k = list.removeFirst();
        
            System.out.println("\n" +  k + " " + getBst(k));
        }

    //    System.out.println(list.size());
    }

   


    public static class Stopwatch{
        private final long start;

        public Stopwatch(){
            start = System.nanoTime(); //Initializes a new stopwatch
        }
        
        //Returns the elapsed time in seconds 
       
        public double elapsedTime(){
            long now = System.nanoTime();
            return (now - start)/1000.0 ;
        }
    }
    
	public static void main(String[] args) throws FileNotFoundException {

       
		
        File file = new File ("C:\\Users\\sareh\\Desktop\\Lab3\\Input.txt");
    	Scanner sc = new Scanner(file);
		int minlen = 1; // key-length cutoff
		
		BST<String, Integer> st = new BST<String, Integer>();
		
		while (sc.hasNext()) { // Build symbol table and count frequencies.
			String word = sc.next(); 
			if (word.length() < minlen)
				continue; // Ignore short keys.
			
			if (!st.contains(word))
			
				st.putBst(word, 1);
		
			else
				st.putBst(word, st.getBst(word) + 1);
        }
        
        Stopwatch timer = new Stopwatch();
	
    
        
        //for kth element should write like (k-1,k)
        //for kth to k+nth (k,k+n)
        st.rankN(1,2);
        
		

      
		double time = timer.elapsedTime();
        System.out.println("\n" + "time taken: " + time);
	}
}