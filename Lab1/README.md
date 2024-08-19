# First lab

The data stored in each element of a list/stack/queue is a character or integer.

All JAVA implementations implement a method returning string representation of the list/queue where each element is placed between brackets "[x]" and adjacent elements are separated by a comma "," 

1) In C implement a recursive and an iterative version of a function which reads characters from stdin until a newline character is read and then prints them on stdout in reverse order. 
* For the iterative version assumed a fixed max length of the input.

2) Implement the above program in JAVA

3) Implement a generic iterable FIFO-queue based on a double linked circular list. The program prints the content of the list after each insertion/deletion of an element.

4) Implement a generic iterable circular linked list which allows the user to insert and remove elements to/from the front and back end of the queue.

5) Implement a generalized queue which allows the user to remove the kth element from the queue. Assumed the most recently added element has index 1.

6) Implement an ordered queue based on one of the implementations above. The elements stored in the queue should be integer values. The elements should be ordered at insertion so that all elements are stored in ascending order starting from when you insert the first element and in all following insertions. 