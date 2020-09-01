/*
56. Merge Intervals
Medium

4778

312

Add to List

Share
Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
*/

class Solution
{
    public int[][] merge(int[][] intervals)
    {
        if(intervals.length < 2)
            return intervals;
        
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int[] newInterval = intervals[0];
        result.add(newInterval);

        for(int[] interval : intervals)
        {
            if(newInterval[1] >= interval[0])
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            else
            {
                newInterval = interval;
                result.add(newInterval);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}