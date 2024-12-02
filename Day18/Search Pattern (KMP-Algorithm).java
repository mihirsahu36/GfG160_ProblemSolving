/*Search Pattern (KMP-Algorithm)
Given two strings, one is a text string txt and the other is a pattern string pat. The task is to print the indexes of all the occurrences of the pattern string in the text string. Use 0-based indexing while returning the indices. 
Note: Return an empty list in case of no occurrences of pattern.

Examples :

Input: txt = "abcab", pat = "ab"
Output: [0, 3]
Explanation: The string "ab" occurs twice in txt, one starts at index 0 and the other at index 3. 

Input: txt = "abesdu", pat = "edu"
Output: []
Explanation: There's no substring "edu" present in txt.

Input: txt = "aabaacaadaabaaba", pat = "aaba"
Output: [0, 9, 12]

Constraints:

1 ≤ txt.size() ≤ 10^6
1 ≤ pat.size() < txt.size()
Both the strings consist of lowercase English alphabets.*/

class Solution {
    ArrayList<Integer> search(String pat, String txt) {
        ArrayList<Integer> res = new ArrayList<>();
        int m = pat.length();
        int n = txt.length();
        int []lps = computeLPS(pat); // preprocess the pattern to create the LPS array
        int i = 0; // text pointer
        int j = 0; // pattern pointer
        
        while(i < n){
            if(j < m && pat.charAt(j) == txt.charAt(i)){ // character from text and pattern matched
                i++;
                j++;
            }
            if(j == m){ // complete pattern matched
                res.add(i - j);
                j = lps[j - 1];
            }else if(i < n && (j == 0 || pat.charAt(j) != txt.charAt(i))){ // mismatch after some matches
                if(j != 0){
                    j = lps[j - 1]; // used LPS to avoid unrequired comparisons
                }else{
                    i++; // move text pointer forward if no match
                }
            }
        }
        return res;
    }
    
    private int []computeLPS(String pattern){
        int m = pattern.length();
        int []lps = new int[m]; // longest prefix suffix
        int len = 0;
        lps[0] = 0; // first element has no similar prefix or suffix
        int i = 1;
        
        while(i<m){
            if(pattern.charAt(i) == pattern.charAt(len)){
                len++; // increase length of matching prefix suffix
                lps[i] = len;
                i++;
            }else{
                if(len != 0){
                    len = lps[len - 1]; // use previous LPS to check for shorter prefix
                }else{
                    lps[i] = 0; // no match so LPS value to 0
                    i++; // move to next character
                }
            }
        }
        return lps;
    }
}
