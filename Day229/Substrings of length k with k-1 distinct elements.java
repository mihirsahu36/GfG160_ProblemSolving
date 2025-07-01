/* Substrings of length k with k-1 distinct elements
Given a string s consisting only lowercase alphabets and an integer k.
Find the count of all substrings of length k which have exactly k-1 distinct characters.

Examples:

Input: s = "abcc", k = 2
Output: 1
Explaination: Possible substring of length k = 2 are,
ab : 2 distinct characters
bc : 2 distinct characters
cc : 1 distinct characters
Only one valid substring so, count is equal to 1.

Input: "aabab", k = 3
Output: 3
Explaination: Possible substring of length k = 3 are, 
aab : 2 distinct charcters
aba : 2 distinct characters
bab : 2 distinct characters
All these substring are valid so, the total count is equal to 3.

Constrains:

1 ≤ s.size() ≤ 10^5
2 ≤ k ≤ 27 */

class Solution {
    public int substrCount(String s, int k) {
        // code here
        int n = s.length();
        int []freq = new int[26];
        int distinct = 0;
        int res = 0;
        int i = 0, j = 0;
        
        while(j < n){
            if(freq[s.charAt(j) - 'a'] == 0){
                distinct++;
            }
            freq[s.charAt(j) - 'a']++;
            
            if(j - i + 1 > k){
                freq[s.charAt(i) - 'a']--;
                if(freq[s.charAt(i) - 'a'] == 0){
                    distinct--;
                }
                i++;
            }
            
            if(j - i + 1 == k){
                if(distinct == k - 1){
                    res++;
                }
            }
            
            j++;
        }
        
        return res;
    }
}
