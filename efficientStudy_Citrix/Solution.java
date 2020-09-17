import java.util.*;

class Solution
{
    public int maxLearning(int[] iv, int[] articles, int capacity)
    {
        int[][] dp = new int[iv.length + 1][capacity + 1];

        for(int i = 0; i < articles.length; i++)
            articles[i] *= 2;
        
        // for(int i : articles)
        //     System.out.print(i + " ");

        for(int i = 0; i < dp.length; i++)
        {
            for(int j = 0; j < dp[i].length; j++)
            {
                if(i == 0 || j == 0)
                    dp[i][j] = 0;
                
                else if(articles[i - 1] > j)
                    dp[i][j] = dp[i - 1][j];
                
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - articles[i - 1]] + iv[i - 1]);
            }
        }

        return dp[iv.length][capacity];
    }

    public static void main(String[] args) {
        
        int[] articles = {2,2,3,4};
        int[] iv = {2,4,4,5};

        Solution obj = new Solution();

        int result = obj.maxLearning(iv, articles, 15);

        System.out.println(result);
    }
}