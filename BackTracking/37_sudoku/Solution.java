/*
 * Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
Empty cells are indicated by the character '.'.
*/

class Solution
{
	public void solveSudoku(char[][] board)
	{
		if(board == null || board.length == 0) return;
		solve(board);
	}
	public boolean solve(char[][] board)
	{
		for(int i = 0; i < board.length; i++)
		{
			for(int j = 0; j < board[0].length; j++)
			{
				if(board[i][j] == '.')
				{
					for(char c = '1'; c <= '9'; c++) //trial try 1 through 9
					{
						if(isValid(board, i, j, c))
						{
							board[i][j] = c; //put c for this cell
							if(solve(board)) return true; //if it's the solution then return true
							else
								board[i][j] = '.'; //otherwise go back
						}
					}
					return false;
				}
			}
		}
		return true;
	}
	public isValid(char[][] board, int r, int c, int t)
	{
		for(int i = 0; i < 9; i++)
		{
			if(board[i][c] != '.' && board[i][c] == t) return false; //check column
			if(board[r][i] != '.' && board[r][i] == t) return false; //check row
			if(board[3 * (r / 3) + i / 3][3 * (c / 3) + i % 3] != '.' && board[3 * (r / 3) + i / 3][3 * (c / 3) + i % 3] == t) return false; //check 3*3 grid
		}
		return true;
	}
}	
