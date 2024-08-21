//Sareh Jalalizad
//Write a simple filter to clean a text, i.e. to remove all characters that are not alphabetic, blank or newline
//replacing every such character by a blank to keep the number of characters constant to the original text.

#include <stdio.h>
#include <ctype.h>

int main() {
	char a;
	FILE *inputfile;
	char* file = "C:\\Users\\sareh\\Desktop\\Lab3\\Input.txt";

	inputfile = fopen(file, "r");

	while((a = fgetc(inputfile)) != EOF) { // while input is not empty
		if (isalpha(a)) { // if char is  an alphabetic character,
			putchar(a); // keep the character.
		}
		else {

			putchar(' ');  //if a isn't an alphabet, replace with blank space
		}
	}
	fclose(inputfile);  
}
