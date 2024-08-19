//Sareh Jalalizad

//Implement insertion sort.
//Write a unit test in main() which allows the user to define the size of the input (N) 
//and then input (N) integers which is to be sorted.


import java.util.Scanner;

public class One {

	public static void Insertionsort(int[] a){        //insertion sort

        for (int i = 1; i < a.length; i++){           //starts from the 2nd index of the array
           
        	for(int j = i; j > 0 && a[j] < a[j - 1]; j--){      //second loop compares current index with the value in the array index directly smaller 
            
        		int s;               //and swaps the positions if the value in the current index is smaller.
                s = a[j];
                a[j] = a[j - 1];
                a[j - 1] = s;
            }
          StdOut.print(toString (a) + "\n") ;    // prints string representation of array
        }
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
		
			Insertionsort(a);
		
			StdOut.print("\n" + "Array is sorted:" + isSorted(a) ); 
		}
	}
		
	}
				
