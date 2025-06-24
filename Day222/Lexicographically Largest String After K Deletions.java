/*Lexicographically Largest String After K Deletions
Given a string s consisting of lowercase English letters and an integer k, your task is to remove exactly k characters from the string.
The resulting string must be the largest possible in lexicographical  order, while maintain the relative order of the remaining characters.

Examples:
Input: s = "ritz", k = 2
Output: tz 
Explaination: By removing two characters in all possible ways, we get: "ri", "rt", "rz", "it", "iz", and "tz". Among these, "tz" is lexicographically largest string.

Input: s = "zebra", k = 3
Output: zr 
Explaination: Removing "e", "b", and "a" results in "zr", which is lexicographically largest string.

Constraints:

1 ≤ s.size() ≤ 10^5
0  ≤  k < s.size()*/

class Solution {
    public static String maxSubseq(String s, int k) {
        // code here
        int n = s.length();
        int removeCount = k;
        StringBuilder res = new StringBuilder();
        
        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            
            while(res.length() > 0 && removeCount > 0 && c > res.charAt(res.length() - 1)){
                res.deleteCharAt(res.length() - 1);
                removeCount--;
            }
            
            res.append(c);
        }
        
        res.setLength(n - k);
        return res.toString();
    }
}
