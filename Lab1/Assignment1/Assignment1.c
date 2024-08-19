//Sareh Jalalizad
/* Task One In C implement a recursive and an iterative version of a function
 * which reads characters from stdin until a newline character is read and
 * then prints them on stdout in reverse order. Hint: use getchar(), putchar() (or getc(), putc()).
 * For the iterative version you may assume a fixed max length of the input.
 */

 //The program is implement using a char array and while loop.

 #include <stdio.h>

int i = 0;

 int main() {

	int count;
  char ar[10] ;     //Takes in character inputs of max length 50
  char c;


     //adds chars to the array using getchar (from stdin)



        while ((c = getchar()) != '\n' && i < 10){

               ar[i] = c;
               i++;
        }

                  //new for loop execute.

    while ( i >= 0 ) {    //printout characters from highest index to lowest(reverse inputs)

       i--;
      putchar(ar[i]);
    }
  }
