/* Wildcard Pattern Matching
Given two strings pat and txt which may be of different sizes,
You have to return true if the wildcard pattern i.e. pat, matches with txt else return false.
The wildcard pattern pat can include the characters '?' and '*'.
'?' – matches any single character.
'*' – matches any sequence of characters (including the empty sequence).
Note: The matching should cover the entire txt (not partial txt).

Examples:

Input: txt = "abcde", pat = "a?c*"
Output: true
Explanation: '?' matches with 'b' and '*' matches with "de".

Input: txt = "baaabab", pat = "a*ab"
Output: false
Explanation: The pattern starts with a, but the text starts with b, so the pattern does not match the text.

Input: txt = "abc", pat = "*"
Output: true
Explanation: '*' matches with whole text "abc".

Constraints:

1 ≤ txt.size(), pat.size() ≤ 100 */


class Solution {
    public boolean wildCard(String txt, String pat) {
        // code here
        int txtLen = txt.length();
        int patLen = pat.length();
        int txtIdx = 0;
        int patIdx = 0;
        int startIdx = -1;
        int matchIdx = 0;
        
        while(txtIdx < txtLen){
            if(patIdx < patLen && (pat.charAt(patIdx) == '?' || pat.charAt(patIdx) == txt.charAt(txtIdx))){
                txtIdx++;
                patIdx++;
            }else if(patIdx < patLen && pat.charAt(patIdx) == '*'){
                startIdx = patIdx;
                matchIdx = txtIdx;
                patIdx++;
            }else if(startIdx != -1){
                patIdx = startIdx + 1;
                matchIdx++;
                txtIdx = matchIdx;
            }else{
                return false;
            }
        }
        
        while(patIdx < patLen && pat.charAt(patIdx) == '*'){
            patIdx++;
        }
        
        return patIdx == patLen;
    }
}
