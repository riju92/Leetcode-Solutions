import java.util.*;


public class AdjList
{
    private int vertex;
    private LinkedList<Integer> list[];

    public AdjList(int vertex)
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

    public void display()
    {
        for(int i = 0; i < list.length; i++)
        {
            System.out.println("Node "+list[i]+"is connected to ");
            for(int j = 0; j < list[i].size(); j++)
                System.out.println(list[i].get(j));
            
            System.out.println();
        }
    }

    public static void main(String[] args) {
        
        AdjList obj = new AdjList(5);
        obj.addEdge(0,1);
        obj.addEdge(0, 4);
        obj.addEdge(1, 2);
        obj.addEdge(1, 3);
        obj.addEdge(1, 4);
        obj.addEdge(2, 3);
        obj.addEdge(3, 4);
        obj.display();

    }
}