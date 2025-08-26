/* Check if a String is Subsequence of Other
Given two strings s1 and s2. You have to check that s1 is a subsequence of s2 or not.
Note: A subsequence is a sequence that can be derived from another sequence by deleting some elements without changing the order of the remaining elements.

Examples:

Input: s1 = "AXY", s2 = "YADXCP"
Output: false
Explanation: s1 is not a subsequence of s2 as 'Y' appears before 'A'.

Input: s1 = "gksrek", s2 = "geeksforgeeks"
Output: true
Explanation: If we combine the bold character of "geeksforgeeks", it equals to s1. So s1 is a subsequence of s2. 

Constraints:

1 ≤ s1.size(), s2.size() ≤ 10^6 */

class Solution {
    public boolean isSubSeq(String s1, String s2) {
        // code here
        int n = s1.length();
        int m = s2.length();
        int i = 0, j = 0;
        
        while(i < n && j < m){
            if(s1.charAt(i) == s2.charAt(j)){
                i++;
            }
            j++;
        }
        
        return i == n;
    }
};
