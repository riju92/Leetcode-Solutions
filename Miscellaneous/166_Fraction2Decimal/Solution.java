/*
166. Fraction to Recurring Decimal
Medium

695

1546

Add to List

Share
Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

Example 1:

Input: numerator = 1, denominator = 2
Output: "0.5"
Example 2:

Input: numerator = 2, denominator = 1
Output: "2"
Example 3:

Input: numerator = 2, denominator = 3
Output: "0.(6)"
*/

class Solution 
{
    public String fractionToDecimal(int numerator, int denominator) 
    {
        if(numerator == 0) return "0";
        
        StringBuilder s = new StringBuilder();
        
        s.append(((numerator > 0) ^ (denominator > 0) ? "-" : ""));
        
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        
        // Integral part
        s.append(num / den);
        num %= den;
        if(num == 0)
        {
            return s.toString();
        }
        
        //fractional part
        HashMap<Long , Integer> map = new HashMap<Long , Integer>();
        s.append(".");
        map.put(num, s.length());
        
        while(num != 0)
        {
            num *= 10;
            s.append(num / den);
            num %= den;
            
            
            if(map.containsKey(num))
            {
                int i = map.get(num);
                s.insert(i , "(");
                s.append(")");
                break;
            }
            else
            {
                map.put(num , s.length());
            }
        }
        
        return s.toString();
        
    }
}