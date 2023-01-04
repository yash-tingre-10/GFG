//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int v = sc.nextInt();
                    int m = sc.nextInt();
                    int coins[] = new int[m];
                    for(int i = 0;i<m;i++)
                        coins[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minCoins(coins, m, v));
                }
        }
}    
// } Driver Code Ends


class Solution{

    static int [][]dp;
	public int minCoins(int coins[], int n, int amount) 
	{ 
	
        dp = new int [n+1][amount +1];
        for(int i=0; i<=amount; i++)
        {
            dp[0][i]=Integer.MAX_VALUE -1 ;
        }
        for(int i=1; i<=n; i++)
        {
            dp[i][0]= 0; ;
        }
        for(int i=1; i<=amount; i++)
        {
          if(i%coins[0]==0)
            dp[1][i]=i/coins[0];
          else
            dp[1][i]=Integer.MAX_VALUE -1 ;
        }
        int ans = helper(coins, amount,n);
        if(ans==Integer.MAX_VALUE-1)
          return -1;
        return ans;
    }

    static int helper(int[] coins, int amount, int n)
    {
      
      for(int i=2; i<=n; i++){
        for(int j=1; j<=amount; j++){
          if(coins[i-1]<=j)
            dp[i][j]  = Math.min(dp[i][j-coins[i-1]] + 1, dp[i-1][j]);
          else
            dp[i][j] = dp[i-1][j];
        }
      }
      
      return dp[n][amount];
    }
}