//Sareh Jlalizad

//Finds the occurrences of a given string in a text.
import java.io.*;
import java.util.*;
 
public class Four {
	
	
    // Iterates through a string and find the occurrences of a given word.
    // text is the text that searched
    // word is the word that looked for
	public static List<Integer> wordFinder(String text, String word) {

      List<Integer> indexes = new ArrayList<Integer>();    // we create a new list to put the positions of the word
   
      //we put space around it so it doesn't find that word if its inside other words
      String wordF = " " + word + " ";

      int index = 0;

      while (index != -1) {   //i only gets -1 when it doesn't find the word anymore so the list is done
      	
      //Returns the index within this string of the first occurrence of the specified substring
          index = text.indexOf(wordF, index);

      //this is a function in java that looks for the word in the text after index 
      //and after finding it it returns the position that the word is in 
      //and then it  gives index that position 
      //so that it starts looking for the word again after that index (when we do index++)
          if (index != -1) {
              indexes.add(index);
              index++;      //start searching again after the pos where we last found the word
          }
      }

      return indexes;   //return the index values of the occurrences of the given word.
  }


	
	@SuppressWarnings("resource")
   //test
    public static void main(String[] args) throws IOException {

        File file = new File("C:\\Users\\sareh\\Desktop\\Lab3\\Input.txt");
        Scanner sc = new Scanner(file);//the text

        String text="";//our text file
        String line;
        while (sc.hasNext()) {
            line = sc.nextLine();//every new word from text
            //and then adding them one by one
                text=text + line + " "; //putting every word in the file in our text
        }
    	
    	

//        String words = "November";
//        List<Integer> list = wordFinder(text, words);
//
//        if (list.isEmpty()) System.out.println("No occurrences of the word " + words);// for when the word doesn't exists in the text
//        else {
//            int col = 0;    //for print out the positions in 6 columns (can change)
//
//            System.out.println("The word " + words + " is found " + list.size() + " times at the positins : ");
//
//            for (Integer index : list) {//going through the list of all the positions
//
//                System.out.print(index + " "); //printing them out with a space after each position
//
//                col++;
//
//                if (6 == col) { //after writing 6 of them it goes to the next row
//                    System.out.println();
//
//                    col = 0;
//    }
//            }
//        }
       
        
        String word;//the word we are looking for
        System.out.println("Enter the word you are looking for: ");
          Scanner in = new Scanner(System.in); // to input the word we are looking for
        word = in.next();
        List<Integer> list = wordFinder(text, word);

        if (list.isEmpty()) System.out.println("No occurrences of the word " + word);// for when the word doesn't exists in the text
        else {
            int col = 0;    //for print out the positions in 10 columns (can change)

            System.out.println("The word " + word + " is found " + list.size() + " times at the positins : ");

            for (Integer index : list) {//going through the list of all the positions

                System.out.print(index + " "); //printing them out with a space after each position

                col++;

                if (10 == col) { //after writing 10 of them it goes to the next row
                    System.out.println();

                    col = 0;
    }
            }
            
            System.out.println("\n");
        }
    }

}
     
   