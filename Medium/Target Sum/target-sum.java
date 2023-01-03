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
            
            int[] A = new int[N];
            
            for(int i=0 ; i<N ; i++){
                A[i] = Integer.parseInt(S[i]);
            }
            int target = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.findTargetSumWays(A,N, target));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int [][] dp;
    static int mod = 1000000007;
    static int findTargetSumWays(int[] nums , int n, int d) {
        // code here
    int sum=0;
    int c0=0;
    for(int i=0;i<n;i++)
        {
            if(nums[i]==0) c0++;
            sum+=nums[i];
        }
         
    if(sum<d)
        return 0;
    if((sum+d)%2!=0)
        return 0;
    
	 int reqSum=(d+sum)/2;
	 if(c0>1) return (int)Math.pow(2,c0);
	 if(reqSum==0 ) return (int)Math.pow(2,n);
	 // Initializing the matrix
    dp = new int [n + 1][reqSum + 1];
  // Initializing the first value of matrix
    dp[0][0] = 1;
    for (int i = 1; i <= reqSum; i++)
        dp[0][i] = 0;
    for (int i = 1; i <= n; i++)
        dp[i][0] = 1;
	 
	 return helper(nums,n,reqSum) % mod;
        
    }
    
    static int helper(int a[], int n, int sum)
    {
        for(int i=1; i<=n; i++)
        {
            for(int j=1; j<=sum; j++)
            {
                if(a[i-1]<=j)
                {
                    dp[i][j] = (dp[i-1][j-a[i-1]] + dp[i-1][j]) % mod ;
                }
                else
                {
                    dp[i][j] = dp[i-1][j] % mod;
                }
            }
        }
        return dp[n][sum] % mod;
    }
};