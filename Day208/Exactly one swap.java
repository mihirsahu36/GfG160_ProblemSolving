/*Exactly one swap
Given a string s, return the number of distinct strings that can be obtained by exactly one swap of two different indices (i < j).

Examples:

Input: s = "geek"
Output: 6
Explanation: After one swap, There are only 6 distinct strings possible.(i.e "egek","eegk","geek","geke","gkee" and "keeg") 

Input: s = "aaaa"
Output: 1
Explanation: Only one distinct string is possible after one swap(i.e "aaaa")

Constraints:

2 ≤ s.size() ≤ 10^4 */

// Approach 1
class Solution {
    int countStrings(String s) {
        // code here
        int n = s.length();
        int []map = new int[26];
        int res = 0;
        
        for(int i=0;i<n;i++){
            res += (i - map[s.charAt(i) - 'a']);
            map[s.charAt(i) - 'a']++;
        }
        
        for(int i=0;i<26;i++){
            if(map[i] > 1){
                res++;
                break;
            }
        }
        
        return res;
    }
}

// Approach 2
class Solution {
    int countStrings(String s) {
        // code here
        int n = s.length();
        int []freq = new int[26];
        
        for(char c : s.toCharArray()){
            freq[c - 'a']++;
        }
        
        long totalSwaps = (long)(n * (n - 1)) / 2;
        long duplicateSwaps = 0;
        for(int count : freq){
            if(count >= 2){
                duplicateSwaps += (long)(count * (count - 1)) / 2;
            }
        }
        
        long distinctSwaps = totalSwaps - duplicateSwaps;
        
        int uniqueChars = 0;
        for(int count : freq){
            if(count > 0){
                uniqueChars++;
            }
        }
        
        if(uniqueChars == 1){
            return 1;
        }
        
        if(duplicateSwaps > 0){
            return (int)(distinctSwaps + 1);
        }else{
            return (int)distinctSwaps;
        }
    }
}
