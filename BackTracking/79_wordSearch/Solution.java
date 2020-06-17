/*
 * Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
*/

class Solution
{
	public boolean exist(char[][] board, String word)
	{
		for(int i = 0; i < board.length; i++)
		{
			for(int j = 0; j < board[i].length; j++)
			{
				if(board[i][j] == word.charAt(0) && dfs(board, word, i, j, 0)) return true;
			}
		}
		return false;
	}
	public boolean dfs(char[][] board, String word, int r, int c, int count)
	{
		if(count == word.length()) return true;
		if(r < 0 || r >= board.length() || c < 0 || c >= board[r].length || board[r][c] != word.charAt(count)) return false;

		char temp = board[r][c];
		board[r][c] = '#';
		boolean found = dfs(board, word, r + 1, c, count + 1)
			|| 	dfs(board, word, r - 1, c, count + 1)
			||	dfs(board, word, r, c + 1, count + 1)
			||	dfs(board, word, r, c - 1, count + 1);

		board[r][c] = temp;
		return found;

	}
}

