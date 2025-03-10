/*Edit Distance
Given two strings s1 and s2. Return the minimum number of operations required to convert s1 to s2.
The possible operations are permitted:
Insert a character at any position of the string.
Remove any character from the string.
Replace any character from the string with any other character.

Examples:

Input: s1 = "geek", s2 = "gesek"
Output: 1
Explanation: One operation is required, inserting 's' between two 'e' in s1.

Input: s1 = "gfg", s2 = "gfg"
Output: 0
Explanation: Both strings are same.

Input: s1 = "abcd", s2 = "bcfe"
Output: 3
Explanation: We can convert s1 into s2 by removing ‘a’, replacing ‘d’ with ‘f’ and inserting ‘e’ at the end. 

Constraints:

1 ≤ s1.length(), s2.length() ≤ 10^3
Both the strings are in lowercase.*/

class Solution {
    public int solve(String s1, String s2, int m, int n, int [][]t){
        if(m == 0 || n == 0){
            return m + n;
        }
        
        if(t[m][n] != -1){
            return t[m][n];
        }
        
        if(s1.charAt(m-1) == s2.charAt(n-1)){
            return t[m][n] = solve(s1, s2, m-1, n-1, t);
        }else{
            int insertC = 1 + solve(s1, s2, m, n-1, t);
            int deleteC = 1 + solve(s1, s2, m-1, n, t);
            int replaceC = 1 + solve(s1, s2, m-1, n-1, t);
            
            return t[m][n] = Math.min(Math.min(insertC, deleteC), replaceC);
        }
    }
    
    public int editDistance(String s1, String s2) {
        // Code here
        int m = s1.length();
        int n = s2.length();
        int [][]t = new int[m + 1][n + 1];
        
        for(int []row : t){
            Arrays.fill(row, -1);
        }
        
        return solve(s1, s2, m, n, t);
    }
}
