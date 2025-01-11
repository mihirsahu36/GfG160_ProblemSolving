/*Longest substring with distinct characters
Given a string s, find the length of the longest substring with all distinct characters. 

Examples:

Input: s = "geeksforgeeks"
Output: 7
Explanation: "eksforg" is the longest substring with all distinct characters.

Input: s = "aaa"
Output: 1
Explanation: "a" is the longest substring with all distinct characters.

Input: s = "abcdefabcbb"
Output: 6
Explanation: The longest substring with all distinct characters is "abcdef", which has a length of 6.

Constraints:

1<= s.size()<=3*10^4
All the characters are in lowercase.*/

class Solution {
    public int longestUniqueSubstr(String s) {
        // code here
        int []freq = new int[26];
        int i = 0, j = 0, res = 0;
        
        while(j < s.length()){
            int ch = s.charAt(j) - 'a';
            
            if(freq[ch] > 0){
                res = Math.max(res, j - i);
                while(i < j && s.charAt(i) != s.charAt(j)){
                    freq[s.charAt(i)-'a'] = 0;
                    i++;
                }
                i++;
            }else{
                freq[ch]++;
            }
            j++;
        }
        res = Math.max(res, j - i);
        return res;
    }
}
