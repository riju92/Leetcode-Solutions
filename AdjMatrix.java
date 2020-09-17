import java.util.*;

public class AdjMatrix
{
    private int vertex;
    private int[][] matrix;

    public AdjMatrix(int vertex)
    {
        this.vertex = vertex;
        matrix = new int[vertex][vertex];
    }

    public void addEdge(int source, int dest)
    {
        matrix[source][dest] = 1;
        matrix[dest][source] = 1;
    }

    public void display()
    {
        System.out.println("Dislaying Adjacency Matrix");
        for(int row = 0; row < vertex; row++)
        {
            for(int col = 0; col < vertex; col++)
            {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }

        for(int row = 0; row < matrix.length; row++)
        {
            System.out.println("Node " + row + "is connected to: ");
            for(int col = 0; col < matrix[row].length; col++)
            {
                if(matrix[row][col] == 1)
                System.out.print(col);
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        
        AdjMatrix obj = new AdjMatrix(5);
        obj.addEdge(0, 1);
        obj.addEdge(0, 4);
        obj.addEdge(1, 2);
        obj.addEdge(1, 3);
        obj.addEdge(1, 4);
        obj.addEdge(2, 3);
        obj.addEdge(3, 4);

        obj.display();
    }
}