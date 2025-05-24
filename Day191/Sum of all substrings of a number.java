/*Sum of all substrings of a number
Given an integer s represented as a string, the task is to get the sum of all possible sub-strings of this string.
Note: The number may have leading zeros.
It is guaranteed that the total sum will fit within a 32-bit signed integer.

Examples:

Input: s = "6759"
Output: 8421
Explanation:
Sum = 6 + 7 + 5 + 9 + 67 + 75 + 59 + 675 + 759 + 6759 = 8421

Input: s = "421"
Output: 491
Explanation: 
Sum = 4 + 2 + 1 + 42 + 21 + 421 = 491

Constraints:

1 <= |s| <= 9*/

class Solution {
    public static int sumSubstrings(String s) {
        // code here
        int n = s.length();
        int sum = 0;
        int placeVal = 1;
        
        for(int i=n-1;i>=0;i--){
            sum += (s.charAt(i) - '0') * (i + 1) * placeVal;
            
            placeVal = placeVal * 10 + 1;
        }
        
        return sum;
    }
}
