import java.util.*;
/*
You are given a 0-indexed string s and a dictionary of words dictionary. You have to break s into one or more non-overlapping substrings such that each substring is present in dictionary. There may be some extra characters in s which are not present in any of the substrings.

Return the minimum number of extra characters left over if you break up s optimally.

 

Example 1:

Input: s = "leetscode", dictionary = ["leet","code","leetcode"]
Output: 1
Explanation: We can break s in two substrings: "leet" from index 0 to 3 and "code" from index 5 to 8. There is only 1 unused character (at index 4), so we return 1.

Example 2:

Input: s = "sayhelloworld", dictionary = ["hello","world"]
Output: 3
Explanation: We can break s in two substrings: "hello" from index 3 to 7 and "world" from index 8 to 12. The characters at indices 0, 1, 2 are not used in any substring and thus are considered as extra characters. Hence, we return 3.
 

Constraints:

1 <= s.length <= 50
1 <= dictionary.length <= 50
1 <= dictionary[i].length <= 50
dictionary[i] and s consists of only lowercase English letters
dictionary contains distinct words
*/

class Solution {
    public int minExtraChar(String s, String[] dictionary) {

        // Converting dictionary array to HashSet, as all the words in dictionary are unique
        HashSet<String> hs=new HashSet<>();
        for(int i=0;i<dictionary.length;i++){
            hs.add(dictionary[i]);
        }
        int n=s.length();

        // Creating dp array (this array will contain values of repititive sub-problems) and filling all values with -1
        int dp[]=new int[n];
        Arrays.fill(dp,-1);

        // Recursion function that will return the answer
        return helper(s,hs,n,dp,0);
    }
    
    public int helper(String s, HashSet<String> hs, int n, int[] dp, int i){

        // if index reaches end, return 0
        if(i>=n)
            return 0;
        
        // if for this index value is already calculated, return dp[i]
        if(dp[i]!=-1)
            return dp[i];
        
        // curr variable will contain the string from 'i' to 'j'
        String curr="";

        // ans variable will contain the final answer
        int ans=s.length();
        
        // looping through the string
        // considering we have the string from 'i' to 'j' in the dictionary
        // we will send the rest of the string i.e. 'j+1' to 's.length()' for recursion
        for(int j=i;j<s.length();j++){
            curr+=s.charAt(j);

            // if curr is present in dictionary, then we will add 0 and send rest for recursion
            // if curr is not present in dictionary, then we will add curr.length() and send rest for recursion
            int count=(hs.contains(curr) ? 0 : curr.length()) + helper(s,hs,n,dp,j+1);

            // calculate the minimum ans we get through the loop
            ans=Math.min(ans,count);
        }
        
        // store the ans in dp[i] and return
        return dp[i]=ans;
    }
}

// Time Complexity -> O(n^2)
// Space Complexity -> O(n+s), where s is size of each string