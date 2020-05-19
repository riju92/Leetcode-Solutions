/*
692. Top K Frequent Words
Medium

1571

130

Add to List

Share
Given a non-empty list of words, return the k most frequent elements.

Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.

Example 1:
Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
Output: ["i", "love"]
Explanation: "i" and "love" are the two most frequent words.
    Note that "i" comes before "love" due to a lower alphabetical order.
Example 2:
Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
Output: ["the", "is", "sunny", "day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
    with the number of occurrence being 4, 3, 2 and 1 respectively.
    */




class Solution {
    public List<String> topKFrequent(String[] words, int k) 
    {
        ArrayList<String> result = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String s : words)
        {
            if(map.containsKey(s))
            {
                map.put(s, map.get(s)+1);
            }
            else
            {
                map.put(s, 1);
            }
        }
        
        PriorityQueue<String> minHeap = new PriorityQueue<>(
        (a, b) -> map.get(a) == map.get(b)? b.compareTo(a) : map.get(a) - map.get(b)
        ); 
        
        for(String x : map.keySet())
        {
            minHeap.offer(x);
            if(minHeap.size() > k) minHeap.poll();
        }
        
        while(!minHeap.isEmpty())
        {
            result.add(0,minHeap.poll());
        }
        return result;
    }
}