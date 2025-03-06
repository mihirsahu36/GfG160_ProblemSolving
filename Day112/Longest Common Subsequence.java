/*Longest Common Subsequence
Given two strings s1 and s2, return the length of their longest common subsequence (LCS). If there is no common subsequence, return 0.
A subsequence is a sequence that can be derived from the given string by deleting some or no elements without changing the order of the remaining elements. For example, "ABE" is a subsequence of "ABCDE".

Examples:

Input: s1 = "ABCDGH", s2 = "AEDFHR"
Output: 3
Explanation: The longest common subsequence of "ABCDGH" and "AEDFHR" is "ADH", which has a length of 3.

Input: s1 = "ABC", s2 = "AC"
Output: 2
Explanation: The longest common subsequence of "ABC" and "AC" is "AC", which has a length of 2.

Input: s1 = "XYZW", s2 = "XYWZ"
Output: 3
Explanation: The longest common subsequences of "XYZW" and "XYWZ" are "XYZ" and "XYW", both of length 3.

Constraints:

1<= s1.size(), s2.size() <=10^3
Both strings s1 and s2 contain only uppercase English letters.*/

// Approach 1 (Using bottom up)
class Solution {
    static int lcs(String s1, String s2) {
        // code here
        int m = s1.length();
        int n = s2.length();
        int [][]t = new int[m+1][n+1];
        
        for(int i=0;i<m+1;i++){
            for(int j=0;j<n+1;j++){
                if(i == 0 || j == 0){
                    t[i][j] = 0;
                }else if(s1.charAt(i-1) == s2.charAt(j-1)){
                    t[i][j] = 1 + t[i-1][j-1];
                }else{
                    t[i][j] = Math.max(t[i][j-1], t[i-1][j]);
                }
            }
        }
        
        return t[m][n];
    }
}

// Approach 2 (Using recursion + memoization)
class Solution {
    static int [][]t;
    
    static int solve(String s1, String s2, int m, int n){
        if(m == 0 || n == 0){
            return 0;
        }
        
        if(t[m][n] != -1){
            return t[m][n];
        }
        
        if(s1.charAt(m-1) == s2.charAt(n-1)){
            return t[m][n] =  1 + solve(s1, s2, m-1, n-1);
        }
        
        return t[m][n] = Math.max(solve(s1, s2, m, n-1), solve(s1, s2, m-1, n));
    }
    
    static int lcs(String s1, String s2) {
        // code here
        int m = s1.length();
        int n = s2.length();
        t = new int[m+1][n+1];
        
        for(int []row : t){
            Arrays.fill(row, -1);
        }
        
        return solve(s1, s2, m, n);
    }
}
