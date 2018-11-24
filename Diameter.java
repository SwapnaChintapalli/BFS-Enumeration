package sxc180048;
import java.io.File;
import java.util.Scanner;

import rbk.*;
import rbk.Graph.Edge;
import rbk.Graph.Vertex;
public class Diameter
{
	static boolean visit[];
	static Graph gr;
	Diameter(Graph g)
	{
		gr = g;
		visit = new boolean[gr.size()];
	}
	private boolean isCyclicRec(Vertex i, boolean[] visited, 
            boolean[] recStack)  
    {  
    	if (recStack[i.getIndex()]) 
    			return true; 

    	if (visited[i.getIndex()]) 
    			return false; 

    	visited[i.getIndex()] = true; 

    	recStack[i.getIndex()] = true; 
    	for(Edge c:gr.outEdges(i))
    	{
    		if(!c.toVertex().equals(c.fromVertex()))
    		{
    			if(i.equals(c.toVertex()))
    				continue;
    		if (isCyclicRec(c.toVertex(), visited, recStack)) 
    				return true;
    		}
    		else
    			return true;
    	}
    	recStack[i.getIndex()] = false; 
    	return false; 
    }
    //Check if the graph consists cycles or not
    public boolean isCyclic(Graph g)
    {
    	boolean[] visited = new boolean[g.size()]; 
        boolean[] recStack = new boolean[g.size()];
        //for (int i = 0; i < g.size(); i++)
    	for(Vertex u: g) {
    	    visited[u.getIndex()] = false;
    	    recStack[u.getIndex()] = false;
    	}
        for(Vertex i:g)
        {
        	if(visit[i.getIndex()]== false)
        	{
        		if (isCyclicRec(i, visited, recStack)) 
        			return true;
        	}
        }
    	return false;
    }

	public int diameter(Graph g)
	{
		BFSOO bfs = new BFSOO(g);
		Vertex v = null;
		int max =0;
		for(Vertex u:g)
		{
			bfs = bfs.breadthFirstSearch(g, u);
			for(Vertex k:g)
			{
				if(k !=u)
				{
					if(bfs.getDistance(k) > max)
					{
						max = bfs.getDistance(k);
						v = k;
					}
				}
			}
		}
		bfs = bfs.breadthFirstSearch(g, v);
		int dia =0;
		for(Vertex l:g)
		{
			if(l!=v)
			{
				if(bfs.getDistance(l) > dia)
				{
					dia = bfs.getDistance(l);
				}
			}
		}
		return dia;
	}
	
	   public static void main(String[] args) throws Exception
	   {
//		   String string = "7 8   1 2 2   1 3 3   2 4 5   3 4 4   4 5 1   5 1 7   6 7 1   7 6 1 0";
		   String string = "10 12   1 3 2   1 8 3   2 4 5   3 2 4   4 7 1   8 5 7   8 2 1  5 4 1  5 10 1  6 8 1   6 10 1  10 9 1 0";
			Scanner in;
			// If there is a command line argument, use it as file from which
			// input is read, otherwise use input from string.
			in = args.length > 0 ? new Scanner(new File(args[0])) : new Scanner(string);
		        Graph g = Graph.readGraph(in);
		        System.out.println(g.size());
			g.printGraph(false);
			Diameter d = new Diameter(g);
			if(d.isCyclic(g))
				System.out.println("Cyclic Graph");
			else
				System.out.println("Diameter :"+d.diameter(g));
	   }
}
