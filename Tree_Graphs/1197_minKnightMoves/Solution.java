/*
In an infinite chess board with coordinates from -infinity to +infinity, you have a knight at square [0, 0].

A knight has 8 possible moves it can make, as illustrated below. Each move is two squares in a cardinal direction, then one square in an orthogonal direction.

Return the minimum number of steps needed to move the knight to the square [x, y].  It is guaranteed the answer exists.
Example 1:

Input: x = 2, y = 1
Output: 1
Explanation: [0, 0] → [2, 1]
Example 2:

Input: x = 5, y = 5
Output: 4
Explanation: [0, 0] → [2, 1] → [4, 2] → [3, 4] → [5, 5]
*/

class Solution
{
    private boolean isValid(int n, int x, int y)
    {
        if(x < 0 || y < 0 || x >= n || y >= n)
            return false;
        return true;
    }

    public int minMoves(int n, int startRow, int startCol, int endRow, int endCol)
    {
        int[][] moves = {{1,2}, {-1,2}, {1,-2}, {-1,-2}, {2,1}, {-2,1}, {2, -1}, {-2, -1}};
        Queue<int[]> queue = new LinkedList<>();

        boolean[][] visited = new boolean[n][n];
        int[] temp = new int[2];
        temp[0] = startRow;
        temp[1] = startCol;
        queue.add(temp);

        while(!queue.isEmpty())
        {
            for(int i = 0; i < queue.size(); i++)
            {
                int[] curr = queue.poll();

                if(curr[0] == endRow && curr[1] == endCol)
                    return result;

                if(!visited[curr[0]][curr[1]])
                {
                    visited[curr[0]][curr[1]] = true;
                    for(int[] move : moves)
                    {
                        int[] position = new position[2];
                        if(isValid(int n, curr[0] + move[0], curr[1] + move[1]))
                        {
                            position[0] = curr[0] + move[0];
                            position[1] = curr[1] + move[1];
                            queue.offer(position);
                        }
                    }
                }

            }
            result++;
        }

        return -1;
    }
    public static void main(String[] args) {
        
        Solution obj = new Solution();

        
    }
}