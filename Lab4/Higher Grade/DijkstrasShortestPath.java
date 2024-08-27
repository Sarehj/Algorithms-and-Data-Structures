//Sareh Jalalizad

//Find shortest path from two points
//Since all edge weights are positive, Dijkstra algorithm is used to find the minimum distance 
//from a source vertex to other vertices that are connected to the source vertex


//Simple algorithm with Time complexity of O(V^2).
// Binary Heap (Min Heap) is used its O((|E| + |V|) log |V|)
import java.util.Scanner;


public class DijkstrasShortestPath {

	    private double[] distTo;          // distTo[v] = distance  of shortest s->v path
	    private Edge[] edgeTo;            // edgeTo[v] = last edge on shortest s->v path
	    private IndexMinPQ<Double> pq;    // priority queue of vertices
    

    
	 // Computes a shortest-paths tree from the source vertex source to every
	 // other vertex in the edge-weighted graph
     DijkstrasShortestPath(EdgeWeightedGraph G, int s) {

        
         this.edgeTo = new Edge[G.V()];
         this.distTo = new double[G.V()];
         this.pq = new IndexMinPQ<>(G.V());

      // Dijkstra algorithm is not for negative weights
         for (int v = 0; v < G.V(); v++)
            this.distTo[v] = Double.POSITIVE_INFINITY;  //all nodes to infinity since they havn't been vistited.

         this.distTo[s] = 0.0;   //starting node

      // relax vertices in order of distance from source (s)
         this.pq.insert(s, this.distTo[s]);  // put the vertex in pq, ordered based on the value of distance to the vertex

         while (!this.pq.isEmpty()) {

            int v = this.pq.deleteMin(); //get the vertex in the priority queue
            
            for (Edge edge: G.adj(v))
                relax(edge, v);
         }
    }

     //Relax edge e and update pq if changed
     //Updates information about the smallest weight between a given vertex and and its associated edge
     //if the path between the source and the given vertex has a lower weight than the current known.
    private void relax(Edge e, int v) {

        int w = e.other(v);

     // check if the new distance calculated is less than the current distance
        if (this.distTo[w] > this.distTo[v] + e.weight()) {

            this.distTo[w] = this.distTo[v] + e.weight();
            this.edgeTo[w] = e;

        //check pq has w or not    
            if (pq.contains(w))
                pq.decreaseKey(w, this.distTo[w]);  //update the distance if an smaller one is found
            else
                pq.insert(w, distTo[w]); //if not,just added it to where is supposed to be
        }
    }

    
    //Returns the length of a shortest path between the source vertex s and vertex v.
     double distTo(int v) {

        return distTo[v];
    }

 
    //Returns true if there is a path between the source vertex s and vertex v otherwise false
     boolean hasPathTo(int v) {

        return distTo[v] < Double.POSITIVE_INFINITY;
    }
     
     
     //return the sequence of vertices on a shortest path, as an Iterable 
     public Iterable<Edge> pathTo(int v) {
         if (!hasPathTo(v)) { 
        	 return null; 
        	 }

         Stack<Edge> path = new Stack<>();
         int x = v;
         for (Edge e = edgeTo[v]; e != null; e = edgeTo[x]) {
             path.push(e);
             x = e.other(x);
         }
         return path;
     }
     
     
    
     //test
     @SuppressWarnings("resource")
     public static void main(String[] args) {
        
    	 String inputFile = "C:\\Users\\sareh\\Desktop\\Lab4\\NYC.txt";
         SymbolGrShortPath sg = new SymbolGrShortPath(inputFile, " ");
       
         //String source = "AL"; // x
 	    
         //ask user
         System.out.println("Find the shortest path from : ");
 	  
		 Scanner in = new Scanner(System.in); 
 	     String source = in.next();   // x
          int s = sg.index(source);
 

          System.out.println("to : ");
              String t = in.next(); // y
              if (sg.contains(t)) {
                  int to = sg.index(t); 
                  
        
          System.out.println("passes through : ");  //C
              String P = in.next(); 
              if (sg.contains(P)) {
            	  int pass = sg.index(P); 
            
       System.out.println("The shortest path from  " + source + " to " + t + " passes through " + P + " is: ");
                          
       
       DijkstrasShortestPath sp = new DijkstrasShortestPath(sg.edgeWeighted(), s);
    
        @SuppressWarnings("unused")
		double weightCount = 0;
     
               if (sp.hasPathTo(pass)) {
                    for (Edge a : sp.pathTo(pass)) { 
                    int pre = a.either();
                    int nex = a.other(pre);
               
                System.out.println(sg.name(pre) + " "  + sg.name(nex) +  "  " );
                weightCount += a.weight();
            }
       
        }
               
               
         DijkstrasShortestPath sa = new DijkstrasShortestPath(sg.edgeWeighted(), pass);
                     
         @SuppressWarnings("unused")
		double weightC = 0;
               
                       if (sa.hasPathTo(to)) {
                           for (Edge v : sa.pathTo(to)) {
                               int prev = v.either();
                               int next = v.other(prev);
                              
                               System.out.println(sg.name(prev) + " "  + sg.name(next) +  "  " );
                               
                               weightC += v.weight();
                           }
                         
                 //      double totalweight = weightC + weightCount;
                        
                 //       System.out.println("Total weight: " + totalweight);
                        
                        weightC = 0;
                        weightCount = 0;

                 }
                 else System.out.println("Not connected.");
             }
             else System.out.println("Not in database.");
         }
     }
}