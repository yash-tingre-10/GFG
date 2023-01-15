//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                System.out.print(ans.get(i)+" ");
            }
            System.out.println();
                        
        }
	}
}


// } Driver Code Ends


class Solution {
    static ArrayList<String> ans;
    public List<String> find_permutation(String S) {
        // Code here
        ans = new ArrayList<String>();
        helper(S,"");
        Set<String> set = new HashSet<String>(ans);
        List<String> temp = new ArrayList<String>(set);
        Collections.sort(temp);
        return temp;
    }
    
    static void helper(String str, String op){
        
        if(str.length()==0)
        {
            ans.add(op);
            return;
        }
        
        for(int i=0; i<str.length(); i++){
            
            char ch = str.charAt(i);
            String before = str.substring(0,i);
            String after = str.substring(i+1);
            String add = before + after;
            
            helper(add,op+ch);
            
        }
    }
}