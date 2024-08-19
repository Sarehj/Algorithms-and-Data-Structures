//Higher grade assignment
//Sareh Jalalizad
//Implement a program which takes as input a series of parentheses ,
//that is a series of the characters: '(', ')', '[', ']', '{', '}'. 
//The program check if the parentheses are "balanced" or not. 
//This program only counts and saves all the parenthesis in an array and then checks if they are the same. 


import java.io.InputStreamReader;


public class Assignment {
   
	public static void main(String[] args) throws Exception{
	
	     InputStreamReader in = new InputStreamReader(System.in);
	     char c;
	     int[] a = new int[6];       //'(',')','[',']','{','}'
	
	  for(int i = 0; i < 6; i ++)      
	    a[i] = 0;
	
		
	while((c = (char) in.read()) != '\n')
	    {
		switch (c){
		case '(':
		    a[0]++;
		    break;
		case ')':
		    a[1]++;
		    break;
		case '{':
		    a[2]++;
		    break;
		case '}':
		    a[3]++;
		    break;
		case '[':
		    a[4]++;
		    break;
		case ']':
		    a[5]++;
		    break;
		default:
		    break;
		    }
		  }
	if(a[0] == a[1])
	    System.out.println(" '(' , ')' are balanced");
	else
	    System.out.println(" '('  , ')' are not balanced");
		
	if(a[2] == a[3])
	    System.out.println(" '{' , '}' are balanced");
	else
	    System.out.println(" '{' , '}' are not balanced");
		
	if(a[4] == a[5])
	    System.out.println(" '[' , ']' are balanced");
	else
	    System.out.println(" '[' , ']' are not balanced");

    }
}


