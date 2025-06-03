/*Substrings with K Distinct
Given a string consisting of lowercase characters and an integer k, the task is to count all possible substrings (not necessarily distinct) that have exactly k distinct characters. 

Examples :

Input: s = "abc", k = 2
Output: 2
Explanation: Possible substrings are ["ab", "bc"]

Input: s = "aba", k = 2
Output: 3
Explanation: Possible substrings are ["ab", "ba", "aba"]

Input: s = "aa", k = 1
Output: 3
Explanation: Possible substrings are ["a", "a", "aa"]

Constraints:

1 ≤ s.size() ≤ 10^6
1 ≤ k ≤ 26*/

class Solution {
    int countAtMostK(String s, int k){
        int n = s.length();
        int []freq = new int[26];
        int i = 0, j = 0;
        int res = 0;
        int distinctCount = 0;
        
        while(j < n){
            if(freq[s.charAt(j) - 'a'] == 0){
                distinctCount++;
            }
            freq[s.charAt(j) - 'a']++;
            
            while(distinctCount > k){
                freq[s.charAt(i) - 'a']--;
                if(freq[s.charAt(i) - 'a'] == 0){
                    distinctCount--;
                }
                i++;
            }
            
            res += j - i + 1;
            j++;
        }
        
        return res;
    }
    
    int countSubstr(String s, int k) {
        // your code here
        return countAtMostK(s, k) - countAtMostK(s, k - 1);
    }
}
