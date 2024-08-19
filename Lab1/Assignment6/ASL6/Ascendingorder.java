//Task 6
// Sareh Jalalizad
//Implements a generic iterable FIFO queue using a linked list. 
//This is FIFO queue, so adds elements at the back of the queue and removes elements from the front.
//Also is able to insert elements in ascending order

public class Ascendingorder {
		
 
    private Node first;     //beginning of queue
    private Node last;      //end of queue
    int N;                  //number of elements on queue
    
    public class Node
        {
            int item;
            Node next;
            Node prev;
        }
    
	  //check is queue empty?return true if this queue is empty;
	  //false otherwise
	  public boolean isEmpty() {
		  return first == null;
	  }
	  
	  //Returns the number of items in this queue.
	  public int size() {
		  return N;
	  }
    
    
   //insert elements in ascending order
        
	  public void insertAsc(int item){                
          
      	Node n = first;                 
          Node newNode = new Node();    //creates new node 
          newNode.item = item;            //sets value

          if(first == null){             //if list is empty, no need to sort by ascending,    
              first = newNode;           //just insert the node(last and first is same so item added in both last and first)
              last = newNode;
              
              print();
          }
          else if(first.item >= newNode.item){        //if first node of the list is greater or equal to the new node,
             
          	newNode.next = first;                   //make the new node the first node( insert the node before first node)
              first.prev = newNode;
              first = newNode;
             
              print();
          }
          else if(newNode.item >= last.item){       //if last node is less or equal to new node, 
              
          	newNode.prev = last;                  //make new node to be the last node ( set the node after last node)
              last.next = newNode;
              last = newNode;
              last.next = null;
            
              print();
          }
          else{
              while(newNode.item > n.item && n.next != null){     //iterate through the list until find a node that is greater than new node    
                  n = n.next;                                     
              }
              newNode.next = n;                     //so that the new node is inserted before the greater node
              newNode.prev = n.prev;
              n.prev.next = newNode;
              n.prev = newNode;
             
              print();
          }
      }



        public void print(){
          
        	if(first.next == null){
                System.out.println("[" + first.item + "]");
            }
            else{
                Node i = first;
                while(i.next != null){       //until last node
                    System.out.print("[" + i.item + "]" + ",");
                    i = i.next;
                }
                System.out.println("[" + i.item + "]");
            }
        }


        //test
        public static void main(String[] args) {

            Ascendingorder a = new Ascendingorder();

            a.insertAsc(1);
            a.insertAsc(2);
            a.insertAsc(3);
            a.insertAsc(1);
            a.insertAsc(2);
            a.insertAsc(3);
            a.insertAsc(9);
            a.insertAsc(9);
            a.insertAsc(11);
            
        }
    }