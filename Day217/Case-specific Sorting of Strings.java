/*Case-specific Sorting of Strings
Difficulty: MediumAccuracy: 69.88%Submissions: 63K+Points: 4Average Time: 45m
Given a string s consisting of only uppercase and lowercase characters.
The task is to sort uppercase and lowercase letters separately such that
if the ith place in the original string had an Uppercase character then it
should not have a lowercase character after being sorted and vice versa.

Examples :

Input: s = "GEekS"
Output: EGekS
Explanation: Sorted form of given string with the same case of character will result in output as EGekS.

Input: s = "XWMSPQ"
Output: MPQSWX
Explanation: Since all characters are of the same case We can simply perform a sorting operation on the entire string.

Constraints:

1 ≤ s.length() ≤ 10^5 */

class Solution {
    public static String caseSort(String s) {
        // code here
        int n = s.length();
        int []lower = new int[26];
        int []upper = new int[26];
        
        for(char ch : s.toCharArray()){
            if(Character.isLowerCase(ch)){
                lower[ch - 'a']++;
            }else{
                upper[ch - 'A']++;
            }
        }
        
        StringBuilder res = new StringBuilder(n);
        int l = 0;
        int u = 0;
        
        for(char ch : s.toCharArray()){
            if(Character.isLowerCase(ch)){
                while(lower[l] == 0){
                    l++;
                }
                res.append((char)('a' + l));
                lower[l]--;
            }else{
                while(upper[u] == 0){
                    u++;
                }
                res.append((char)('A' + u));
                upper[u]--;
            }
        }
        
        return res.toString();
    }
}
