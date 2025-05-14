/*Substrings with same first and last characters
Given a string s consisting of lowercase characters, the task is to find the count of all substrings that start and end with the same character.

Examples:

Input: s = "abcab"
Output: 7
Explanation: There are 7 substrings where the first and last characters are the same: "a", "abca", "b", "bcab", "c", "a", and "b"

Input: s = "aba"
Output: 4
Explanation: There are 4 substrings where the first and last characters are the same: "a", "aba", "b", "a"

Constraints:

1 <= |s| <= 10^4
s contains lower case english alphabets*/

class Solution {
    public int countSubstring(String s) {
        // code here
        int n = s.length();
        int []freq = new int[26];
        
        for(int i=0;i<n;i++){
            freq[s.charAt(i) - 'a']++;
        }
        
        int count = 0;
        for(int i=0;i<26;i++){
            count += (freq[i] * (freq[i] + 1)) / 2;
        }
        
        return count;
    }
}
