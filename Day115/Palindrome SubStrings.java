/*Palindrome SubStrings
Given a string s, count all palindromic sub-strings present in the string. The length of the palindromic sub-string must be greater than or equal to 2. 

Examples

Input: s = "abaab"
Output: 3
Explanation: All palindromic substrings are : "aba" , "aa" , "baab".

Input: s = "aaa"
Output: 3
Explanation: All palindromic substrings are : "aa", "aa", "aaa".

Input: s = "abbaeae"
Output: 4
Explanation: All palindromic substrings are : "bb" , "abba" , "aea", "eae".

Constraints:

2 ≤ s.size() ≤ 10^3
string contains only lowercase english characters*/

class Solution {
    int [][]t;
    
    public boolean check(String s, int i, int j){
        if(i >= j){
            return true;
        }
        
        if(t[i][j] != -1){
            return t[i][j] == 1;
        }
        
        if(s.charAt(i) == s.charAt(j) && check(s, i + 1, j - 1)){
            t[i][j] = 1;
            return true;
        }
        
        t[i][j] = 0;
        return false;
    }
    public int countPS(String s) {
        // code here
        int n = s.length();
        t = new int[n][n];
        
        for(int []row : t){
            Arrays.fill(row, -1);
        }
        
        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(check(s, i, j)){
                    count++;
                }
            }
        }
        
        return count;
    }
}
