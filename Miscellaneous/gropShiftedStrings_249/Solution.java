/*
249. Group Shifted Strings
Medium

560

98

Add to List

Share
Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:

"abc" -> "bcd" -> ... -> "xyz"
Given a list of non-empty strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.

Example:

Input: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
Output: 
[
  ["abc","bcd","xyz"],
  ["az","ba"],
  ["acef"],
  ["a","z"]
]
*/

class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for(String s : strings)
        {
            int offset = s.charAt(0) - 'a';
            String key = "";

            for(int i = 0; i < s.length(); i++)
            {
                char c = (char)(s.charAt(i) - offset);
                if(c < 'a')
                    c += 26;
                
                key += c;
            }
            if(!map.containsKey(key))
            {
                List<String> temp = new ArrayList<>();
                map.put(key, temp);
            }   
            map.get(key).add(s);
        }

        for(String s : map.keySet())
        {
            result.add(map.get(s));
        }
        
        return result;
    }
}