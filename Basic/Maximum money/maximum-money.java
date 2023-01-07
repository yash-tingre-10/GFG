//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String St[] = read.readLine().split(" ");
            int N = Integer.parseInt(St[0]);
            int K = Integer.parseInt(St[1]);

            Solution ob = new Solution();
            System.out.println(ob.maximizeMoney(N,K));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int [] dp;
    static int maximizeMoney(int n , int K) {
        // code here
       dp = new int [n+1];
        Arrays.fill(dp, 0);
        int [] nums = new int[n];
        Arrays.fill(nums, K);
        dp[0] = nums[0];
        // return helper(nums, n-1);
        
        return helper(nums, n-1);
    }
    // Memoizations
//     static int helper(int [] arr, int n){
//         if(n<0)
//             return 0;
//         if(n==0)
//             return arr[0];
//         if(dp[n]!=-1)
//             return dp[n];
//         return dp[n] = Math.max(helper(arr, n-2) + arr[n],helper(arr,n-1) + 0);
        
//     }
    
    // Tabulation
     static int helper(int [] arr, int n){
        
         for(int i=1; i<=n; i++){
            if(i>1) dp[i] = Math.max(dp[i-1],dp[i-2]+arr[i]); 
            else dp[i] = Math.max(dp[i-1],arr[i]);
         }   
         return dp[n];
    }
};