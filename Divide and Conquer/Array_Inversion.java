class Solution 
{
    public boolean checkPossibility(int[] nums)  
    {
        int count = 0;
        for (int i = 1 ; i < nums.length; i++)
            {
                if (nums[i-1] < nums[i])
                {
                   count = count + 1;
                }
                
            }
        if(count <= 1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }    
}
