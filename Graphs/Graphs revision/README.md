**Problem - Algorithm - Time Complexity**

Coloring a Border - DFS - O(m*n)

Number of Enclaves - DFS - O(m*n)

0-1 Matrix - BFS - O(m*n)

Number of Distinct Island - DFS - O(m*n)

Rotting Oranges - BFS - O(m*n)

As Far From Land As Possible - BFS - (m*n)

Sliding Puzzle - BFS - O((m*n)! ) but since the size of the matrix is fixed i.e. 2X3 always, the complexity is 6! that means constant. So the time complexity for this solution is O(1)

Shortest Bridge - DFS + BFS - 2*O(m*n) == O(mn)

Bus Routes - BFS - O(m*n)

Minimum Number Of Swaps Required To Sort An Array - we are traversing the array in O(n) for duplicating the elements then for sorting nlogn time is required and then finally O(n) time is required to find the no. of swaps. So total time complexity in terms of big-o is: O(n)+O(nlogn)+O(n)=O(nlogn)

Course Schedule (Topological sort using Kahn's Algorithm) - BFS (indegree concept) - o(V+E)

Pepcoder And Reversing - BFS - O(m) - m is number of Edges

Alien Dictionary - BFS(indegree concept) -  O(N * L) - N is number of words and L is length of max length word

Optimize Water Distribution(Prims algorithm for finding the minimum spanning tree) - BFS - O((v+e) logv)

Kruskal Algorithm(sum of edge wt of MST) - union-find - O(E logv)

Minimum Cost To Connect All Cities - BFS - O((V+E)logV) because each vertex is inserted in the priority queue only once and insertion in the priority queue takes logarithmic time. Here E represents the number of edges and V represents the number of vertices in the graph.

Bellman Ford - O(m-n)

Negative Weight Cycle Detection - Bellman Ford - O(m*n)

Redundant Connection - Union-find - O(n)

Strongly Connected Components - Kosaraju Algorithm - DFS - O(V+E)

Remove Max Number Of Edges To Keep Graph Fully Traversable - union - find - O(e*v)

Critical connection(Bridge problem) - (using low, disc, parent, time) - DFS - O(V+E)

Articulation Point - DFS - O(V+E)
