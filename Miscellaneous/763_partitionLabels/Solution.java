/*
763. Partition Labels
Medium

2705

123

Add to List

Share
A string S of lowercase English letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.

 

Example 1:

Input: S = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
*/

class Solution
{
    public List<Integer> partitionLabels(String s)
    {
        List<Integer> result = new ArrayList<>();
        int[] map = new int[26];
        int last = 0, start = 0;

        for(int i = 0; i < s.length(); i++)
            map[s.charAt(i) - 'a'] = i;

        for(int i = 0; i < s.length(); i++)
        {
            last = Math.max(last, map[s.charAt(i) - 'a']);
            if(i == last)
            {
                result.add(last - start + 1);
                start = last + 1;
            }
        }
        return result;
    }
}