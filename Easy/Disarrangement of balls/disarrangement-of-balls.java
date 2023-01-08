//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.disarrange(N));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static long  [] dp;
    static int mod  =  1000000007;
    static long disarrange(int N){

        if(N==0 || N==1)return 0;
        if(N==2)return 1;
        
        
        dp = new long [N+1];
        dp[1] = 0;
        dp[2] = 1;
        return helper(N);
    }
    
    static long helper(int N){
        for(int i=3; i<=N; i++){
            dp[i] = (i-1)*(dp[i-1]+dp[i-2]) % mod;
        }
        return dp[N];
    }
    
    
        
}