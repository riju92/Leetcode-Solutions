/*
1353. Maximum Number of Events That Can Be Attended
Medium

481

69

Add to List

Share
Given an array of events where events[i] = [startDayi, endDayi]. Every event i starts at startDayi and ends at endDayi.

You can attend an event i at any day d where startTimei <= d <= endTimei. Notice that you can only attend one event at any time d.

Return the maximum number of events you can attend.

Algo:

Sort events increased by start time.
Priority queue pq keeps the current open events.

Iterate from the day 1 to day 100000,
Each day, we add new events starting on day d to the queue pq.
Also we remove the events that are already closed.

Then we greedily attend the event that ends soonest.
If we can attend a meeting, we increment the result res.

*/

class Solution
{
    public int maxEvents(int[][] events)
    {
        int result = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int days = 0;
        for(int[] event : events)
            days = Math.max(event[1], days);

        int i = 0;
        int n = events.length;

        for(int d = 0; d <= days; d++)
        {
            while(!minHeap.isEmpty() && minHeap.peek() < d)
                minHeap.poll();

            while(i < n && event[i][0] == d)
            {
                minHeap.offer(events[i][1]);
                i++;
            }
            if(!minHeap.isEmpty())
            {
                minHeap.poll();
                result++;
            }
        }
        return result;
    }
}
