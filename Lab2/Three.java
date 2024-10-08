//Sareh Jalalizad

//Implemets insertion sort.
//Counts the number of inversions and displays the pairs to be inverted.

// time complexity of the insertion sort is O(n + f(n)) where f(n) is inversion count.
//If the inversion count is O(n), then the time complexity of insertion sort is O(n).
//In the worst case, there can be n*(n-1)/2 inversions. The worst case occurs when the array is sorted in reverse order.
//So the worst case time complexity of insertion sort is O(n2).



import java.util.Scanner;

public class Three {

	public static void Insertionsort(int[] a){   //insertion sort

		int scount = 0;       //counter for number of swaps
		
        for (int i = 1; i < a.length; i++){                  //starts from the 2nd index of the array
           for(int j = i; j > 0 && a[j] < a[j - 1]; j--){   //second loop compares current index with the value in the array index directly smaller 
            
        		int s;                   //and swaps the positions if the value in the current index is smaller.
                s = a[j];
                a[j] = a[j - 1];
                a[j - 1] = s;
                
                scount++;  // if swap done increment swap counter
            }
          
        	StdOut.print(toString (a) + "\n") ;
        }     
        	
        	StdOut.print("Number of swaps was: " + scount + "\n");
        }

	
	
	
	// simple double for loop which checks whether there are any inversions
	public static String inversion(int[] c) {
		
		int incount = 0;       //counter for number of inversions
		
		String s ="";         //there are any inversion
		
		for (int i = 0; i < c.length; i++) {   // if lower index a[i] is larger than higher index a[j] (that is an inversion)
			for(int j = i + 1; j < c.length; j++) {
				
				if (c[i] > c[j]) {     //compare every elements after the index and print the pairs when j is smaller than i and add them to String s
					
					s = s + "[" + "[" + i + "," + c[i] + "]" + "," + "[" + j + "," + c[j] + "]" + "]" + "\n";
	
					incount++ ;     // increment inversion counter
				}
	        }            	
	}
		
		StdOut.print((s) + "\n"); 
		StdOut.print("Number of inversion was: " + incount + "\n");
		StdOut.print("\n");
		
		return s;
}

	
	
	
	public static String toString(int [] b) {   //return  string representation of array(int [])

		String r = "[";
		
		//adds all int to string and separates them with comma 
		
		for (int i = 0; i < b.length; i++ ) {  
           
			r = r + b[i] + "]";
			
			if(i < b.length -1) {  //until reach to the last one add comma and when if it's last one don't add comma

				r = r + ",[";
			}
		}
	    	return r;
	}
	
	
	//return true if the element a is smaller than the element b. If not, it is false.
	private static boolean less(int a, int b) {
	        return a < b;
	    }
	
 //Test whether the elements of a given array is in an ascending order.
 //return true if the array is sorted in ascending order, false if not.
	  private static boolean isSorted(int[] a) {
	        for (int i =  1; i < a.length; i++)
	            if (less(a[i], a[i-1])) return false;
	        return true;
	    }
	
//test
	
	
	public static void main (String[] args) {
		
		Scanner input = new Scanner(System.in);  //use scanner for input of int for array
		StdOut.print("Please enter size of array: ");
		
		int size = StdIn.readInt();   //size of array
		
		//check that user write correct size( size is not negative number)
		if(size <= 0) {
			StdOut.print("\n" + "Invalid size.");
			throw new NegativeArraySizeException();
		}
		else {
			
			StdOut.print("\n" + "Please enter integers by spaces: ");  // create an array from user input 
			
			int[] a = new int[size];
			for(int i = 0; i < size; i++) {
			a[i] = input.nextInt(); // using scanner inside a for loop
		
			}
		
			inversion(a);
			Insertionsort(a);
			
			StdOut.print("\n" + "Array is sorted :" + isSorted(a));
		}
	}
		

}

