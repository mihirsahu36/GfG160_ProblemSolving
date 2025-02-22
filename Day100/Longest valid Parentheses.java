/*Longest valid Parentheses
Given a string s consisting of opening and closing parenthesis '(' and ')'. Find the length of the longest valid parenthesis substring.

A parenthesis string is valid if:
For every opening parenthesis, there is a closing parenthesis.
The closing parenthesis must be after its opening parenthesis.

Examples :

Input: s = "((()"
Output: 2
Explanation: The longest valid parenthesis substring is "()".

Input: s = ")()())"
Output: 4
Explanation: The longest valid parenthesis substring is "()()".

Input: s = "())()"
Output: 2
Explanation: The longest valid parenthesis substring is "()".

Constraints:

1 ≤ s.size() ≤ 10^6  
s consists of '(' and ')' only*/

class Solution {
    static int maxLength(String s) {
        // code here
        Stack<Integer> stack = new Stack<>();
        
        stack.push(-1);
        
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == ')' && stack.size() > 1 && s.charAt(stack.peek()) == '('){
                stack.pop();
            }else{
                stack.push(i);
            }
        }
        
        int lim = s.length(), res = 0;
        while(!stack.isEmpty()){
            int p = stack.pop();
            res = Math.max(res, lim - p -1);
            lim = p;
        }
        return res;
    }
}
