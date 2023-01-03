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
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int [][] dp;
	public int minDifference(int arr[], int n) 
	{ 
	    int sum = 0;
	    for(int i=0; i<n; i++)
	        sum+=arr[i];
	  dp = new int[n+1][sum+1];
	  
	for(int [] temp : dp)
	    Arrays.fill(temp, 0);
	  
      int ans = helper(arr,n,sum/2);
	  ans = sum-2*ans;
	  
	  return ans;
	}
	
// 	static int helper(int [] arr, int n, int sum)
//     {
//         if(n==0 || sum==0)
//             return 0;
        
//         if(dp[n][sum]!=-1)
//             return dp[n][sum];
//         if(arr[n-1]<=sum)
//         {
//         return dp[n][sum]= Math.max(arr[n-1] + helper(arr,n-1,sum-arr[n-1]), helper(arr,n-1,sum));
//         }
//         else
//         {
//             return dp[n][sum] = helper(arr,n-1,sum);
//         }
//     }

// Tabulation 

    static int helper(int [] arr, int n, int sum)
    {
        for(int i=1; i<=n; i++)
        {
            for(int j=1; j<=sum; j++)
            {
                if(arr[i-1]<=j)
                {
                    dp[i][j] = Math.max(arr[i-1] + dp[i-1][j-arr[i-1]], dp[i-1][j]);
                }
                else
                {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }

}
