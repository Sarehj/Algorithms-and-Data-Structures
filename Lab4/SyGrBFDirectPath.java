//Sareh Jalalizad

//Reads a file database to set up a graph of nodes depending on the input.
//Then prints each node and the edges for all nodes, using Breadth First Search.

//Then prints there is path between two given nodes or not.

import java.io.File;
import java.net.MalformedURLException;
import java.util.Scanner;

public class SyGrBFDirectPath {

	
	private ST<String, Integer> st;   // convert strings index(int)
	private String[] keys;            // index(int)-> string (convert back to Strings)
	private DiGraph graph;              //the underlying graph
	
	
   //Initializes a graph from file, using a specified delimiter. 
   //Each line in the file contains the name of the vertex
   //followed by a list of the names of the vertices adjacent to that vertex, separated by the delimiter.
   //file the file to get the vertices
   //delimiter the delimiter between fields.
	public SyGrBFDirectPath(File file, String delimiter) {
		
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
		graph = new DiGraph (st.size());
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
	public DiGraph graph() {
		return graph;
	}
	
	
	//test
    @SuppressWarnings("resource")
	public static void main(String[] args) throws MalformedURLException {
    	
    	File file = new File("C:\\Users\\sareh\\Desktop\\Lab4\\data.txt");
    	String delimiter = " ";
    	SyGrBFDirectPath b = new SyGrBFDirectPath(file, delimiter);
    	
    	System.out.println(b.graph.toString(b)); //prints each node and the edges for all nodes
    	
   
    //ask user 	
    System.out.println("Is there a path from : ");
     Scanner in = new Scanner(System.in); 
     String fr = in.next();
     
     int from = b.index(fr);
    	
    
     System.out.println("To : ");
     String t = in.next();
     
     int to = b.index(t);
     
     //prints the path between two given nodes (from CA to NY")
     //int from = sg.index("CA");
     //int to = sg.index("NY");
    	
     
   
     BreadthFirstDirectPath bfs = new BreadthFirstDirectPath(b.graph(), from);   //get from as the source
     BreadthFirstDirectPath bfsreverse = new BreadthFirstDirectPath(b.graph(), to);//get to as the source
    	
    	System.out.println("\n" + "From " + fr + " to " + t + " ? ");
    	
    	
     //check there is path or not
    	if(bfs.hasPathTo(to)) {
    		
    		//if there is a path
			System.out.println("There is a path between " + fr + " and " + t + ".");
	}	
	 
    	else if (bfsreverse.hasPathTo(from)) {
    		
    		System.out.println("There is a path between " + fr + " and " + t + " in reverse order But there is no direct path.");
    	}
    	
    	else
				System.out.println("There is no path from " + fr + " to " + t + ".");
	
    }

}
