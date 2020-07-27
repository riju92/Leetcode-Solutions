/*
 * Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.



Example:

Input:
board = [
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]
words = ["oath","pea","eat","rain"]

Output: ["eat","oath"]
*/

class Solution
{
	public List<String> findWords(char[][] board, String[] words)
	{
		List<String> result = new ArrayList<>();
		TrieNode root = buildTrie(words);
		for(int i = 0; i < board.length; i++)
		{
			for(int j = 0; j < board[i].length; j++)
			{
				dfs(board, result, i , j, root);
			}
		}
		return result;
	}

	public TrieNode buildTrie(String[] words)
	{
		TrieNode root = new TrieNode();
		for(String s : words)
		{
			TrieNode p = root;
			for(char c : s.toCharArray())
			{
				int i = c - 'a';
				if(p.next[i] == null)
					p.next[i] = new TrieNode();
				p = p.next[i];
			}
			p.word = s;
		}
		return root;
	}

	public void dfs(char[][] board, List<String> result, int row, int col, TrieNode p)
	{
		if(row < 0 || col < 0 || row >= board.length || col >= board[row].length || board[row][col] == '#')
			return;

		char temp = board[row][col];
		if(temp == '#' || p.next[temp - 'a'] == null)
			return;
		p = p.next[temp - 'a'];
		if(p.word != null) // found word
		{
			result.add(p.word);
			p.word = null; // avoid duplicate
		}

		board[row][col] = '#';
		dfs(board, result, row + 1, col, p);
		dfs(board, result, row - 1, col, p);
		dfs(board, result, row, col + 1, p);
		dfs(board, result, row, col - 1, p);
		board[row][col] = temp;
	}
}

class TrieNode
{
	TrieNode[] next = new TrieNode[26];
	String word;
}
