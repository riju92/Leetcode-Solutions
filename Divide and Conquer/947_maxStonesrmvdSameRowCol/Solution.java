/*
 * 947. Most Stones Removed with Same Row or Column
Medium

1060

384

Add to List

Share
On a 2D plane, we place stones at some integer coordinate points.  Each coordinate point may have at most one stone.

Now, a move consists of removing a stone that shares a column or row with another stone on the grid.

What is the largest possible number of moves we can make?

 

Example 1:

Input: stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
Output: 5
Example 2:

Input: stones = [[0,0],[0,2],[1,1],[2,0],[2,2]]
Output: 3
Example 3:

Input: stones = [[0,0]]
Output: 0
*/

class Solution
{
	public int removeStones(int[][] stones)
	{
		HashSet<int[]> visited = new HashSet<>();
		int noOfIslands = 0;

		for(int[] stone : stones)
		{
			if(!visited.contains(stone))
			{
				dfs(stones, stone, visited);
				noOfIslands++;
			}
		}

		return (stones.length - noOfIslands);
	}

	private void dfs(int[][] stones, int[] stone, HashSet<int[]> visited)
	{
		visited.add(stone);

		for(int[] nxtStone: stones)
		{
			if(!visited.contains[nxtStone])
			{
				if(nxtStone[0] == stone[0] || stone[1] == nxtStone[1])
					dfs(stones, nxtStone, visited);
			}
		}
	}
}
