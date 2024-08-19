//Sareh Jalalizad

// Creates randomly generated arrays and sorts them with either of the algorithms Merge Sort or Quick Sort.
// Creates arrays with randomly generated integers as elements. Calls for either quick Sort or
// Merge Sort methods to sort them in ascending order.

//Quick sort, sorts faster than merge sort. 



import java.util.Random;

// Creates randomly generated arrays and sorts them with the algorithms Merge Sort and Quick Sort.

	public class higherG2 {

	 
	    public static void main(String[] args) {


	       	int[] quickArray = new int [10000000];
	    	int[] mergeArray = new int [10000000];
	    	randomArray(quickArray,mergeArray);
	    	
	    	
            System.out.println("Merge Sorting Process Begins");
	        
	        Stopwatch quickStartTime = new Stopwatch();
	        quickSort(quickArray,0,quickArray.length -1);
	        double quickTimeElapsed = quickStartTime.elapsedTime();
	       
	        System.out.println("Quick Sorting Process Ends");
	        System.out.println("Quick array is sorted: " + isSorted(quickArray));
	        System.out.println("Execution time for Quick Sorting " + quickArray.length + " elements: " + quickTimeElapsed/1000000 + " milliseconds");

	        quickArray = null;
	        
	        
	    
	        System.out.println("Merge Sorting Process Begins");
	        
	        Stopwatch mergeStartTime = new Stopwatch();
	        mergeSort(mergeArray);
	        double mergeTimePassed = mergeStartTime.elapsedTime();

	        System.out.println("Merge Sorting Process Ends");
	        System.out.println("Merge array is sorted: " + isSorted(mergeArray));
	        System.out.println("Execution time for Merge Sorting " + mergeArray.length + " elements: " + mergeTimePassed/1000000 + " milliseconds");

	        mergeArray = null;
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

	        auxiliary = new int[array.length];    // Allocate space just once
	        mergeSort(array, 0,array.length - 1);
	    }

	    
	     // Sorts an array of integers using the algorithm mergeSort.
	     // lo is the lower boundary of the elements being sorted.
	     // hi is the higher boundary of the elements being sorted.
	     //middle is the cut off between the low and high boundaries.
	     //merge sort a[lo..hi] using auxiliary array auxiliary[lo..hi]
	    private static void mergeSort(int[] array, int lo, int hi) {

	            if (hi <= lo)
	                return;

	            int middle = lo + (hi - lo)/2;

	            mergeSort(array, lo, middle);       //sort left part
	            mergeSort(array, middle + 1, hi);   //sort right part
	            merge(array, lo, middle, hi);       //merge results
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


	    
	     //Sorts an array of integer using the algorithm Quick Sort. 
	     // lo is the lower boundary of the elements being sorted.
	     // hi is the higher boundary of the elements being sorted.
	     //middle is the cut off between the low and high boundaries.
	    private static void quickSort(int[] array, int lo, int hi) {

	        if ( hi <= lo)
	            return;

	        int j = partition(array, lo, hi);   //partition
	        quickSort(array, lo, j-1);          //sort left part
	        quickSort(array, j + 1, hi);        //sort right part
	    }

    //Partitions on the item v in array. The main loop exits when the scan indices i and j cross. After that an
    // exchange of elements at indices low and j are made.
    //return is the index value where the array has been partitioned.
 
	    private static int partition(int[] array, int lo, int hi) {

	        int i = lo;         //left scan indices
	        int j = hi + 1;     //right scan indices
	        int v = array[lo];  // partition item

	        while (true) {      // Scan right and left, check for scan complete, and exchange

	            while (less(array[++i], v))
	                if (i == hi)
	                    break;

	             while (less(v,array[--j]))
	                 if (j == lo)
	                     break;

	                 if (i >= j)
	                     break;

	            swap(array, i , j);
	        }
	        swap(array, lo , j);       // Put v = a[j] into position

	        return j;        // with a[lo..j-1] <= a[j] <= a[j+1..hi]
	    }


	     //Compares two elements and returns true if the parameter a has a smaller value than the parameter b.
	     // a is the first given element.
	     //b is the second given element.
	     //return true if the element a is smaller than the element b. If not, it is false.
	    private static boolean less(int a, int b) {
	        return a < b;
	    }

	    // Exchanges two elements at the given indexes i and j of a given array of elements.
	    private static void swap(int[] array, int i, int j) {

	        int temp = array[i];
	        array[i] = array[j];
	        array[j] = temp;
	    }

	    //Test whether the elements of a given array is in an ascending order.
	    //return true if the array is sorted in ascending order, false if not.
	    private static boolean isSorted(int[] array) {

	        for (int i = 1; i < array.length; i++)
	            if (less(array[i], array[i -1]))
	                return false;

	        return true;
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
  }
	
	


