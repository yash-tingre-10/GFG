//{ Driver Code Starts
import java.util.*;
import java.io.*;

class GFG
 {
	public static void main (String[] args)
	 {
	  
	  //taking input using Scanner class
	  Scanner sc = new Scanner(System.in);
	  
	  //taking count of testcases
	  int t = sc.nextInt();
	  while(t-- > 0){
	      
	      //taking count of houses
	      int n = sc.nextInt();
	      int arr[] = new int[n];
	      
	      //inserting money present in 
	      //each house in the array
	      for(int i = 0; i<n; ++i)
	           arr[i] = sc.nextInt();
  	      
  	      //calling method FindMaxSum() of class solve
  	      System.out.println(new Solution().FindMaxSum(arr, n));
	 }
   }
}
// } Driver Code Ends


class Solution
{
    static int [] dp;
    //Function to find the maximum money the thief can get.
    public int FindMaxSum(int nums[], int n)
    {
    dp = new int [n+1];
        Arrays.fill(dp, 0);
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
}