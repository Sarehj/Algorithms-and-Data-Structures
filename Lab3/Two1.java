//Sareh Jalalizad

//Implements binary search in ordered array.

//Time complexity is log N.

// N = 100, time taken by an average of 10 tests: 0.028 , word "of"
// N = 200, time taken by an average of 10 tests: 0.031 , word "Chapter"
// N = 400, time taken by an average of 10 tests: 0.034 , word "Chapter"
// N = 800, time taken by an average of 10 tests: 0.036 , word "the"
// N = 1000, time taken by an average of 10 tests: 0.039 , word "the"

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


	public class Two1<Key extends Comparable<Key>, Value> {

		private Key[] keys;
		private Value[] vals;
		private int N;

		
		//Creates an ordered symbol table with the specified initial capacity.
		@SuppressWarnings("unchecked")
		
		public Two1(int capacity) { 
			keys = (Key[]) new Comparable[capacity];
			vals = (Value[]) new Object[capacity];
		}

		// Number of key-value pairs in the table.
		public int size() {
			return N;
		}

		
	  //States if the table is empty or not.
	  //return is true if empty, false if not.
		public boolean isEmpty() {
			return N == 0;
		}

		
	  // Returns the value paired with a given key. Null if key is not in table.	
		public Value get(Key key) {
			
			if (isEmpty())
				return null;
		
			int i = rank(key);
			
			if (i < N && keys[i].compareTo(key) == 0)
				
				return vals[i];
			
			else
			
				return null;
		}

		
	// Search for key. Update value if found; grow table if new.
	//Puts a key-value pair into the table and removes key from the table if value is null.	
	//key is the key data being put to the table.
	//value is the value of the given key.	
		public void put(Key key, Value val) { 
			
			int i = rank(key);    // returned key from rank 
			
			//to check if it is the same with the one asked for.
			if (i < N && keys[i].compareTo(key) == 0) {
				vals[i] = val;
			
				return;    //returns the value located at that key.
			}
			
		
			//starts from the end to where we put the new element
			//everything (both keys and values) from end to the newly added element moves one forward
			
			for (int j = N; j > i; j--) {
			
				keys[j] = keys[j - 1];
				vals[j] = vals[j - 1];
			}
			    keys[i] = key;   //the newly added key
			    vals[i] = val;   //added key's value
			    N++;
		}

		
		
		//Computes the number of keys in the table that are smaller than key. Uses binary search.
	    //key is the key that is the max key value wanted.
	    //return is the number of keys smaller than parameter key.
		public int rank(Key key) {
			
			int lo = 0, hi = N - 1;
			
			while (lo <= hi) {
				
				int mid = lo + (hi - lo) / 2;
				int cmp = key.compareTo(keys[mid]);
				
				if (cmp < 0)       //if key is in the left side of the array
					
					hi = mid - 1;
			
				else if (cmp > 0)   //if key is in the right side of the array
				
					lo = mid + 1;
				
				else
				
					return mid;     //if key is the middle
		}
			return lo;
		}

		
	//simple function to check whether symbol tree contains Key
		public boolean contains(Key key) {
			if (key == null) {
				throw new IllegalArgumentException("Argument to contains() cannot be null");
			}
			return get(key) != null;
		}

	
		
	 //Returns the smallest key.	
		public Key min() {
			if (isEmpty()) {
				throw new NoSuchElementException("Empty symbol table");
			}

			return keys[0];
		}

		
	  //Returns the largest key.	
		public Key max() {
			if (isEmpty()) {
				throw new NoSuchElementException("Empty symbol table");
			}

			return keys[N - 1];
	    }
	    

		
		
		// Returns all the keys in the table.
	    public Iterable<Key> keys() {
				return keys(min(), max());
			}
	    
	    
		
	//Keys of the table from low to high in sorted order.
	//return the total number of keys in the given set of keys.	
		public Iterable<Key> keys(Key low, Key high) {
		
			if (low == null || high == null) {
				throw new IllegalArgumentException("Key cannot be null");
			}

			Queue<Key> queue = new LinkedList<>();

			for (int i = rank(low); i < rank(high); i++) {
				queue.add(keys[i]);
			}

			if (contains(high)) {
				queue.add(keys[rank(high)]);

			}

			return queue;
		}

	   
	    
	    public static class Stopwatch{
	        private final long start;

	        public Stopwatch(){
	            start = System.nanoTime(); //Initializes a new stopwatch
	        }
	        
	        //Returns the elapsed time in seconds 
	       
	        public double elapsedTime(){
	            long now = System.nanoTime();
	            return (now - start)/10000000.0 ;
	        }
	    }

	    
	    
	//test
	    @SuppressWarnings("resource")
	    public static void main(String[] args) throws FileNotFoundException  {
		
	    	File file = new File ("C:\\Users\\sareh\\Desktop\\Lab3\\Input.txt");
	    	Scanner sc = new Scanner(file);
		
	    	int minlen = 1;   // key-length cutoff
			Stopwatch timer = new Stopwatch();

			Two1<String, Integer> st = new Two1<String, Integer>(1000000);
			
			// Build symbol table and count frequencies.
			while (sc.hasNext()) {
				
				String word = sc.next(); 
				
				if (word.length() < minlen)
					continue;     // Ignore short keys.
				
				if (!st.contains(word))
					st.put(word, 1);     //Key inserted first time
				
				else
					st.put(word, st.get(word) + 1);   //Key was already found
			}

			// Find a key with the highest frequency count.
			String max = "";
			st.put(max, 0);
			
			for (String word : st.keys())
				if (st.get(word) > st.get(max))
					max = word;
		
			
			System.out.println(max + " " + st.get(max));

			double time = timer.elapsedTime();
	        System.out.println("\n"+"The ordered array ST time: " + time);
		}
}
