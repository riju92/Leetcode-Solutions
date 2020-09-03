/*
1177. Can Make Palindrome from Substring
Medium

237

164

Add to List

Share
Given a string s, we make queries on substrings of s.

For each query queries[i] = [left, right, k], we may rearrange the substring s[left], ..., s[right], and then choose up to k of them to replace with any lowercase English letter. 

If the substring is possible to be a palindrome string after the operations above, the result of the query is true. Otherwise, the result is false.

Return an array answer[], where answer[i] is the result of the i-th query queries[i].

Note that: Each letter is counted individually for replacement so if for example s[left..right] = "aaa", and k = 2, we can only replace two of the letters.  (Also, note that the initial string s is never modified by any query.)

 

Example :

Input: s = "abcda", queries = [[3,3,0],[1,2,0],[0,3,1],[0,3,2],[0,4,1]]
Output: [true,false,false,true,true]
Explanation:
queries[0] : substring = "d", is palidrome.
queries[1] : substring = "bc", is not palidrome.
queries[2] : substring = "abcd", is not palidrome after replacing only 1 character.
queries[3] : substring = "abcd", could be changed to "abba" which is palidrome. Also this can be changed to "baab" first rearrange it "bacd" then replace "cd" with "ab".
queries[4] : substring = "abcda", could be changed to "abcba" which is palidrome.
*/
// using HashSet will face TLE

// class Solution
// {
//     public List<Boolean> canMakePaliQueries(String s, int[][] queries)
//     {
//         List<Boolean> result = new ArrayList<>();

//         for(int[] query: queries)
//         {
//             result.add(isValid(s, query[0], query[1], query[2]));
//         }
//         return result;
//     }

//     private boolean isValid(String s, int start, int end, int max)
//     {
//         if(max >= 13)
//             return true;

//         HashSet<Character> set = new HashSet<>();
//         for(int i = start; i <= end; i++)
//         {
//             if(!set.contains(s.charAt(i)))
//                 set.add(s.charAt(i));
//             else
//                 set.remove(s.charAt(i));
//         }

//         return set.size() / 2 <= max;
//     }
// }

//using int[] to store characters to avoid TLE
class Solution
{
    public List<Boolean> canMakePaliQueries(String s, int[][] queries)
    {
        List<Boolean> result = new ArrayList<>();

        for(int[] query: queries)
        {
            result.add(isValid(s, query[0], query[1], query[2]));
        }
        return result;
    }

    private boolean isValid(String s, int start, int end, int max)
    {
        int count = 0;
        if(max >= 13)
            return true;

        int[] letters = new int[26];
        for(int i = start; i <= end; i++)
        {
            letters[s.charAt(i) - 'a'] = (letters[s.charAt(i) - 'a'] == 0? 1 : 0);
        }
        for(int i : letters)
            count += i;
        return count / 2 <= max;
    }
}