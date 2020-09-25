import java.util.*;

/*
Given a string of lowercase English letters and the characters '#'(ASCII 35) and '!'(ASCII 33), determine the number of times a character will be escaped. 
A character will escape if:
1. It is a lowercase english letter
2. There is a ! character immediately before it
3. Both the lowercase English letter and the ! character lie between a starting point and ending # character

The string #ab!c#de!f needs to be escaped once at !c. The substring !f is not between # characters so it is not escaped.
*/

class Solution
{
    public int func(String s)
    {
        int result = 0;
        List<Character> l = new ArrayList<>();
        String[] s_arr = s.split("#");
        Character last = s.charAt(s.length() - 1);
        if(!last.equals('#'))
            s_arr = Arrays.copyOf(s_arr, s_arr.length - 1);
        // for(String g : s_arr)
        //     System.out.print(g + " ");
        for(String temp : s_arr)
        {
            for(int i = 0; i < temp.length(); i++)
            {
                
                if(i != temp.length() - 1 && temp.charAt(i) == '!' && Character.isLowerCase(temp.charAt(i + 1)))
                 {
                     result++;
                     l.add(temp.charAt(i + 1));
                 }

            }
        }

        System.out.println(l);

        return result;
    }

    public static void main(String[] args) {
        
        Solution obj = new Solution();

        System.out.println(obj.func("#ab!c#de!f#"));
    }
}