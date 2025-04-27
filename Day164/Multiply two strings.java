/*Multiply two strings
Given two numbers as strings s1 and s2. Calculate their Product.
Note: The numbers can be negative and You are not allowed to use any built-in function or convert the strings to integers.
There can be zeros in the begining of the numbers. You don't need to specify '+' sign in the begining of positive numbers.

Examples:

Input: s1 = "0033", s2 = "2"
Output: "66"
Explanation: 33 * 2 = 66

Input: s1 = "11", s2 = "23"
Output: "253"
Explanation: 11 * 23  = 253

Input: s1 = "123", s2 = "0"
Output: "0"
Explanation: Anything multiplied by 0 is equal to 0.

Constraints:

1 ≤ s1.size() ≤ 10^3
1 ≤ s2.size() ≤ 10^3*/

class Solution {
    public String multiplyStrings(String s1, String s2) {
        // code here.
        boolean isNeg = false;
        if(s1.charAt(0) == '-'){
            isNeg = !isNeg;
            s1 = s1.substring(1);
        }
        if(s2.charAt(0) == '-'){
            isNeg = !isNeg;
            s2 = s2.substring(1);
        }
        
        s1 = removeLeadZeros(s1);
        s2 = removeLeadZeros(s2);
        
        if(s1.equals("0") || s2.equals("0")){
            return "0";
        }
        
        int n = s1.length();
        int m = s2.length();
        int []res = new int[n + m];
        
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                int mul = (s1.charAt(i) - '0') * (s2.charAt(j) - '0');
                int sum = mul + res[i + j + 1];

                res[i + j] += sum / 10;
                res[i + j + 1] = sum % 10;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        int i = 0;
        
        while(i < res.length && res[i] == 0){
            i++;
        }
        
        while(i < res.length){
            sb.append(res[i++]);
        }
        
        return isNeg ? "-" + sb.toString() : sb.toString();
    }
    
    private String removeLeadZeros(String s){
        int i = 0;
        
        while(i < s.length() && s.charAt(i) == '0'){
            i++;
        }
        
        return i == s.length() ? "0" : s.substring(i);
    }
}
