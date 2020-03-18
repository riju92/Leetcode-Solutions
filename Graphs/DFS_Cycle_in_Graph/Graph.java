import java.io.*;
import java.util.*;


class Graph
{
    private int V; //vertices
    private LinkedList<Integer> adj[]; //adjacency list representation

    Graph( int v)
    {
        V = v;
        adj = new LinkedList[V];
        for(int i = 0; i < v; i++)
        {
            adj[i] = new LinkedList();
        }
    }

    void addEdge(int v, int w)  // Function to insert edges into the graph
    {
        adj[v].add(w);
        adj[w].add(v);
    }

    Boolean isCyclic()  // function returns true is cycle present else returns false
    {
        Boolean[] visited = new Boolean[V];
        for(int i = 0; i < V; i++)
        {
            visited[i] = false;  // Marks all vertices as white
        }

        for(int u = 0; u < V; u++)
        {
            if(!visited[u]) // no need to visit if already visited
            {
                if(isCyclicUtil(u, visited, -1)) return true;
            }
        }
        return false;

    }

    Boolean isCyclicUtil(int u, Boolean visited[], int parent)  // function which uses parent and visited to detect a cycle in a subgraph from the vertex u
    {
        Integer i;
        visited[u] = true;  // marks the current node u as visited

        Iterator<Integer> it = adj[u].iterator(); // visited all vertices adjacent to u
        while(it.hasNext())
        {
            i = it.next();

            if(!visited[i]) // if found a non visited adjacent then recur all vertices adjacent to it
            {
                if(isCyclicUtil(i, visited, u)) return true;

                
            }
            else if (i != parent) return true; // if adjacent is visited and parent of current then there exists a cycle
        }

        return false;
    }

    public static void main(String[] args)
    {
        Graph g1 = new Graph(5);
        g1.addEdge(1 , 0);
        g1.addEdge(0 , 2);
        g1.addEdge(2 , 1);
        g1.addEdge(0 , 3);
        g1.addEdge(3 , 4);


        if(g1.isCyclic())
            System.out.println("Cyclic");
        else
            System.out.println("Not cyclic");

        
    }
}