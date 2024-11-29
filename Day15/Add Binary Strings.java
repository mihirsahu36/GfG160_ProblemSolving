/*Add Binary Strings
Given two binary strings s1 and s2 consisting of only 0s and 1s. Find the resultant string after adding the two Binary Strings.
Note: The input strings may contain leading zeros but the output string should not have any leading zeros.

Input: s1 = "1101", s2 = "111"
Output: 10100
Explanation:
 1101
+ 111
10100

Input: s1 = "00100", s2 = "010"
Output: 110
Explanation: 
  100
+  10
  110

Constraints:

1 ≤s1.size(), s2.size()≤ 10^6*/

class Solution {
    public String addBinary(String s1, String s2) {
        // code here
        int n1 = s1.length() - 1;
        int n2 = s2.length() - 1;
        int carry = 0, base = 2;
        
        StringBuilder sb = new StringBuilder();
        
        while(n1 >= 0 || n2 >= 0 || carry > 0){
            int d1 = 0, d2 = 0, sum;
            
            if(n1 >= 0){
                d1 = s1.charAt(n1--) - '0';
            }
            if(n2 >= 0){
                d2 = s2.charAt(n2--) - '0';
            }
            sum = d1 + d2 + carry;
            
            carry = sum / 2;
            
            sb.append(sum % 2);
        }
        String res = sb.reverse().toString();
        int i = 0;
        
        while (i < res.length() - 1 && res.charAt(i) == '0') {
            i++;
        }
        return res.substring(i);
    }
}
