### Lab 4 - Graphs

Input: The database of vertex pairs "data.txt"

###### Part 1: Undirected graphs 

For this part we assumed that the edges defined by the vertex pairs are two-way.

1) A program based on DFS which can answer questions of the type: "Find the a path from X to Y" Which results in a list of vertices traversed from X to Y if there is a path.

2) Change the above program to use BFS.

###### Part 2: Directed graphs

For this part we assumed that the edges defined by the vertex pairs in the data base are one-way.

3) A program that can answer if there is a path between any to vertices.

#### Higher Grade

Implement a program which allows the user to find the shortest path between two nodes in a graph possibly passing through a third node. I.e. the user can be able to ask questions like:
Which is the shortest path from A to B passing through C? 
The program output an ordered list of the nodes to traverse from A to B if such a path exists. If no such path exists then the program output that no such path exists.

** input: NYC.txt - this is the undirected road network of New York City. The graph contains 264346 vertices and 733846 edges. It is connected, contains parallel edges, but no self-loops. The edge weights are travel times and are strictly positive. 