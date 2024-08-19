### Lab 2

1) Implement insertionsort. Augment the sorting process so that all the content of the array that is being sorted is printed after each inner loop iteration. 
A unit test in main() allows the user to define the size of the input (N) and then input (N) integers from stdin which is to be sorted.

2) Augment the above implementation so that it prints the number of swaps performed when sorting the array.

3) Add a method which counts the number of inversions in the input array and prints a list of all inversions on the format [i,a[i]], [j, a[j]] where i and j are indices and a[i], a[j] are the values of the elements. Call the method from main() before the array is sorted.

4) Implement a function in C which takes an array of integers (both positive and negative) and orders the elements in the array so that all negative elements come before the positive (not sort the array - only collect all negative values first). The algorithm only use O(1) extra memory.

5) Compare the execution times for sorting large arrays of integers with insertionsort and merge sort. (Five + Graphs)

6) Experiment with the cut-off to insertionsort in merge. (A suitable range for cut-off values to test with could be [0-30].)

#### Higher Grade 
1) Augment the code from assignment 1 so that the array is sorted in descending order.

2) Compare the execution times for sorting large arrays of integers with quicksort and merge sort. 

3) Compare the execution times of quicksort where the first element in each sub-array is selected as partitioning element to that of quicksort with median-of-three partitioning.
