/*Unique Number III
Given an array of integers arr[] where, every element appears thrice except for one which occurs once.
Find that element which occurs once.

Examples:

Input: arr[] = [1, 10, 1, 1]
Output: 10
Explanation: 10 occurs once in the array while the other element 1 occurs thrice.

Input: arr[] = [3, 2, 1, 34, 34, 1, 2, 34, 2, 1]
Output: 3
Explanation: All elements except 3 occurs thrice in the array.

Constraints:
1 ≤ arr.size() ≤ 10^5
arr.size() % 3 = 1
-109 ≤ arr[i] ≤ 10^9*/

class Solution {
    public int getSingle(int[] arr) {
        // code here
        int res = 0;
        
        for(int i=0;i<32;i++){
            int sum = 0;
            int mask = (1 << i);
            
            for(int j=0;j<arr.length;j++){
                if((arr[j] & mask) != 0){
                    sum++;
                }
            }
            
            if(sum % 3 != 0){
                res |= mask;
            }
        }
        
        return res;
    }
}
