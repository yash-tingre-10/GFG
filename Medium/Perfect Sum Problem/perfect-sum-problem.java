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
                    int n = sc.nextInt();
                    int sum = sc.nextInt();
                    int arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                    arr[i] = sc.nextInt();
                    
                    Solution ob = new Solution();
                    System.out.println(ob.perfectSum(arr,n,sum));
                }
        }
}    
// } Driver Code Ends


class Solution{

    static int dp[][];
    static int mod = 1000000007;
	public int perfectSum(int arr[],int n, int sum) 
	{ 
	  dp = new int [n+1][sum+1];
	  
	  dp[0][0] = 1;
        for (int i = 1; i <= sum; i++)
            dp[0][i] = 0;
        for (int i = 1; i <= n; i++)
            dp[i][0] = 1;
    	   
	   return helper(arr,n,sum)% mod;
	}
	
	
	static int helper(int arr[],int n, int sum)
	{
	  
	   for(int i=1; i<=n; i++)
	   {
	      for(int j=0; j<=sum; j++)
	      {
	          if(arr[i-1]<=j)
	          {
	              dp[i][j] = (dp[i-1][j-arr[i-1]]  +  dp[i-1][j]) % mod;
	          }
	          else
	          {
	              dp[i][j] = dp[i-1][j] % mod;
	          }
	      }
	   }
	   return dp[n][sum] %mod;
	}
}