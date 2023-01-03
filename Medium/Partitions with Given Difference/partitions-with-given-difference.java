//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int d=sc.nextInt();
            
            int []arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            
            Solution obj=new Solution();
            int res=obj.countPartitions(n, d, arr);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

//Back-end complete function Template for Java

class Solution{
    static int [][] dp;
    static int mod = 1000000007;
    public int countPartitions(int n, int d, int nums[]){
        // code here
    int sum=0;
    int c0=0;
    for(int i=0;i<n;i++)
        {
            if(nums[i]==0) c0++;
            sum+=nums[i];
        }
         
    if(sum<d || (sum+d)%2!=0 || n==1)
        return 0;
    
	 int reqSum=(d+sum)/2;
	
	 // Initializing the matrix
    dp = new int [n + 1][reqSum + 1];
  // Initializing the first value of matrix
    dp[0][0] = 1;
    for (int i = 1; i <= reqSum; i++)
        dp[0][i] = 0;
    for (int i = 1; i <= n; i++)
        dp[i][0] = 1;
	 
	 
	 
	 return helper(nums,n,reqSum);
        
    }
    
    static int helper(int a[], int n, int sum)
    {
        for(int i=1; i<=n; i++)
        {
            for(int j=0; j<=sum; j++)
            {
                if(a[i-1]<=j)
                {
                    dp[i][j] = (dp[i-1][j-a[i-1]] + dp[i-1][j]) % mod ;
                }
                else
                {
                    dp[i][j] = dp[i-1][j] ;
                }
            }
        }
        return dp[n][sum];
    }
};




