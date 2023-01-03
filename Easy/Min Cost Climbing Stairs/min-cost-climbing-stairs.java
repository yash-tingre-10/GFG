//{ Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            
            int[] cost = new int[N];
            
            for(int i=0 ; i<N ; i++)
                cost[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.minCostClimbingStairs(cost,N));
        }
    }
}
// } Driver Code Ends


//Back-end complete function Template for Java

class Solution {
    static int [] dp;
    static int minCostClimbingStairs(int[] cost , int N) {
       int n = cost.length;
        dp = new int [n+1];
        Arrays.fill(dp, -1);
        return Math.min( helper(cost,n-1), helper(cost,n-2) );
    }

    // static int helper(int []cost, int n)
    // {
    //     if(n==0)
    //       return cost[0];

    //     if(n==1)
    //       return cost[1];
    //     if(dp[n]!=-1)
    //       return dp[n];
    //     return dp[n] = cost[n] + Math.min( helper(cost,n-1), helper(cost,n-2) );
    // }

    static int helper(int []cost, int n)
    {
        dp[0]=cost[0];
        dp[1]=cost[1];
        for(int i=2; i<=n; i++)
        {
          dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2] );
        }
        return dp[n];
    }
};