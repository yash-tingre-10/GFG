//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());

            long ans = new Solution().countStrings(n);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int mod = 1000000007;
    long countStrings(int n) {
        // code here
     return helper(n);
        
    }
    
    static long helper(int n){
        long [] zcount = new long[n+1];
        long [] ocount = new long[n+1];
        zcount[1] = 1;
        ocount[1] = 1;
        for(int i=2; i<=n; i++){
            ocount[i] = (zcount[i-1] + ocount[i-1]) % mod;
            zcount[i] = ocount[i-1];
            
        }
        return (zcount[n]+ocount[n]) %mod;
    }
}