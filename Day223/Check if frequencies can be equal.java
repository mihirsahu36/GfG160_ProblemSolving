/*Check if frequencies can be equal
Given a string s consisting only lowercase alphabetic characters,
check whether it is possible to remove at most one character such that the  frequency of each distinct character in the string becomes same.
Return true if it is possible; otherwise, return false.

Examples:

Input: s = "xyyz"
Output: true 
Explanation: Removing one 'y' will make frequency of each distinct character to be 1.

Input: s = "xyyzz"
Output: true
Explanation: Removing one 'x' will make frequency of each distinct character to be 2.

Input: s = "xxxxyyzz"
Output: false
Explanation: Frequency can not be made same by removing at most one character.

Constraints:

1 ≤ s.size() ≤ 10^5 */

class Solution {
    boolean sameFreq(String s) {
        // code here
        int []freq = new int[26];
        
        for(char ch : s.toCharArray()){
            freq[ch - 'a']++;
        }
        
        int maxFreqVal = Integer.MIN_VALUE;
        int maxFreqCount = 0;
        int minFreqVal = Integer.MAX_VALUE;
        int minFreqCount = 0;
        
        for(int f : freq){
            if(f == 0){
                continue;
            }
            
            if(f == maxFreqVal){
                maxFreqCount++;
            }
            
            if(f == minFreqVal){
                minFreqCount++;
            }
            
            if(f > maxFreqVal){
                maxFreqVal = f;
                maxFreqCount = 1;
            }
            
            if(f < minFreqVal){
                minFreqVal = f;
                minFreqCount = 1;
            }
        }
        
        if((maxFreqVal - minFreqVal) == 0){
                return true;
            }else if((maxFreqVal - minFreqVal) == 1 && (maxFreqCount == 1 || (minFreqCount == 1 && minFreqVal == 1))){
                return true;
            }
        
        return false;
    }
}
