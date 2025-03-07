/*Longest Palindromic Subsequence
Given a string s, return the length of the longest palindromic subsequence.
A subsequence is a sequence that can be derived from the given sequence by deleting some or no elements without changing the order of the remaining elements.
A palindromic sequence is a sequence that reads the same forward and backward.

Examples:

Input: s = "bbabcbcab"
Output: 7
Explanation: Subsequence "babcbab" is the longest subsequence which is also a palindrome.
Input: s = "abcd"
Output: 1
Explanation: "a", "b", "c" and "d" are palindromic and all have a length 1.

Input: s = "agbdba"
Output: 5
Explanation: The longest palindromic subsequence is "abdba", which has a length of 5.
The characters in this subsequence are taken from the original string "agbdba", and they maintain the order of the string while forming a palindrome.

Constraints:

1 ≤ s.size() ≤ 1000
The string contains only lowercase letters.*/

class Solution {
    int t[][];
    
    public int solve(String s, String rev, int i, int j){
        if(i < 0 || j < 0){
            return 0;
        }
        
        if(t[i][j] != -1){
            return t[i][j];
        }
        
        if(s.charAt(i) == rev.charAt(j)){
            t[i][j] = 1 + solve(s, rev, i-1, j-1);
        }else{
            t[i][j] = Math.max(solve(s, rev, i-1, j), solve(s, rev, i, j-1));
        }
        
        return t[i][j];
    }
    
    public int longestPalinSubseq(String s) {
        // code here
        int n = s.length();
        t = new int[n][n];
        
        for(int []row : t){
            Arrays.fill(row, -1);
        }
        
        StringBuilder sb = new StringBuilder(s);
        String rev = sb.reverse().toString();
        
        return solve(s, rev, n-1, n-1);
    }
}
