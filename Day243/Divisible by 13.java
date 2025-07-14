/* Divisible by 13
Given a number represented as a string s (which may be very large), check whether it is divisible by 13 or not.

Examples:

Input : s = "2911285"
Output : true
Explanation: 2911285 ÷ 13 = 223945, which is a whole number with no remainder.

Input : s = "27"
Output : false
Explanation: 27 / 13 ≈ 2.0769..., which is not a whole number (there is a remainder).

Constraints:

1 ≤  s.size()  ≤ 10^5 */

class Solution {
    public boolean divby13(String s) {
        // code here
        int mod = 0;
        for(int i=0;i<s.length();i++){
            int digit = s.charAt(i) - '0';
            mod = (mod * 10 + digit) % 13;
        }
        
        return mod == 0;
    }
}
