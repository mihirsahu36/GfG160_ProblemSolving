/* Decode the string
Given an encoded string s, decode it by expanding the pattern k[substring],
where the substring inside brackets is written k times. k is guaranteed to be a positive integer,
and encodedString contains only lowercase english alphabets. Return the final decoded string.
Note: The test cases are generated so that the length of the output string will never exceed 105 .

Examples:

Input: s = "3[b2[ca]]"
Output: "bcacabcacabcaca"
Explanation:
Inner substring “2[ca]” breakdown into “caca”.
Now, new string becomes “3[bcaca]”
Similarly “3[bcaca]” becomes “bcacabcacabcaca” which is final result.

Input: s = "3[ab]"
Output: "ababab"
Explanation: The substring "ab" is repeated 3 times giving "ababab".

Constraints:

1 ≤ |s| ≤ 10^5 
1 ≤ k ≤ 100 */

class Solution {
    static String decodeString(String s) {
        // code here
        Deque<Integer> countStack = new ArrayDeque<>();
        Deque<StringBuilder> strStack = new ArrayDeque<>();
        StringBuilder curr = new StringBuilder();
        int k = 0;
        
        for(char ch : s.toCharArray()){
            if(Character.isDigit(ch)){
                k = 10 * k + (ch - '0');
            }else if(ch == '['){
                countStack.push(k);
                strStack.push(curr);
                curr = new StringBuilder();
                k = 0;
            }else if(ch == ']'){
                int repeat = countStack.pop();
                StringBuilder prev = strStack.pop();
                
                for(int i=0;i<repeat;i++){
                    prev.append(curr);
                }
                
                curr = prev;
            }else{
                curr.append(ch);
            }
        }
        
        return curr.toString();
    }
}
