//Sareh Jalalizad

//Reads a file database to set up a graph of nodes depending on the input.
//Then prints each node and the edges for all nodes, using Breadth First Search.

//Then prints the path between two given nodes

import java.util.Scanner;


public class SymbolGraphBFS {
	
		
		private ST<String, Integer> st;   // convert strings index(int)
		private String[] keys;            // index(int)-> string (convert back to Strings)
		private Graph graph;              //the underlying graph
		
		
	   //Initializes a graph from file, using a specified delimiter. 
	   //Each line in the file contains the name of the vertex
	   //followed by a list of the names of the vertices adjacent to that vertex, separated by the delimiter.
	   //delimiter the delimiter between fields.
		public SymbolGraphBFS(String file, String delimiter) {
			
	        // First pass builds the index by reading strings to associate
	        // distinct strings with an index
			st = new ST<String,Integer>();
			In in = new In(file);
			
			while(!in.isEmpty()) {
			
				String[] a = in.readLine().split(delimiter);
				
				for(int i = 0; i < a.length; i++) {
				
					if (!st.contains(a[i]))
					
						st.put(a[i], st.size());
				}
			}
			
		  //inverted index to get string keys in an array
			keys = new String[st.size()];
			for (String name : st.keys()) {
				keys[st.get(name)] = name;
			}
			
	       // second pass builds the graph by connecting first vertex on each
	       // line to all others
			graph = new Graph (st.size());
			in = new In(file);
			
			while(in.hasNextLine()) {
			
				String[] splitLineArray = in.readLine().split(delimiter);
				int v = st.get(splitLineArray[0]);
				
				for (int i = 1; i < splitLineArray.length; i++) {
				
					int w = st.get(splitLineArray[i]);
					graph.addEdge(v, w);
				}
			}
		}
		
	   //Does the graph contain the vertex name given in the source?
	   //return true if it is in the graph, otherwise false.
		public boolean contains(String source) {
			
			return st.contains(source);
		}
		
	   //Returns the integer (value part of ST) of the given vertex name in parameter source.
	   //return the integer (between 0 and V - 1) associated with the vertex given.
		public int index(String source) {
			return st.get(source);
		}
		
	   //Returns the name of the given vertex number given in the parameter. 
		public String name(int vertex) {
			return keys[vertex];
		}
		
		
		
	   //Returns the graph associated with the symbol graph.
		public Graph graph() {
			return graph;
		}
		
		
		//test
	    @SuppressWarnings("resource")
		public static void main(String[] args) {
	    	
	    	String file =("C:\\Users\\sareh\\Desktop\\Lab4\\data.txt");
	    	String delimiter = " ";
	    	SymbolGraphBFS b = new SymbolGraphBFS(file, delimiter);
	    	
	    	System.out.println(b.graph.toString(b)); //prints each node and the edges for all nodes
	    	
	   
	    //ask user 	
	    System.out.println("Find the path from : ");
	     Scanner in = new Scanner(System.in); 
	     String fr = in.next();
	     
	     int from = b.index(fr);
	    	
	    
	     System.out.println("To : ");
	     String t = in.next();
	     
	     int to = b.index(t);
	     
	     //prints the path between two given nodes (from CA to NY")
	     //int from = sg.index("CA");
	     //int to = sg.index("NY");
	    	
	     
	   
	     BFS bfs = new BFS(b.graph(), from);
	    	
	    	System.out.println("\n" + "From " + fr + " to " + t + " : ");
	    	
	    	
	     //check there is path or not
	    	if(bfs.hasPathTo(to)) {
	    		for(Integer i : bfs.pathTo(to))
	    			System.out.println(b.name(i)); //if there is a path prints the name
	    	}	
	    		else
	    				System.out.println("There is no path from the source to the given node");
	    	

	    }

	}



