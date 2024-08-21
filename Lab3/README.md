### Lab3 - Searching

1) A simple filter to clean a text, i.e. to remove all characters that are not alphabetic, blank or newline - replacing every such character by a blank to keep the number of characters constant to the original text.

2) Use the first N words from the text to compare the running times of the ordered array ST (also known as binary search symbol table) to the Binary Search Tree algorithm.

3) A program that shows how evenly the built-in hashcode() function for strings in Java distributes the hashcodes for the words found in the text.

4) An "index"-program which allows the user to ask questions "on which positions in the text (i.e. the number of characters from the beginning) you find the word X". The program list the position of all occurrences of X as answer to a query. Questions to the index answered in time less or equal to O(log(N)) where N is the number of keys.

5) Show how a binary search tree  is built when the following sequence of keys are inserted: W O E C A L H and the output if the content of the trees is printed in pre-, in- and postfix order

6) show how you measured the execution times in task 2 and how the results compare to what the theoretical calculations would suggest

#### Higher Grade

Implement a program which takes as input a text file and allows the user to (repeatedly without re-reading the input file) ask questions: 
1) Which is the k:th most common word
2) Which are the k:th to the k+n:th most common words

input: [leipzigm](https://introcs.cs.princeton.edu/java/data/leipzig/leipzig1m.txt)