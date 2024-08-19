 //Sareh Jalalizad
 // The first char is saved in rev (if c != '\n') and then recursive is called again
 // and the next char is also saved in c, however c is an instance variable
 // and as such it is not saved into the same memory space
 //and when c == '\n' the last instance of recursive executes putchar(c)
 // and then the nth - 2 executes and so all instances of recursive have been executed
 // and as such all chars have been printed - in the reverse order.


#include <stdio.h>

void recursive(){
  char c = getchar();   //stores characters into c (from stdin)
  if(c == '\n') return;
  else recursive();
  putchar(c);            //recursive starts executes all instance and print characters from the last one.(reverse input)

}


void main(){
  recursive();
  putchar('\n');

}
