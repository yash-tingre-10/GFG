//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int sum = sc.nextInt();
            int N = sc.nextInt();
            int coins[] = new int[N];
            for (int i = 0; i < N; i++) coins[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.count(coins, N, sum));
        }
    }
}


// } Driver Code Ends


// User function Template for Java

class Solution {
    static long  [][]dp;
    public long count(int coins[], int n, int amount) {
        // code here.
        
        dp = new long [n+1][amount +1];
        for(int i=0; i<=amount; i++)
            dp[0][i] = 0;
        
        for(int i=0; i<=n; i++)
            dp[i][0] = 1;
            
        dp[0][0] = 1;
            return helper(coins, n , amount);
    }
    
    static long helper(int coins[], int n, int amount){
        
        for(int i=1; i<=n; i++)
        {
            for(int j=1; j<=amount; j++)
            {
                if(coins[i-1]<=j)
                {
                    dp[i][j] = (dp[i][j-coins[i-1]] + dp[i-1][j]);
                }
                else
                {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][amount];
    }
}