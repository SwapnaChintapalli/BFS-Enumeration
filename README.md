# SP12
Implementation of data structures and algorithms
Fall 2018
Short Project 12: BFS, Enumeration
Thu, Nov 15, 2018

Version 1.0: Initial description (Thu, Nov 15).

Note that the due dates are different for the team task and optional tasks.

Team task: Due: 11:59 PM, Sun, Nov 25.

1. Implement the algorithm to find the diameter of a tree using the
   algorithm discussed in class, that runs BFS twice.  Code this
   algorithm without modifying Graph.java and BFSOO.java, using them
   from package rbk.

   int diameter(Graph g) { ... }  // assume that g is an acyclic, connected graph (tree).


Optional tasks (individual):  Due: 11:59 PM, Sun, Dec 2.

2. Implement a BFS based algorithm to output an odd-length cycle of a graph.
   If the graph is bipartite, it returns null.  The problem can be solved as follows.
   Run BFS on the graph.  If it is not connected, you should run BFS on each component.
   If there is any edge e=(u,v) with u.distance = v.distance, then the graph has
   an odd-length cycle.  Otherwise, it is bipartite, and has no odd-length cycles.
   Once you find such an edge, an odd-length cycle can be found by going up the
   BFS tree using parent links, from u and v in tandem, until reaching their
   least common ancestor in the BFS tree containing u and v.  Code this
   algorithm without modifying Graph.java and BFSOO.java, using them
   from package rbk.  Make sure that the returned list has the
   vertices in order along the cycle.

   List<Vertex> oddCycle(Graph g) { ... }  // do not assume that g is connected


The following methods are related to Enumerate.java.  Changing the
signature of select from the following:
	public boolean select(T item) { return true; }
to the following, makes it easier to write approvers:
	public boolean select(T[] arr, int index, T item) { return true; }
	// arr[0..index-1] is frozen, and item is being considered for arr[index].

3. Implement the algorithm to enumerate all paths from s to t in a DAG.
   Code this algorithm by using the permute method of Enumerate.java,
   and writing an Approver in a new class, that extends Enumerate.Approver.

4. Enumerate all permutations of 1..n, in which no two consecutive integers in
   the chosen permutations are both odd, or, are both even.
   If n = 4, the permutations visited are:

   1 2 3 4
   1 4 3 2
   2 1 4 3
   2 3 4 1
   3 2 1 4
   3 4 1 2
   4 1 2 3
   4 3 2 1

   All other permutations have 2 consecutive odd numbers or 2 consecutive even numbers.
   Avoid exploring any permutation that starts with 1 3 right at the time when 3 is considered
   for the second position, instead of waiting till visit() is reached.
   This problem can be solved by writing a suitable Approver, or writing the enumerate
   code from scratch.
