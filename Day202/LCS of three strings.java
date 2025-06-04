/*LCS of three strings
Given three strings s1, s2, and s3 containing uppercase letters, lowercase letters, and digits, find the length of longest common sub-sequence in all three given strings.

Examples:

Input: s1 = "geeks", s2 = "geeksfor", s3 = "geeksforgeeks"
Output: 5
Explanation: "geeks"is the longest common subsequence with length 5.

Input: s1 = "abcd1e2", s2 = "bc12ea", s3 = "bd1ea"
Output: 3
Explanation:  Longest common subsequence is "b1e" i.e. length = 3.

Constraints:
1  ≤  s1.size(), s2.size(), s3.size()  ≤  100*/

class Solution {
    int solve(String s1, String s2, String s3, int i, int j, int k, int [][][]t){
        if(i == 0 || j == 0 || k == 0){
            return 0;
        }
        
        if(t[i][j][k] != -1){
            return t[i][j][k];
        }
        
        if(s1.charAt(i-1) == s2.charAt(j-1) && s2.charAt(j-1) == s3.charAt(k-1)){
            return t[i][j][k] = 1 + solve(s1, s2, s3, i - 1, j - 1, k - 1, t);
        }
        
        return t[i][j][k] = Math.max(
            Math.max(solve(s1, s2, s3, i - 1, j, k, t), solve(s1, s2, s3, i, j - 1, k, t)),
            solve(s1, s2, s3, i, j, k - 1, t));
    }
    
    int lcsOf3(String s1, String s2, String s3) {
        // code here
        int n1 = s1.length();
        int n2 = s2.length();
        int n3 = s3.length();
        int [][][]t = new int[n1 + 1][n2 + 1][n3 + 1];
        
        for(int i=0;i<=n1;i++){
            for(int j=0;j<=n2;j++){
                for(int k=0;k<=n3;k++){
                    t[i][j][k] = -1;
                }
            }
        }
        
        return solve(s1, s2, s3, n1, n2, n3, t);
    }
}
