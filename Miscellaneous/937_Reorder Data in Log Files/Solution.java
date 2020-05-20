/*
937. Reorder Data in Log Files
Easy

518

1603

Add to List

Share
You have an array of logs.  Each log is a space delimited string of words.

For each log, the first word in each log is an alphanumeric identifier.  Then, either:

Each word after the identifier will consist only of lowercase letters, or;
Each word after the identifier will consist only of digits.
We will call these two varieties of logs letter-logs and digit-logs.  It is guaranteed that each log has at least one word after its identifier.

Reorder the logs so that all of the letter-logs come before any digit-log.  The letter-logs are ordered lexicographically ignoring identifier, with the identifier used in case of ties.  The digit-logs should be put in their original order.

Return the final order of the logs.

 

Example 1:

Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
*/

class Solution {
    public String[] reorderLogFiles(String[] logs) 
    {
        Comparator<String> newComp = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2)
            {
                int s1_first_space = s1.indexOf(' ');
                int s2_first_space = s2.indexOf(' ');
                
                int s1_first_char = s1.charAt(s1_first_space + 1);
                int s2_first_char = s2.charAt(s2_first_space + 1);
                
                if(s1_first_char <= '9')
                {
                    if(s2_first_char <= '9') return 0;
                    return 1;
                }
                if(s2_first_char <= '9') return -1;
                
                int compResult = s1.substring(s1_first_space + 1).compareTo(s2.substring(s2_first_space + 1));
                if(compResult == 0) return s1.substring(0, s1_first_space + 1).compareTo(s2.substring(0, s2_first_space + 1));
                return compResult;
            }
            
        }; 
        Arrays.sort(logs, newComp);
        return logs;
    }
}