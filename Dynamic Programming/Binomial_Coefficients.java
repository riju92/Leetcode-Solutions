class Binomial_Coefficients
{
    public static int Solution(int n, int k)
    {
        int[][] b_coeff = new int[n + 1][k + 1];
        
        for(int i = 0; i <= n; i++)
        {
            for(int j = 0; j<= Math.min(i,k); j++)
            {
                    if (j == 0 || j == i)
                    {
                        b_coeff[i][j] = 1; 
                    }
                    else
                    {
                            b_coeff[i][j] = b_coeff[i - 1][j - 1] + b_coeff[i - 1][j]; 
                    }
            }
        }
        return b_coeff[n][k];
    }

    public static void main (String[] args)
    {
            System.out.println(Solution(5,2));
    }
}