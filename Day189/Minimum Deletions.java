/*Minimum Deletions
Given a string s, write a program to delete the minimum number of characters from the string so that the resultant string is a palindrome, while maintaining the order of characters.

Examples:

Input: s = "aebcbda"
Output: 2
Explanation: Remove characters 'e' and 'd'.

Input: s = "geeksforgeeks"
Output: 8
Explanation: To make "geeksforgeeks" a palindrome, the longest palindromic subsequence is "eefee" (length 5). The minimum deletions are:
13 (length of s) - 5 = 8.

Constraints:

1 ≤ s.size() ≤ 10^3*/

class Solution {
    static int [][]t;
    
    static int solve(int i, int j, String s){
        if(i >= j){
            return 0;
        }
        
        if(t[i][j] != -1){
            return t[i][j];
        }
        
        if(s.charAt(i) == s.charAt(j)){
            return t[i][j] = solve(i + 1, j - 1, s);
        }
        
        return t[i][j] = 1 + Math.min(solve(i + 1, j, s), solve(i, j - 1, s));
    }
    
    static int minDeletions(String s) {
        // code here
        int n = s.length();
        t = new int[n][n];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                t[i][j] = -1;
            }
        }
        
        return solve(0, n - 1, s);
    }
}
