//Sareh Jalalizad

//Run Depth-first search on a direct graph.
//and check there is a path between any two vertices or not.

public class DepthFirstDirectPath {
	
	private boolean[] marked; // Has dfs() been called for this vertex?
	private int[] edgeTo;     // last vertex on known path to this vertex
	private final int s;      // source
	
	
	
   // Computes the vertices in graph that are
   // connected to the source vertex
	public DepthFirstDirectPath(DiGraph G, int s)
	{
		marked = new boolean[G.V()]; // has this node been visited
		edgeTo = new int[G.V()]; 
		this.s = s;  // this is the source 
		dfs(G, s);
	}
	
	// depth first search from v
	private void dfs(DiGraph G, int v) {
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
	
	
   // Shows the direct path between the source and a given vertex.
	public Iterable<Integer> pathTo(int v)
	{
		if (!hasPathTo(v))
			return null; // if no path exists
		
		Stack<Integer> path = new Stack<Integer>(); // used to save the path
		
	  // pushes the last vertex to stack effectively creating a path
		for (int x = v; x != s; x = edgeTo[x]) 
			
			path.push(x);
		    path.push(s);
		
	 //return the sequence of vertices on a directed path 
	 //from the source vertex to vertex  as an Iterable	    
		    return path;
		
	}
	
	

}
