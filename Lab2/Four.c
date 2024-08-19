

//Implements a function to sort all negative numbers to the left, positive numbers to the right and 0s in between
//sort(int *array, int size) switches all negative ints to lower index and all positive to higher index
// printArray(int[] array, int size) prints array of length size
#include <stdio.h>

//The code twice traverses the array : for any negative numbers it swaps them into the beggining,
// saves the index and then it traverses it starting from that index to place the 0's.

void swap(int *arr, int i, int j){
  int temp = arr[i];
  arr[i] = arr[j];
  arr[j] = temp;
  }

void sort(int *arr, int size){
  int i,j=0;

  //On the left of j, there is always gonna be negative numbers
  for(i = 0; i < size; i++)
    if(arr[i] < 0){
      swap(arr,i,j);
      j++;
    }

  //everything on the left of j is either negative or 0
  for(i = j; i < size; i++)
    if(arr[i] == 0){
      swap(arr,i,j);
      j++;
	}
}


int printArray(int arr[], int size) { // simple function which prints the array, used for debugging and displaying
  for(int i = 0; i < size; i++){  // that the sortNegative function actually works.
     printf("%d ", arr[i]);
  }
}

int main() {
  int size;
  int i;
  printf("Size Of Array: ");
  scanf("%d", &size);
  int arr[size];
  for(int i = 0; i < size; i++){
  scanf("%d", &arr[i]);
   }
  sort(arr, size);
   printArray(arr, size);
}
