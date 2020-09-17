/*
John has a fascination with numbers. He likes numbers that have their digits in increasing order like 149, 468, 789, etc. He does not like numbers that don't follow this rule like 543, 664, 299, etc.

Given a number N as input, find the largest number less than or equal to N which will appeal to John's liking.

Input

An integer N which is less than 1,000,000.

Output

An integer less than or equal to N, which appeals to John's peculiar rules.

For example:

If the input number is 1234 then this number already has its digits in increasing order, and hence, the output would be the same number i.e. 1234.

If the input number is 998 then this number doesn’t have its digits in increasing order and we will decrement this number by 1 in each iteration till we reach the number 789 which follows the desired order.
*/

class SAPSVNT_1
{
    public boolean isValid(int n)
    {
        int prev = 10;
        while(n != 0)
        {
            //System.out.println("Inside while");
            int rem = n % 10;
            n = n / 10;
            //System.out.println("Rem: " + rem + "Prev: " + prev);
            if(rem >= prev)
                return false;
            
            prev = rem;
        }
        return true;
    }
    public static void main(String[] args) {
        
        SAPSVNT_1 obj = new SAPSVNT_1();
        int result = 0;
        int input = 654044082;
        
        for(int i = input; i >= 0; i--)
        {
            if(obj.isValid(i))
            {
                result = i;
                break;
            }
        }

        System.out.println(result);
    }
}