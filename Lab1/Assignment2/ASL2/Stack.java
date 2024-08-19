//  Task 2
// 	Sareh Jalalizad
//  Task Two Implement the above program in JAVA using one of the ADTs suggested in ch. 1.3
//  Input: A string of chars from stdin
//	Output: Same string of chars in reverse order to stdout
//  get all characters and push them into the stack until it reached to (\ n) and then
// prints them and pops them out.

public class Stack {
	

 
	
private char sr[];  // array in instance variable 
private int i = 0;	//number of item in the stack
	

//create an object stack 
//which is just an array of chars 
public Stack(int capacity) {  
	 
	sr = new char [capacity];

}
	
// add element to last index (highest)
public void push (char add) {	
	
	sr[i] = add;
	
	i++;
}
	
	
// remove element from last index (highest)
public char pop() {
	
	i--;
	return sr[i];
	
}


//check numbers of chars in array
public int size() {
	
	return i-1 ;
	
}


//check if stack is empty returns true; false otherwise
public boolean isEmpty() {
	
	if (i == 0) {
		return true;
		}
	else {
		return false;
	}
}


//test client which test all functions of stack

public static void main(String[] args) {
		
	Stack stack = new Stack(100); // Creates a new object Stack
		while(true) {
			
			char a = StdIn.readChar();
			
			if(a != '\n') { // if new line is detected, stop otherwise push
				
				stack.push(a);
	    	}
	    	else {        //when newline detected, break(stop)
	    		
	    		break;
	    	}
		}
	    
	    if(stack.isEmpty() == false) {     //test of isEmpty
	    	
	    	StdOut.print("stack is not empty \n" + "Size of stack is " + stack.size() + "\n");
	    	
	    	for(int i = stack.size(); i >= 0; i--) {       //print out input in reverse means that from highest to lowest index(LIFO)
	    	
	    	
	    	StdOut.print(stack.pop());
	    }
	    }
	}
	
	
	
	
	
	
	
	
	

}

