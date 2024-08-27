//Sareh Jalalizad

// The code uses a Breadth First Search algorithm to find paths to all the vertices in a given graph that contains
// a given source vertex. It marks every vertex visited in a boolean array called "marked" which marks all vertices that
// are connected to the source vertex.

public class BFS {
	
	private boolean[] marked; // Is a shortest path to this vertex known?
	private int[] edgeTo;     // last vertex on known path to this vertex
	private final int s;      // source
	
	
	
  //Computes the shortest path between the source vertex 
  //and every other vertex in the graph 
	public BFS(Graph G, int s)
	{
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		this.s = s;
		bfs(G, s);
	}
	
	
  //Searches for paths in a given graph using the "Breadth First Search" algorithm.
	private void bfs(Graph G, int s)
	{
		Queue<Integer> queue = new Queue<Integer>();
		marked[s] = true;         // Mark the source
		queue.enqueue(s);         // and put it on the queue.
		while (!queue.isEmpty())
		{
			int v = queue.dequeue(); // Remove next vertex from the queue.
			for (int w : G.adj(v))
 			if (!marked[w])          // For every unmarked adjacent vertex,
 			{
 				edgeTo[w] = v;    // save last edge on a shortest path,
 				marked[w] = true; // mark it because path is known,
 				queue.enqueue(w); // and add it to the queue.
 			}
		}
	}
	
	
   //Is there a path between the source and vertex?
   //return true if there is a path otherwise false.
	public boolean hasPathTo(int v)
	{ 
		return marked[v]; 
	}
	
	
	
   //Shows the path between the source and a given vertex.
   //return the sequence of vertices on a shortest path, as an Iterable
	public Iterable<Integer> pathTo(int v)
	{
		if (!hasPathTo(v)) 
			return null; // if no path exists
		
		Stack<Integer> path = new Stack<Integer>(); // used to save the path
		
	  //pushes the last vertex to stack effectively creating a path
		for (int x = v; x != s; x = edgeTo[x])  
			
			path.push(x);
		    path.push(s);
		
		    return path;
	}

}
