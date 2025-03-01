/*Decode the string
Given an encoded string s, the task is to decode it. The encoding rule is :
k[encodedString], where the encodedString inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
Note: The test cases are generated so that the length of the output string will never exceed 105 .

Examples:

Input: s = "1[b]"
Output: "b"
Explanation: "b" is present only one time.

Input: s = "3[b2[ca]]"
Output: "bcacabcacabcaca"
Explanation:
1. Inner substring “2[ca]” breakdown into “caca”.
2. Now, new string becomes “3[bcaca]”
3. Similarly “3[bcaca]” becomes “bcacabcacabcaca ” which is final result.

Constraints:

1 ≤ |s| ≤ 10^5*/

class Solution {
    static String decodeString(String s) {
        // code here
        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        char []arr = s.toCharArray();
        int i = 0, num = 0;
        String curr = "";
        
        while(i < s.length()){
            if(Character.isDigit(arr[i])){
                num = 0;
                
                while(Character.isDigit(arr[i])){
                    num = num * 10 + (arr[i] - '0');
                    i++;
                }
                countStack.push(num);
                
            }else if(arr[i] == '['){
                stringStack.add(curr);
                curr = "";
                i++;
                
            }else if(arr[i] == ']'){
                int n = countStack.pop();
                StringBuilder ds = new StringBuilder(stringStack.pop());
                
                for(int j=0;j<n;j++){
                    ds.append(curr);
                }
                curr = ds.toString();
                i++;
                
            }else{
                curr += arr[i];
                i++;
            }
        }
        
        return curr;
    }
}
