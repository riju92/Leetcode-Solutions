/*
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list.
Note:

Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: 0

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation
*/

class Object
{
	String word;
	int length;
	Object(String word, int length)
	{
		this.word = word;
		this.length = length;
	}
}

class Solution
{
	public int ladderLength(String beginWord, String endWord, List<String> wordList)
	{
		if(beginWord.length() == 0 || endWord.length() == 0 || wordList.size() == 0) return 0;
		Queue<Object> queue = new Queue<Object>();
		queue.offer(new Object(beginWord, 1));
		while(!queue.isEmpty())
		{
			Object curr = queue.poll();
			ListIterator<String> itr = wordList.listIterator();
			while(itr.hasNext())
			{
				String temp = itr.next();
				if(isAdjacent(temp, curr.word))
				{
					itr.remove();
					queue.offer(new Object(temp, curr.length + 1));
					if(temp.equals(endWord)) return curr.length + 1;
				}
			}
		}
		return 0;
	}
	public boolean isAdjacent(String s1, String s2)
	{
		int count = 0;
		for(int i = 0; i < s1.length; i++)
		{
			if(s1.charAt(i) != s2.charAt(i)) count ++;
		}

		return count > 1? false : true;
	}
}
