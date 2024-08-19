//Sareh Jalalizad

// Creates randomly generated arrays and sorts them with either of the algorithms quick sort 
//with median-of-three partitioning or Quick Sort.
// Creates arrays with randomly generated integers as elements. Calls for either quick Sort or
// quick sort with median-of-three methods to sort them in ascending order.

//Quick sort, sorts faster than quick sort with median-of-three partitioning. 


import java.util.Random;

public class higherG3 {
	
	 public static void main(String[] args) {

	       
		 int[] quickmedArray = new int [1000000];
	     int[] quickArray = new int [1000000];
	     randomArray(quickmedArray,quickArray);

	        System.out.println("Quickmedian Sorting Process Begins");

	        Stopwatch quickmedStartTime = new Stopwatch();
	        quickmedianSort(quickmedArray,0,quickmedArray.length -1);
	        double quickmedTimePassed = quickmedStartTime.elapsedTime();

	        System.out.println("Quickmedian Sorting Process Ends");
	        System.out.println("Quickmedian array is sorted: " + isSorted(quickmedArray));
	        System.out.println("Execution time for Quickmedian Sorting " + quickmedArray.length + " elements: " + quickmedTimePassed/1000000 + " milliseconds");

	        quickmedArray = null;
	        
	      
	       
            System.out.println("Merge Sorting Process Begins");
	        
	        Stopwatch quickStartTime = new Stopwatch();
	        quickSort(quickArray,0,quickArray.length -1);
	        double quickTimeElapsed = quickStartTime.elapsedTime();
	       
	        System.out.println("Quick Sorting Process Ends");
	        System.out.println("Quick array is sorted: " + isSorted(quickArray));
	        System.out.println("Execution time for Quick Sorting " + quickArray.length + " elements: " + quickTimeElapsed/1000000 + " milliseconds");

	        quickArray = null;
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
    
	    
	    
	 //Sorts an array of integer using the algorithm Quick Sort. 
     // lo is the lower boundary of the elements being sorted.
     // hi is the higher boundary of the elements being sorted.
     //middle is the cut off between the low and high boundaries.
    private static void quickmedianSort(int[] array, int lo, int hi) {

        if ( hi <= lo)
            return;

        int m = median3(array, lo, (lo + hi)/2, hi);
        swap(array, m, lo);
        
        int j = partition(array, lo, hi);       //partition
        quickmedianSort(array, lo, j-1);        //sort left part (a[lo .. j-1])
        quickmedianSort(array, j + 1, hi);      //sort right part (a[j+1 .. hi])
    }

    
   //Partitions on the item v in array. The main loop exits when the scan indices i and j cross. After that an
   // exchange of elements at indices low and j are made.
   //return is the index value where the array has been partitioned.

    private static int partition(int[] array, int lo, int hi) {

        int i = lo;          //scan indices (left)
        int j = hi + 1;      //scan indices (right)
        int v = array[lo];   //partition item

        while (true) {       // Scan right and left, check for scan complete, and exchange

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
        swap(array, lo , j);    // Put v = a[j] into position

        return j;    // with a[lo..j-1] <= a[j] <= a[j+1..hi]
    }

    
    
    // return the index of the median element among a[i], a[j], and a[k]
    private static int median3(int[] array, int i, int j, int k) {
        return (less(array[i], array[j]) ?
               (less(array[j], array[k]) ? j : less(array[i], array[k]) ? k : i) :
               (less(array[k], array[j]) ? j : less(array[k], array[i]) ? k : i));
    }

    
    
    //Sorts an array of integer using the algorithm Quick Sort. 
    // lo is the lower boundary of the elements being sorted.
    // hi is the higher boundary of the elements being sorted.
    //middle is the cut off between the low and high boundaries.
   private static void quickSort(int[] array, int lo, int hi) {

       if ( hi <= lo)
           return;

       int j = partition(array, lo, hi);
       quickSort(array, lo, j-1);   //left part
       quickSort(array, j + 1, hi);  //right part
   }



     //Compares two elements and returns true if the parameter a has a smaller value
     //than the parameter b.
     // a is the first given element.
     //b is the second given element.
     //return true if the element a is smaller than the element b. If not, it is false.
    private static boolean less(double a, double a2) {
        return a < a2;
    }

    // Exchanges two elements at the given indexes i and j of a given array of elements.
    private static void swap(int[] array, int i, int j) {

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
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
    
    //Test whether the elements of a given array is in an ascending order.
    //return id true if the array is sorted in ascending order, false if not.
    private static boolean isSorted(int[] array) {

        for (int i = 1; i < array.length; i++)
            if (less(array[i], array[i -1]))
                return false;

        return true;
    }

}
