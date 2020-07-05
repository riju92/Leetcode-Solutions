/*
Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

Example 1:

Input: "3+2*2"
Output: 7
Example 2:

Input: " 3/2 "
Output: 1
Example 3:

Input: " 3+5 / 2 "
Output: 5

*/

class Solution
{
	public int calculate(String s)
	{
		if(s == null || s.length() == 0) return 0;
		Character sign = '+';
		int sum = 0, result = 0;
		int length = s.length();
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i < length; i++)
		{
			if(Character.isDigit(s.charAt(i)))
			{
				sum = sum * 10 + s.charAt(i) - '0';
			}
			if((!Character.isDigit(s.charAt(i)) && ' ' != s.charAt(i)) || (i == length - 1))
			{
				if(sign == '+') stack.push(sum);
				if(sign == '-') stack.push(-sum);
				if(sign == '*')	stack.push(stack.pop() * sum);
				if(sign == '/') stack.push(stack.pop() / sum);
				sign = s.charAt(i);
				sum = 0;

			}
		}
		for(int i : stack) result += i;

		return result;
	}
}
