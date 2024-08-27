//Sareh Jalalizad

//The code is an indexed minimal priority queue in form of a binary heap. That means that the key with smallest
//value is stored at index 1 with all the child nodes of the smallest key has a larger value. The binary heap
// implementation means that the children of a given index i are stored at index  i*2 and i*2 +1.

import java.util.Iterator;
import java.util.NoSuchElementException;


 //Represents a indexed minimum priority queue. Each key in the queue is associated with a given index
 //which gives the client fast access to the smallest entry in the queue.
public class IndexMinPQ<Key extends Comparable<Key>> implements Iterable<Integer>{

    private int maxN;           // max num of elements on PQ
    private int N;              // number of elements on PQ
    private int[] binaryHeap;   // binary heap using 1 based indexing
    private int[] inverseHeap;  // inverse of binary heap
    private Key[] keys;         // keys[i] = priority of i

    
    //Creates an instance with a given maximum queue size.
    //Initializes an empty indexed priority queue with indices between 0
    //and maxN - 1
     @SuppressWarnings("unchecked")
	IndexMinPQ(int maxN) {

         this.maxN = maxN;
         this.N = 0;
         this.keys = (Key[]) new Comparable[this.maxN + 1];  // make this of length maxN??
         this.binaryHeap = new int[this.maxN + 1];
         this.inverseHeap = new int[this.maxN + 1];          // make this of length maxN??

         for (int i = 0; i <= this.maxN; i++)
             this.inverseHeap[i] = -1;
    }

   
     //Returns the size of the queue.
    int getMaxSize() {
        return this.maxN;
    }

    
    // Returns the number of keys in the priority queue.
     int getSize() {
        return this.N;
    }

   
   //check queue is empty or not 
   //return is true if the queue is empty, False if not.
    boolean isEmpty() {
        return this.N == 0;
    }

    
    //check queue contain empty key or not
    //return is true if the queue contains the key of the given index.
    public boolean contains(int index) {

        return this.inverseHeap[index] != -1; }

    
    //Inserts a key and associates it with the given index and makes the newly added key
    //iterate up through the heap to find its correct place.
    void insert(int index, Key key) {

        this.N++;
        this.inverseHeap[index] = this.N ;
        this.binaryHeap[this.N] = index;
        this.keys[index] = key;

        swim(this.N);
    }


    
    //Returns the instance variable "adjacencies" index of a given key.
    int getIndex(Key key) throws IllegalArgumentException{

        int index = 1;

        while(null != keys[index] && index <= this.N) {

            if (0 == this.keys[index].compareTo(key))
                return index; //return is the index of the given key.

            index++;
        }

        throw new IllegalArgumentException("Vertex " + key + " not found");
    }

    
   
    //Returns the index of the key with smallest value.
     int minIndex() {
        return this.inverseHeap[1];
    }

    
     //Returns the key with smallest associated value.
     Key getMinKey() {
        return this.keys[this.binaryHeap[1]];
    }

    
     //Exchanges the keys of two given indices.
    private void exchange(int index1, int index2) {

        int temp = this.binaryHeap[index1];

        this.binaryHeap[index1] = this.binaryHeap[index2];
        this.binaryHeap[index2] = temp;

        this.inverseHeap[binaryHeap[index1]] = index1;
        this.inverseHeap[binaryHeap[index2]] = index2;
    }

    // Decrease the key associated with index to the specified value.
     void decreaseKey(int index, Key key) {

        this.keys[index] = key;
        swim(this.inverseHeap[index]);
    }

     
     
    //Removes the key with the smallest value and returns its index.
     int deleteMin() {

         int minKey = this.binaryHeap[1];

         exchange(1,  this.N--);
         sink(1);

         this.inverseHeap[minKey] = -1;     //delete
         this.keys[minKey] = null;          //to help with garbage collection
         this.binaryHeap[this.N + 1] = -1;  // not needed

         return minKey;  //return is the index of the removed key.
    }

    //helper function
    //Sets a key to its correct place in the heap by letting it "swim" up the heap.
    private void swim(int index) {

        while(index > 1  && greater(index / 2, index)) {
            exchange(index, index / 2);
            index = index / 2;
        }
    }

    
    //Sets a key to its correct place in the heap by letting it "sink" to its proper place in
    //the heap.
    private void sink(int index) {

        while (index*2 <= this.N) {

            int childIndex = index*2;

            if (childIndex < this.N && greater(childIndex, childIndex + 1))
                childIndex++;

            if (smaller(childIndex, index))
                exchange(index, childIndex);

            index = childIndex;
        }
    }

    
    //check if a given keys value is smaller than another given keys value..
    //return is true if the first given key is smaller. False if not.
    private boolean smaller(int index1, int index2) {
        return this.keys[this.binaryHeap[index1]].compareTo(this.keys[this.binaryHeap[index2]]) < 0;
    }

    
    
    //check if a key has greater value or not than a key at another given index.
    //return is true if the first key i larger. False if not.
    private boolean greater(int keyIndex1, int keyIndex2) {
        return this.keys[this.binaryHeap[keyIndex1]].compareTo(this.keys[this.binaryHeap[keyIndex2]]) > 0;
    }


    //Returns the content of the queue in form of a string.
    public String toString() {

        String string = "";

        for (int i = 1; i <= this.N; i++)
             string = string + this.keys[this.binaryHeap[i]] + " ";

        return string;
    }

 
    
    //Returns an iterator that iterates over the keys on the
    //priority queue in ascending order.
    public Iterator<Integer> iterator() {
        return new HeapIterator();
    }

    
    //Makes the priority queue iterable.
    private class HeapIterator implements Iterator<Integer> {

    	// create a new binaryheap
        private IndexMinPQ<Key> copy;

     // add all elements to copy of heap
        // takes linear time since already in heap order so no keys move
         HeapIterator() {

            this.copy = new IndexMinPQ<>(getMaxSize());

            for (int i = 1; i <= getSize(); i++)
                this.copy.insert(binaryHeap[i], keys[binaryHeap[i]]);

        }

      
         //check if the heap has another element.
         //return true if the queue is not empty. False otherwise.
        public boolean hasNext()  {
             return !copy.isEmpty();
         }

       
        //Returns the current smallest key of the priority queue.
        public Integer next() throws java.util.NoSuchElementException {

            if (!hasNext())
                throw new NoSuchElementException();

            return this.copy.deleteMin(); //return is the current smallest key.
        }
    }

}
