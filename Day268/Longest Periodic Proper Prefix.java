/* Longest Periodic Proper Prefix
Given a string s, find the length of longest periodic proper prefix of s. If no such prefix exists, return -1.
A periodic proper prefix is a non empty prefix of s (but not the whole string), such that repeating this prefix enough times produces a string that starts with s.

Examples:

Input: s = "aaaaaa"
Output: 5
Explanation: Repeating the proper prefix "aaaaa" forms "aaaaaaaaaa...", which contains "aaaaa" as a prefix. No longer proper prefix satisfies this.

Input: s = "abcab"
Output: 3
Explanation: Repeating the proper prefix "abc" forms "abcabc., which contains "abcab" as a prefix. No longer proper prefix satisfies this.

Input: s = "ababd"
Output: -1
Explanation: No proper prefix satisfying the given condition.

Constraints:

1 ≤ s.size() ≤ 10^5
s consists of lowercase English alphabets */

class Solution {
    int getLongestPrefix(String s) {
        // code here
        int n = s.length();
        int []z = new int[n];
        int left = 0, right = 0;
        int res = -1;
        
        for(int i=1;i<n;i++){
            if(i <= right){
                z[i] = Math.min(right - i + 1, z[i-left]);
            }
            while(i + z[i] < n && s.charAt(z[i]) == s.charAt(i + z[i])){
                z[i]++;
            }
            if(i + z[i] - 1 > right){
                left = i;
                right = i + z[i] - 1;
            }
            
            if(z[i] >= n - i){
                res = i;
            }
        }
        
        return res;
    }
}
