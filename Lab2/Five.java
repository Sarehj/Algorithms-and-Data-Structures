//Sareh Jalalizad

// Creates randomly generated arrays and sorts them with either of the algorithms Merge Sort or Insertion Sort.
// Creates arrays with randomly generated integers as elements. Calls for either insertion Sort or
// Merge Sort methods to sort them in ascending order.

//Insertion sort, sort small array faster than merge sort but merge sort sort large array more faster. 


import java.util.Random;

public class Five {

	    public static void main(String[] args) {

	       	    	
	    	int[] InserArray = new int [10000];
	    	int[] mergeArray = new int [10000];
	    	randomArray(InserArray,mergeArray);
	    	
	       
	    	System.out.println("Merge Sorting Process Begins");
	        
	        Stopwatch mergeStartTime = new Stopwatch();
	        mergeSort(mergeArray);
	        double mergeTimePassed = mergeStartTime.elapsedTime();

	        System.out.println("Merge Sorting Process Ends");
	        System.out.println("Merge array is sorted: " + isSorted(mergeArray));
	        System.out.println("Execution time for Merge Sorting " + mergeArray.length + " elements: " + mergeTimePassed/1000000 + " milliseconds");

	        mergeArray = null;

	      
	    	
	        System.out.println("Insertion Sorting Process Begins");
	        
	        Stopwatch insertionStartTime = new Stopwatch();
	        Insertionsort(InserArray);
	        double insertionTimePassed = insertionStartTime.elapsedTime();

	        System.out.println("Insertion Sorting Process Ends");
	        System.out.println("Insertion array is sorted: " + isSorted(InserArray));
	        System.out.println("Execution time for Insertion Sorting " + InserArray.length + " elements: " + insertionTimePassed/1000000 + " milliseconds");

	        InserArray = null;



	    }

	    public static class Stopwatch{
	        private final long start;

	        public Stopwatch(){
	            start = System.nanoTime(); //Initializes a new stopwatch
	        }
	        
	        //Returns the elapsed time in seconds 
	       
	        public double elapsedTime(){
	            long now = System.nanoTime();
	            return (now - start) ;
	        }
	    }
	    
	  
	    

	    private static int[] auxiliary;     //Auxiliary array for merges during Merge Sort


	     // Initializes an auxiliary array as well as calls the method mergeSort to initiate the Merge Sort algorithm.
	    public static void mergeSort(int[] array) {

	        auxiliary = new int[array.length];
	        mergeSort(array, 0,array.length - 1);
	    }


	     // Sorts an array of integers using the algorithm mergeSort.
	     // lo is the lower boundary of the elements being sorted.
	     // hi is the higher boundary of the elements being sorted.
	     //middle is the cut off between the low and high boundaries.
	    private static void mergeSort(int[] array, int lo, int hi) {

	            if (hi <= lo)
	                return;

	            int middle = lo + (hi - lo)/2;

	            mergeSort(array, lo, middle);
	            mergeSort(array, middle + 1, hi);
	            merge(array, lo, middle, hi);
	    }


	    //Merges two parts of an arrays by first copying into the auxiliary array, sorting the elements and then merging back
	    //the sorted elements to the original array.
	    private static void merge(int[] array, int lo, int middle, int hi) {

	        int i = lo;
	        int j = middle + 1;

	      // copy to aux[]
	        for (int k = lo; k <= hi; k++)
	            auxiliary[k] = array[k];

	      // merge back to a[]
	        for (int k = lo; k <= hi; k++)
	            if (i > middle)
	                array[k] = auxiliary[j++];
	            else if (j > hi)
	                array[k] = auxiliary[i++];
	            else if (less(auxiliary[j], auxiliary[i]))
	                array[k] = auxiliary[j++];
	            else
	                array[k] = auxiliary[i++];

	    }



	      // Sorts an array of integer using the algorithm Insertion Sort.
	      //lo is the lowest index of the array.
	      //hi is the highest index of the array.
	    public static void Insertionsort (int[] a) {

	    	 for (int i = 1; i < a.length; i++){                     //starts from the 2nd index of the array

	         	for(int j = i; j > 0 && a[j] < a[j - 1]; j--){      //second loop compares current index with the value in the array index directly smaller

	         		int s;                   //and swaps the positions if the value in the current index is smaller.
	                 s = a[j];
	                 a[j] = a[j - 1];
	                 a[j - 1] = s;
	            }

	        }
	}

	    	    
	    public static void randomArray(int[]arrayIn, int []arrayMe) {
	        int i = 0;
	           int low = -99;
	           int high = 100;
	           Random r = new Random();
	           while(i < arrayIn.length)
	           {
	              int n = r.nextInt(high - low) + low;
	              arrayIn[i] = n;
	              arrayMe[i] = n;
	              i++;
	           }
	      }

	     
	    // Compares two elements and returns true if the parameter a has a smaller value
	     // than the parameter b.
	     // a is the first given element.
	     // b is the second given element.
	     // true if the element a is smaller than the element b. If not, it is false.
	    private static boolean less(int a, int b) {
	        return a < b;
	    }


	  //Test whether the elements of a given array is in an ascending order.
	  //return true if the array is sorted in ascending order, false if not.
	    private static boolean isSorted(int[] array) {
	        for (int i =  1; i < array.length; i++)
	            if (less(array[i], array[i-1])) return false;
	        return true;
	    }
	}
