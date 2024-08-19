//Sareh Jalalizad

//Using the cut-off to insertion sort in merge sort.
//The range that use for cut-off values to test with could be [0-30].


import java.util.Random;

public class Six {
	
    private static final int CUTOFF = 2;  // cutoff to insertion sort
	
   
    ///Merges two parts of an arrays by first copying into the auxiliary array, sorting the elements and then merging back
    //the sorted elements to the original array.
    private static void merge(int[] array,int [] auxiliary, int lo, int middle, int hi) {

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
    
    
    // Sorts an array of integers using the algorithm mergeSort.
    // lo is the lower boundary of the elements being sorted.
    // hi is the higher boundary of the elements being sorted.
    //middle is the cut off between the low and high boundaries.
   private static void Sort(int[] array,int[] auxiliary, int lo, int hi) {

           if (hi <= lo) 
               return;
           
         
        	   if(hi <= lo + CUTOFF) {
        		   array = Insertionsort(array,lo ,hi);
        		   return;
        	   }
        	   
           
           int middle = lo + (hi - lo)/2;

           Sort(array,auxiliary, lo, middle);
           Sort(array,auxiliary, middle + 1, hi);
           merge(array, auxiliary, lo, middle, hi);
   }
              
   
    
     // Initializes an auxiliary array as well as calls the method mergeSort to initiate the Merge Sort algorithm.
    public static void Sort(int[] array) {

     int[]  auxiliary = new int[array.length];
        Sort(auxiliary,array, 0,array.length - 1);
    }
	
   
  
   
   
   // Sorts an array of integer using the algorithm Insertion Sort.
   // sort from a[lo] to a[hi] using insertion sort
   //lo is the lowest index of the array.
   //hi is the highest index of the array.
 public static int[] Insertionsort(int[] a, int lo, int hi) {
	       
	 for (int i = lo; i <= hi; i++) {
	
		 for (int j = i; j > lo && less(a[j], a[j-1]); j--) {    //second loop compares current index with the value in the array index directly smaller

      		  int s;                   //and swaps the positions if the value in the current index is smaller.
              s = a[j];
              a[j] = a[j - 1];
              a[j - 1] = s;
         
 }
 }
	return a;
 }


 // Compares two elements and returns true if the parameter a has a smaller value
 // than the parameter b.
 // a is the first given element.
 // b is the second given element.
 // true if the element a is smaller than the element b. If not, it is false.
private static boolean less(int a, int b) {
    return a < b;
}

public static int[] randomArray(int size){
    Random rand = new Random();
    int[] a = new int[size];

    for(int i = 0; i < size; i++){
        a[i] = rand.nextInt(100);
    }

    return a;
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

public static void main(String[] args) {
 
	int[] mergeArray = randomArray(10000);
	System.out.println("Merge Sorting Process Begins");

     Stopwatch mergeStartTime = new Stopwatch();
     Six.Sort(mergeArray);
     double mergeTimePassed = mergeStartTime.elapsedTime();
     System.out.println("Execution time for Merge Sorting: " + mergeTimePassed/1000000 + " milliseconds");

}
}