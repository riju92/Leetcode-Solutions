/*
994. Rotting Oranges
Easy

992

152

Add to List

Share
In a given grid, each cell can have one of three values:

the value 0 representing an empty cell;
the value 1 representing a fresh orange;
the value 2 representing a rotten orange.
Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.
*/

class Solution {
    public int orangesRotting(int[][] grid) 
    {
        Set<String> fresh = new HashSet<>();
        Set<String> rotten = new HashSet<>();
        
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[i].length; j++)
            {
                if(grid[i][j] == 1) fresh.add("" + i + j);
                if(grid[i][j] == 2) rotten.add("" + i + j);
            }
        }
        
        int min = 0;
        int[][] direction = {{1 , 0},{0 , 1},{-1 , 0},{0 , -1}};
        
        while(fresh.size() > 0)
        {
            Set<String> infected = new HashSet<>();
            for(String s : rotten)
            {
                int i = s.charAt(0) - '0';
                int j = s.charAt(1) - '0';
                for(int[] d : direction)
                {
                    int nxt_i = i + d[0];
                    int nxt_j = j + d[1];
                    if(fresh.contains("" + nxt_i + nxt_j))
                    {
                        fresh.remove("" + nxt_i + nxt_j);
                        infected.add("" + nxt_i + nxt_j);
                    }
                }
            }
            if(infected.size() == 0)
                return -1;
            
            rotten = infected;
            min++;
        }
        return min;
    }
}

