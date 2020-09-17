import java.util.*;

/*
Bob navigates a maze
*/

class bobNavigatesMaze
{   
    private int counter = 0;
    // private int[] path = new int[maze.length];
    // private int minPath = Integer.MAX_VALUE;
    public int findMindPath(int[][] maze, int[] alice)
    {
        int alicei = alice[0];
        int alicej = alice[1];
        // int counter = 0;
        int[] path = new int[maze.length];
        Arrays.fill(path, Integer.MAX_VALUE);
        int minPath = Integer.MAX_VALUE;

        dfs(maze, 0, 0, alicei, alicej, path, 0, counter);
        for(int i : path)
        {
            minPath = Math.min(minPath, i);
            //System.out.println(i);
        }
        return (minPath == Integer.MAX_VALUE)? -1 : minPath;
    }

    private void dfs(int[][] maze, int row, int col, int alicei, int alicej, int[] path, int index, int counter)
    {
        if(row < 0 || row >= maze.length || col < 0 || col >= maze[row].length || maze[row][col] == 1 || maze[row][col] == 9)
            return;

        if(row == alicei && col == alicej)
        {
                path[index] = counter;
                index++;
                return;
        }

        if(maze[row][col] == 2 || maze[row][col] == 0)
            counter++;
            
        int temp = maze[row][col];
        maze[row][col] = 9;

        dfs(maze, row + 1, col, alicei, alicej, path, index, counter);
        dfs(maze, row - 1, col, alicei, alicej, path, index, counter);
        dfs(maze, row, col - 1, alicei, alicej, path, index, counter);
        dfs(maze, row, col + 1, alicei, alicej, path, index, counter);
        maze[row][col] = temp;
        return;
    }

    public static void main(String[] args) {
        bobNavigatesMaze obj = new bobNavigatesMaze();
        int[][] maze = {{0,2,0},{1,1,2},{1,0,0}};
        int[] alice = {2, 1};
        int path = obj.findMindPath(maze, alice);
        System.out.println(path);
    }
}