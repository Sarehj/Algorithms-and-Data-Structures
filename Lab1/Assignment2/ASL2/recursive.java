

public class recursive {
	
	public static void Recursive() {
		
	
	Stack stack = new Stack(100); // Creates a new object Stack
     
	char c = StdIn.readChar();
	
     if (c != '\n') {
		
		Recursive();
	
	StdOut.print(c);	
	}
}

	public static void main(String[] args) {
		
		Recursive();
		
	}}