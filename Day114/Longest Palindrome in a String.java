/*Longest Palindrome in a String
Given a string s, your task is to find the longest palindromic substring within s.
A substring is a contiguous sequence of characters within a string, defined as s[i...j] where 0 ≤ i ≤ j < len(s).
A palindrome is a string that reads the same forward and backward. More formally, s is a palindrome if reverse(s) == s.
Note: If there are multiple palindromic substrings with the same length, return the first occurrence of the longest palindromic substring from left to right.

Examples :

Input: s = “forgeeksskeegfor” 
Output: “geeksskeeg”
Explanation: There are several possible palindromic substrings like “kssk”, “ss”, “eeksskee” etc. But the substring “geeksskeeg” is the longest among all.

Input: s = “Geeks” 
Output: “ee”
Explanation: "ee" is the longest palindromic substring of "Geeks". 

Input: s = “abc” 
Output: “a”
Explanation: "a", "b" and "c" are longest palindromic substrings of same length. So, the first occurrence is returned.

Constraints:

1 ≤ s.size() ≤ 10^3
s consist of only lowercase English letters.*/

class Solution {
    static int [][]t;
    
    static String longestPalindrome(String s) {
        // code here
        int n = s.length();
        int maxLen = 0;
        int start = 0;
        t = new int[n][n];
        
        for (int[] row : t) {
            Arrays.fill(row, -1);
        }
        
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(solve(s, i, j) && j - i + 1 > maxLen){
                    start = i;
                    maxLen = j - i + 1;
                }
            }
        }
        
        return s.substring(start, start + maxLen);
    }
    
    static boolean solve(String s, int i, int j){
        if(i >= j){
            return true;
        }
        
        if(t[i][j] != -1){
            return t[i][j] == 1;
        }
        
        if(s.charAt(i) == s.charAt(j) && solve(s, i+1, j-1)){
            t[i][j] = 1;
        }else{
            t[i][j] = 0;
        }
        
        return t[i][j] == 1;
    }
}
