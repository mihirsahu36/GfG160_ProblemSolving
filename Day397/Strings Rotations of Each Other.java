/* Strings Rotations of Each Other
You are given two strings s1 and s2, of equal lengths. The task is to check if s2 is a rotated version of the string s1.
Note: A string is a rotation of another if it can be formed by moving characters from the start to the end (or vice versa) without rearranging them.

Examples :

Input: s1 = "abcd", s2 = "cdab"
Output: true
Explanation: After 2 right rotations, s1 will become equal to s2.

Input: s1 = "aab", s2 = "aba"
Output: true
Explanation: After 1 left rotation, s1 will become equal to s2.

Input: s1 = "abcd", s2 = "acbd"
Output: false
Explanation: Strings are not rotations of each other.

Constraints:

1 ≤ s1.size(), s2.size() ≤ 10^5
s1, s2 consists of lowercase English alphabets. */

class Solution {
    public boolean areRotations(String s1, String s2) {
        // code here
        int n = s1.length();
        if(n != s2.length()){
            return false;
        }
        return kmpSearch(s1+s1,s2);
    }

    private boolean kmpSearch(String text,String pat){
        int []lps=buildLPS(pat);
        int i = 0, j = 0;
        while(i < text.length()){
            if(text.charAt(i) == pat.charAt(j)){
                i++;
                j++;
                if(j == pat.length()){
                    return true;
                }
            }else{
                if(j > 0){
                    j = lps[j-1];
                }else{
                    i++;
                }
            }
        }
        return false;
    }

    private int []buildLPS(String pat){
        int n = pat.length();
        int []lps = new int[n];
        int len=0, i=1;
        while(i < n){
            if(pat.charAt(i) == pat.charAt(len)){
                lps[i++] = ++len;
            }else{
                if(len>0){
                    len=lps[len-1];
                    
                }else{
                    lps[i++]=0;
                }
            }
        }

        return lps;
    }
}
