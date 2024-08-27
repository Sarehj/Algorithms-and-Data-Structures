//Sareh Jalalizad

public class SymbolGrShortPath {
	
		
		private ST<String, Integer> st;   // convert strings index(int)
		private String[] keys;            // index(int)-> string (convert back to Strings)
		private EdgeWeightedGraph  edgeWeighted;
		
	  
		//Initializes a graph from file, using a specified delimiter. 
	   //Each line in the file contains the name of the vertex
	   //followed by a list of the names of the vertices adjacent to that vertex, separated by the delimiter.
	   //file the file to get the vertices
	   //delimiter the delimiter between fields.
		
		public SymbolGrShortPath(String file, String delimiter) {
			
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
			in = new In(file);
			
			edgeWeighted = new EdgeWeightedGraph(st.size());
			int weight = 1;
		
			while(in.hasNextLine()) {
			
				String[] splitLineArray = in.readLine().split(delimiter);
				int v = st.get(splitLineArray[0]);
				
				for (int i = 1; i < splitLineArray.length; i++) {
				
					int w = st.get(splitLineArray[i]);
					
					edgeWeighted.addEdge(new Edge(v, w, weight));
					
					weight++;
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
		public int index(String name) {
			return st.get(name);
		}
		
	   //Returns the name of the given vertex number given in the parameter. 
		public String name(int vertex) {
			return keys[vertex];
		}
	
		
		//Returns the edge weighted graph associated with the symbol graph
		 public EdgeWeightedGraph edgeWeighted() {
			 return edgeWeighted;
		 }

	}




