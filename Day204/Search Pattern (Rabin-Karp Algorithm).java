/*Search Pattern (Rabin-Karp Algorithm)
Given two strings:
A text string in which you want to search.
A pattern string that you are looking for within the text.
Return all positions (1-based indexing) where the pattern occurs as a substring in the text.
If the pattern does not occur, return an empty list.
All characters in both strings are lowercase English letters (a to z).

Examples:

Input: text = "birthdayboy", pattern = "birth"
Output: [1]
Explanation: The string "birth" occurs at index 1 in text.

Input: text = "geeksforgeeks", pattern = "geek"
Output: [1, 9]
Explanation: The string "geek" occurs twice in text, one starts are index 1 and the other at index 9.

Constraints:

1<= text.size() <=5*10^5
1<= pattern.size() <= text.size()*/

class Solution {
    ArrayList<Integer> search(String pat, String txt) {
        // Code here
        ArrayList<Integer> res = new ArrayList<>();
        int n = txt.length();
        int m = pat.length();
        
        if(m > n){
            return res;
        }
        
        int base = 26;
        int MOD = 10000007;
        long patHash = 0, txtHash = 0, power = 1;
        
        for(int i=0;i<m-1;i++){
            power = (power * base) % MOD;
        }
        
        for(int i=0;i<m;i++){
            patHash = (base * patHash + pat.charAt(i)) % MOD;
            txtHash = (base * txtHash + txt.charAt(i)) % MOD;
        }
        
        for(int i=0;i<=n-m;i++){
            if(patHash == txtHash){
                if(txt.substring(i, i + m).equals(pat)){
                    res.add(i + 1);
                }
            }
            
            if(i < n - m){
                txtHash = (base * (txtHash - txt.charAt(i) * power) + txt.charAt(i + m)) % MOD;
                if(txtHash < 0){
                    txtHash = txtHash + MOD;
                }
            }
        }
        
        return res;
    }
}
