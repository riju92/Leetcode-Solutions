import java.util.*;

class BFSIterator
{
    private int vertex;
    private LinkedList<Integer> list[];

    public BFSIterator(int vertex)
    {
        this.vertex = vertex;
        list = new LinkedList[vertex];
        for(int i = 0; i < vertex; i++)
            list[i] = new LinkedList<>();
    }

    public void addEdge(int source, int dest)
    {
        list[source].addFirst(dest);
        list[dest].addFirst(source);
    }

    public void bfs(int root)
    {
        boolean[] visited = new boolean[vertex];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(root);

        while(!queue.isEmpty())
        {
            root = queue.poll();
            visited[root] = true;

            System.out.println(root + " ");

            Iterator<Integer> itr = list[root].listIterator();

            while(itr.hasNext())
            {
                int temp = itr.next();
                if(!visited[temp])
                {
                    visited[temp] = true;
                    queue.add(temp);
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        
        BFSIterator obj = new BFSIterator(4);

        obj.addEdge(0, 1); 
        obj.addEdge(0, 2); 
        obj.addEdge(1, 2); 
        obj.addEdge(2, 0); 
        obj.addEdge(2, 3); 
        obj.addEdge(3, 3);

        obj.bfs(2);
    }
}