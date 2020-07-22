/*
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?



Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
             To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take.
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.
*/

class Solution
{
	public boolean canFinish(int numCourses, int[][] prerequisites)
	{
		int[] inDegree = new int[numCourses];
		for(int i = 0; i < prerequisites.length; i++)
			inDegree[prerequisites[i][0]]++;
		int count = 0;
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i < prerequisites.length; i++)
		{
			if(inDegree[i] == 0)
				stack.push(i);
		}

		while(!stack.isEmpty())
		{
			int curr = stack.pop();
			count++;
			for(int i = 0; i < prerequisites.length; i++)
			{
				if(inDegree[prerequisites[i][1]] == curr)
				{
					inDegree[prerequisites[i][0]]--;
					if(inDegree[prerequisites[i][0]] == 0)
						stack.push(prerequisites[i][0]);
				}
				
			}
		}
		return count == numCourses;
		
	}
}
