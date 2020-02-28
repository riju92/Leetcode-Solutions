/**
 * Given an array of non negative numbers and a total, is there subset of numbers in this array which adds up
 * to given total.
 */

 class Subset_sum
 {

    public boolean isSubset(int[] input, int sum)
    {
        boolean[][] dp = new boolean[input.length + 1][sum + 1];
        dp[0][0] = true;
        
        for(int i = 0; i < input.length + 1; i++) /* initialize the first column with 0 as the sum in this case is 0 */
        {
        dp[i][0] = true;
        }

        for(int i = 1; i < input.length + 1; i++)
        {
            for(int j = 1; j < sum + 1; j++)
            {
                if(j < input[i -1])
                {
                    dp[i][j] = dp[i - 1][j]; /* if your input value is less than the sum(j) then copy the previous row values upto j*/
                }
                else
                {
                    dp[i][j] = dp[i -1][j] || dp[i - 1][j - input[i - 1]]; /* here we check if the upper value is true or else we 
                    check if the value of [j - input[i - 1]] which is the remaining part of the sack is true
                    */
                }
            }
        }
        return dp[input.length][sum];
    }

    public static void main(String[] args)
    {
        Subset_sum s = new Subset_sum();
    int[] arr = {2,3,7,8};
    System.out.println(s.isSubset(arr,11));

    }
 }