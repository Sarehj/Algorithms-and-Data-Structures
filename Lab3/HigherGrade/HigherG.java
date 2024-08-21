//Sareh Jalalizad

//Implement a program which takes as input a text file and allows the user to (repeatedly without re-reading the input file) ask questions: 
//i) Which is the k:th most common word
//ii) Which are the k:th to the k+n:th most common words

//Implements binary search in ordered array.
//Time complexity is log N.
	

    import java.io.File;
	import java.io.FileNotFoundException;
	import java.util.*;

		public class HigherG<Key extends Comparable<Key>, Value> {

			private Key[] keys;
			private Value[] vals;
			private int N;

			
			//Creates an ordered symbol table.
			@SuppressWarnings("unchecked")
			
			public HigherG(int capacity) { 
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

			
		  // Returns the value paired with a given key. Null if key is absent.	
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
		// value is the value of the given key.	
			public void put(Key key, Value val) { 
				
				int i = rank(key);    // returned key from rank 
				
				//to check if it is the same with the one asked for and returns the value located at that key.
				if (i < N && keys[i].compareTo(key) == 0) {
					vals[i] = val;
				
					return;
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

			
			
			//Computes the number of keys in the table that are smaller than key. Uses binary search non-recursively.
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
		    

			
			 public void sort() {
			        Value tempV;
			        Key tempK;
			       
			        for (int i = 1; i < N; i++)  //starts from the 2nd index of the array
			           
			        	// Check the neighbouring elements.
			            for (int j = i; j > 0 ; j--) {
			        
			            	if (compare(vals[j-1],vals[j])) {
			                
			            		tempV = vals[j - 1];  //and swaps the key and value if the value in the current index is smaller.
			                    vals[j - 1] = vals[j];
			                    vals[j] = tempV;

			                    tempK = keys[j - 1];
			                    keys[j - 1] = keys[j];
			                    keys[j] = tempK;

			                }
			            }
			        }
			
			 
			 public boolean compare(Object x, Object y){
			        int x1 = (int) x;
			        int y1 = (int) y;
			        if (y1 - x1 > 0)
			        return true;

			        else return false;
			 }
			 
			 
			  
			   public void maxk(int i){
			      
			       Key k = keys[i-1];
			     Value v = vals[i-1];
			 
			     System.out.println("The " + (i) + "th most common word in the text is:" +"\n " + k + "    "  + v);
			    }


			    public void maxKN(int i, int j){
			    
			    	System.out.println("The most common word from " + i + "th to " + j + "are : " + "\n");
			        for (int k = i; k < j + 1; k++ )
			            maxk(k);

			    }
			 
		//Keys of the table from low to high in sorted order.
		//return is the total number of keys in the given set of keys.	
			public Iterable<Key> keys(Key low, Key high) {
			
				if (low == null || high == null) {
					throw new IllegalArgumentException("Key cannot be null");
				}

				Queue<Key> queue = new Queue<>();

				for (int i = rank(low); i < rank(high); i++) {
					queue.add(keys[i]);
				}

				if (contains(high)) {
					queue.add(keys[rank(high)]);

				}

				return queue;
			}

			
			// Returns all the keys in the table.
		    public Iterable<Key> keys() {
					return keys(min(), max());
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
			
		    	File file = new File ("C:\\Users\\sareh\\Desktop\\Lab3\\leipzig1m.txt");
		    	Scanner sc = new Scanner(file);
			
		    	int minlen = 1;   // key-length cutoff
				Stopwatch timer = new Stopwatch();

				HigherG<String, Integer> st = new HigherG<String, Integer>(1000000);
				
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

				 st.sort();
				
				
				 Scanner input = new Scanner(System.in);  
				 System.out.println("Please enter the k: ");
				 int i = StdIn.readInt();
		       
				 st.maxk(i);
		      // st.maxk(2);

			
				 System.out.println("\n" + "Please enter the range: ");
				 int i1 = StdIn.readInt();
				 int i2 = StdIn.readInt();
				 st.maxKN(i1,i2);
				 
				 //st.maxKN(2,6);

			
				 
				double time = timer.elapsedTime();
		        System.out.println("\n" + "The ordered array ST time: " + time);
			}





}
