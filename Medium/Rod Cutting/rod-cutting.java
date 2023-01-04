//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.cutRod(arr, n));
        }
    }
}

// } Driver Code Ends


class Solution{
    static int [][]dp;
    public int cutRod(int price[], int n) {
        //code here
        int [] len = new int[n];
        for(int i=0; i<n; i++)
            len[i]= i+1;
            
        dp = new int[n+1][n+1];
        for(int [] temp : dp)
            Arrays.fill(temp, 0);
        return helper(len,price,n);
    }
    
    static int helper(int len[],int price[], int n)
    {
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(len[i-1]<=j)
                {
                    dp[i][j] = Math.max(price[i-1] + dp[i][j-len[i-1]], dp[i-1][j]);
                }
                else
                {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][n];
        
    }
};