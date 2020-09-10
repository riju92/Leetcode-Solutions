/*
761. Special Binary String
Hard

317

106

Add to List

Share
Special binary strings are binary strings with the following two properties:

The number of 0's is equal to the number of 1's.
Every prefix of the binary string has at least as many 1's as 0's.
Given a special string S, a move consists of choosing two consecutive, non-empty, special substrings of S, and swapping them. (Two strings are consecutive if the last character of the first string is exactly one index before the first character of the second string.)

At the end of any number of moves, what is the lexicographically largest resulting string possible?

Example 1:
Input: S = "11011000"
Output: "11100100"
Explanation:
The strings "10" [occuring at S[1]] and "1100" [at S[3]] are swapped.
This is the lexicographically largest string possible after some number of swaps.
*/

class Solution
{
    public String makeLargestSpecial(String s)
    {
        int index = 0;
        int count = 0;

        List<String> result = new ArrayList<>();

        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) == '1')
                count++;
            else
                count--;
            
            if(count == 0)
            {
                result.add("1" + makeLargestSpecial(s.substring(index + 1, i)) + "0");
                index = i + 1;
            }
            
        }
        Collections.sort(result, Collections.reverseOrder());
        return String.join("", result);
    }
}