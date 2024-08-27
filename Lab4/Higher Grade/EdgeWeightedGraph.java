//Sareh Jalalizad

//represents edge weighted graph with undirected edges.
// based on algorithms 4th edition

public class EdgeWeightedGraph {
	
		private final int V;
		private int E;
		private Bag<Edge>[] adj;
	
		
 
		@SuppressWarnings("unchecked")
   //Initializes an empty edge-weighted graph with vertices and 0 edges.
		public EdgeWeightedGraph(int in){
		
			this.V = in;
			this.E = 0;
			
			adj = (Bag<Edge>[]) new Bag[in];
			
			for (int v = 0; v < in; v++) {
			
				adj[v] = new Bag<Edge>();
			}
		}
		
		
	//Adds the undirected edge e to this edge-weighted graph.	
		public void addEdge(Edge e) {
			
			int v = e.either();
			int w = e.other(v);
			adj[v].add(e);
			adj[w].add(e);
			E++;
		}
		
	   
	 //return the number of edges in this edge-weighted graph
			    public int E() {
			        return E;
			    }
		
			    
	//return the number of vertices in this edge-weighted graph
			    public int V() {
			        return V;
			    }
	 
	
	//String representation of this graph.
		public String toString(SymbolGrShortPath sg) {
			
			String s = V + " vertices, " + E + " edges\n";
			
			for (int v = 0; v < V; v++) {
			
				s += sg.name(v) + ": ";
				
				for(Edge e : this.adj(v))
					
					s += e + " "; 
				
				s += "\n";
		}
			return s;
		}

	
	//return the edges incident on vertex as an Iterable	
		public Iterable<Edge> adj(int v){
			return adj[v];
		} 
	
		
	//return all edges in this edge-weighted graph, as an iterable	
		public Iterable<Edge> edges(){
			
			Bag<Edge> bag = new Bag<Edge>();
			
			for(int v = 0; v < V; v++) 
			
				for(Edge e : adj[v])
				
					if(e.other(v) > v)
					
						bag.add(e);
			
			return bag;
		}

}
