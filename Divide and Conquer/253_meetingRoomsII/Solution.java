/*
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

Example 1:

Input: [[0, 30],[5, 10],[15, 20]]
Output: 2
Example 2:

Input: [[7,10],[2,4]]
Output: 1
*/

class Solution
{
	public int minMeetingRooms(int[][] intervals)
	{	
		int[] start = new int[intervals.length];
		int[] end = new int[intervals.length];
		for(int i = 0; i < intervals.length; i++)
		{
			start[i] = intervals[i][0];
			end[i] = intervals[i][1];
		}

		Arrays.sort(start);
		Arrays.sort(end);
		int endIdx = 0, rooms = 0;
		for(int i = 0; i < intervals.length; i++)
		{
			if(start[i] < end[endIdx])
				rooms++;
			else
				endIdx++;
		}
		return rooms;
	}
}
