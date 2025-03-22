/*Total Decoding Messages
A message containing letters A-Z is being encoded to numbers using the following mapping:
'A' -> 1
'B' -> 2
...
'Z' -> 26
You are given a string digits. You have to determine the total number of ways that message can be decoded.

Examples:

Input: digits = "123"
Output: 3
Explanation: "123" can be decoded as "ABC"(1, 2, 3), "LC"(12, 3) and "AW"(1, 23).

Input: digits = "90"
Output: 0
Explanation: "90" cannot be decoded, as it's an invalid string and we cannot decode '0'.

Input: digits = "05"
Output: 0
Explanation: "05" cannot be mapped to "E" because of the leading zero ("5" is different from "05"), the string is not a valid encoding message.

Constraints:

1 ≤ digits.size() ≤ 10^3*/

class Solution {
    public int solve(String digits, int i, int n, int []t){
        if(i == n){
            return 1;
        }
        
        if(digits.charAt(i) == '0'){
            return 0;
        }
        
        if(t[i] != -1){
            return t[i];
        }
        
        int res = solve(digits, i + 1, n, t);
        
        if(i + 1 < n){
            if(digits.charAt(i) == '1' || (digits.charAt(i) == '2' && digits.charAt(i+1) <= '6')){
                res += solve(digits, i + 2, n, t);
            }
        }
        
        return t[i] = res;
    }
    
    public int countWays(String digits) {
        // code here
        int n = digits.length();
        int []t = new int[n];
        Arrays.fill(t, -1);
        
        return solve(digits, 0, n, t);
    }
}
