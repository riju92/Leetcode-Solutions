/*
 * Suppose you have N integers from 1 to N. We define a beautiful arrangement as an array that is constructed by these N numbers successfully if one of the following is true for the ith position (1 <= i <= N) in this array:

The number at the ith position is divisible by i.
i is divisible by the number at the ith position.


Now given N, how many beautiful arrangements can you construct?

Example 1:

Input: 2
Output: 2
Explanation:

The first beautiful arrangement is [1, 2]:

Number at the 1st position (i=1) is 1, and 1 is divisible by i (i=1).

Number at the 2nd position (i=2) is 2, and 2 is divisible by i (i=2).

The second beautiful arrangement is [2, 1]:

Number at the 1st position (i=1) is 2, and 2 is divisible by i (i=1).

Number at the 2nd position (i=2) is 1, and i (i=2) is divisible by 1.

Algorithm

The idea behind this approach is simple. We try to create all the permutations of numbers from 1 to N. We can fix one number at a particular position and check for the divisibility criteria of that 
number at the particular position. But, we need to keep a track of the numbers which have already been considered earlier so that they aren't reconsidered while generating the permutations. If the 
current number doesn't satisfy the divisibility criteria, we can leave all the permutations that can be generated with that number at the particular position. This helps to prune the search space of the permutations to a great extent. We do so by trying to place each of the numbers at each position.

We make use of a visited array of size NN. Here, visited[i]visited[i] refers to the i^{th}i 
th number being already placed/not placed in the array being formed till now(True indicates that the number has already been placed).

We make use of a calculate function, which puts all the numbers pending numbers from 1 to N(i.e. not placed till now in the array), indicated by a FalseFalse at the corresponding visited[i]visited[i] position, and tries to create all the permutations with those numbers starting from the pospos index onwards in the current array. While putting the pos^{th}pos th number, we check whether the i^{th}i th number satisfies the divisibility criteria on the go i.e. we continue forward with creating the permutations with the number ii at the pos^{th}pos th position only if the number ii and pospos satisfy the given criteria. Otherwise, we continue with putting the next numbers at the same position and keep on generating the permutations.
*/

class Solution
{
	public int count = 0;
	public int countArrangment(int N)
	{
		if(N == 0) return 0;
		boolean[] visited = new boolean[N + 1];
		helper(N, 1, visited);
		return count;
	}
	public void helper(int N, int index, boolean[] visited)
	{
		if(index > N) 
		{
			count++;
			return;
		}
		for(int i = 1; i <= N; i++)
		{
			if(!visited[i] && (i % index == 0 || index % i == 0))
			{
				visited[i] = true;
				helper(N, index + 1, used);
				visited[i] = false;
			}	
		}
	}
}
