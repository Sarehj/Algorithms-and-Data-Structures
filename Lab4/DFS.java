//Sareh Jalalizad

//The code uses a depth first search algorithm to find paths to all the vertices in a given graph that contains
//a given source vertex. It marks every vertex visited in a boolean array called "marked" which marks all vertices that
//are connected to the source vertex. 


public class DFS {
	
	private boolean[] marked; // Has dfs() been called for this vertex?
	private int[] edgeTo;     // last vertex on known path to this vertex
	private final int s;      // source
	
	
	
   // Computes the vertices in graph that are
   // connected to the source vertex
	public DFS(Graph G, int s)
	{
		marked = new boolean[G.V()]; // has this node been visited
		edgeTo = new int[G.V()]; 
		this.s = s;  // this is the source 
		dfs(G, s);
	}
	
	// depth first search from v
	private void dfs(Graph G, int v) {
		marked[v] = true;
		for (int w : G.adj(v)) 
			if (!marked[w])
			{
				edgeTo[w] = v; //remembers path
				dfs(G, w);     // recursive call 
			}
	}
	
	
	//Is there a path between the source vertex and vertex
	//return true if there is a path otherwise return false
	public boolean hasPathTo(int v) 
	{ 
		return marked[v]; 
		}
	
	
   // Shows the path between the source and a given vertex.
	public Iterable<Integer> pathTo(int v)
	{
		if (!hasPathTo(v))
			return null; // if no path exists
		
		Stack<Integer> path = new Stack<Integer>(); // used to save the path
		
	  // pushes the last vertex to stack effectively creating a path
		for (int x = v; x != s; x = edgeTo[x]) 
			
			path.push(x);
		    path.push(s);
		
	 //return the sequence of vertices from the source vertex to vertex as an Iterable	    
		    return path;
		
	}
	
}

