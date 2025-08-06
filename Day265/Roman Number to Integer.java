/* Roman Number to Integer
Given a string s in Roman number format, your task is to convert it to an integer.
Various symbols and their values are given below.
Note: I = 1, V = 5, X = 10, L = 50, C = 100, D = 500, M = 1000

Examples:

Input: s = "IX"
Output: 9
Explanation: IX is a Roman symbol which represents 10 – 1 = 9.

Input: s = "XL"
Output: 40
Explanation: XL is a Roman symbol which represents 50 – 10 = 40.

Input: s = "MCMIV"
Output: 1904
Explanation: M is 1000, CM is 1000 – 100 = 900, and IV is 4. So we have total as 1000 + 900 + 4 = 1904.

Constraints:

1 ≤ roman number ≤ 3999
s[i] belongs to [I, V, X, L, C, D, M] */

class Solution {
    public int romanToDecimal(String s) {
        // code here
        int res = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        for(int i=0;i<s.length();i++){
            if(i + 1 < s.length() && map.get(s.charAt(i)) < map.get(s.charAt(i+1))){
                res += map.get(s.charAt(i+1)) - map.get(s.charAt(i));
                i++;
            }else{
                res += map.get(s.charAt(i));
            }
        }
        
        return res;
    }
}
