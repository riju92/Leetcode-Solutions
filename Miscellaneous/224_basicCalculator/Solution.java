/*
224. Basic Calculator
Hard

1572

138

Add to List

Share
Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

Example 1:

Input: "1 + 1"
Output: 2
Example 2:

Input: " 2-1 + 2 "
Output: 3
Example 3:

Input: "(1+(4+5+2)-3)+(6+8)"
Output: 23
*/



public class Solution {

    public int calculate(String s)
    {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int number = 0;
        int sign = 1;

        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if(Character.isDigit(c))
                number = number * 10 + (int)(c - '0');
            else if(c == '+')
            {
                result += number * sign;
                sign = 1;
                number = 0;
            }

            else if(c == '-')
            {
                result += number * sign;
                sign = -1;
                number = 0;
            }

            else if(c == '(')
            {
                stack.push(result);
                stack.push(sign);
                sign = 1;
                result = 0;
            }

            else if(c == ')')
            {
                result += number * sign;
                number = 0;
                //sign = 1;
                result *= stack.pop();
                result += stack.pop();
            }
        }

        if(number != 0)
            result += number * sign;

        return result;
    }
}

