/* Alice and Bob take turns playing a game, with Alice starting first.

Initially, there is a number N on the chalkboard.  On each player's turn, that player makes a move consisting of:

Choosing any x with 0 < x < N and N % x == 0.
Replacing the number N on the chalkboard with N - x.
Also, if a player cannot make a move, they lose the game.

Return True if and only if Alice wins the game, assuming both players play optimally.
*/

/* RECURSION */
class Solution {
    public boolean divisorGame(int N) 
    {
            int n=N;
            if (n <= 1)
                return false;
            for (int x=1; x<n; x++)
            {
                if(n % x ==0)
                {
                    if(!divisorGame(n - x))
                    {
                        return true;
                    }
                }
            }
            return false;
    }
}

/* DYNAMIC PROGRAMING */

class Solution {
    public boolean divisorGame(int N) 
    {
            
        return divisorGame_child(N, new Boolean[N+1]);
    }
    
        public boolean divisorGame_child(int N, Boolean[] memo)
        {
            int n = N;
            if (n <= 1)
                return false;
            if(memo[n] != null)
                return memo[n];
            for (int x = 1; x < n; x++)
            {
                if(n % x == 0)
                {
                    if(!divisorGame_child((n - x) , memo))
                    {
                        memo[n] = true;
                        return true;
                    }
                }
            }
            memo[n] = false;           
            return false;
        }
    
}

/* Bottom up approach */

    class Solution 
    {
    public boolean divisorGame(int N) 
    {
        boolean[] dp = new boolean[N + 1];        
        dp[0] = false;
        dp[1] = false;
        
        for(int i = 2; i < N + 1; i++)
        {
            for(int j = 1; j < i; j++)
            {
                if(i % j == 0 && dp[i - j] == false)
                {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[N];
    }
    
}



