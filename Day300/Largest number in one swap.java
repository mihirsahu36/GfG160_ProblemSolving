/* Largest number in one swap
Given a string s, return the lexicographically largest string that can be obtained by swapping at most one pair of characters in s.

Examples:

Input: s = "768"
Output: "867"
Explanation: Swapping the 1st and 3rd characters(7 and 8 respectively), gives the lexicographically largest string.

Input: s = "333"
Output: "333"
Explanation: Performing any swaps gives the same result i.e "333".

Constraints:

1 ≤ |s| ≤ 10^5
'0' ≤ s[i] ≤ '9' */

class Solution {
    public String largestSwap(String s) {
        // code here
        char []arr = s.toCharArray();
        char maxDigit = '0';
        int maxIdx = -1, leftIdx = -1, rightIdx = -1;
        
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i] > maxDigit){
                maxDigit = arr[i];
                maxIdx = i;
            }else if(arr[i] < maxDigit){
                leftIdx = i;
                rightIdx = maxIdx;
            }
        }
        
        if(leftIdx == -1){
            return s;
        }
        
        char temp = arr[leftIdx];
        arr[leftIdx] = arr[rightIdx];
        arr[rightIdx] = temp;
        
        return new String(arr);
    }
}
