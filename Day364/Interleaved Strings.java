/* Interleaved Strings
Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.
Interleaving of two strings s1 and s2 is a way to mix their characters to form a new string s3,
while maintaining the relative order of characters from s1 and s2. Conditions for interleaving:
Characters from s1 must appear in the same order in s3 as they are in s1.
Characters from s2 must appear in the same order in s3 as they are in s2.
The length of s3 must be equal to the combined length of s1 and s2.

Examples :

Input: s1 = "AAB", s2 = "AAC", s3 = "AAAABC"
Output: true
Explanation: The string "AAAABC" has all characters of the other two strings and in the same order.

Input: s1 = "AB", s2 = "C", s3 = "ACB"
Output: true
Explanation: s3 has all characters of s1 and s2 and retains order of characters of s1.

Input: s1 = "YX", s2 = "X", s3 = "XXY"
Output: false
Explanation: "XXY " is not interleaved of "YX" and "X". The strings that can be formed are YXX and XYX

Constraints:

1 ≤ s1.length, s2.length ≤ 300
1 ≤ s3.length ≤ 600 */

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // code here
        int n = s1.length();
        int m = s2.length();
        if(n + m != s3.length()){
            return false;
        }
        
        boolean [][]dp = new boolean[n+1][m+1];
        dp[0][0] = true;
        
        for(int i=1;i<=n;i++){
            dp[i][0] = dp[i-1][0] && s1.charAt(i-1) == s3.charAt(i-1);
        }
        
        for(int j=1;j<=m;j++){
            dp[0][j] = dp[0][j-1] && s2.charAt(j-1) == s3.charAt(j-1);
        }
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                char c = s3.charAt(i+j-1);
                dp[i][j] = (dp[i-1][j] && s1.charAt(i-1) == c) || (dp[i][j-1] && s2.charAt(j-1) == c);
            }
        }
        
        return dp[n][m];
    }
}
