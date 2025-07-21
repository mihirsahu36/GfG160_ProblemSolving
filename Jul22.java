/* Smallest Positive Missing
You are given an integer array arr[]. Your task is to find the smallest positive number missing from the array.
Note: Positive number starts from 1. The array can have negative integers too.

Examples:

Input: arr[] = [2, -3, 4, 1, 1, 7]
Output: 3
Explanation: Smallest positive missing number is 3.

Input: arr[] = [5, 3, 2, 5, 1]
Output: 4
Explanation: Smallest positive missing number is 4.

Input: arr[] = [-8, 0, -1, -4, -3]
Output: 1
Explanation: Smallest positive missing number is 1.

Constraints:  

1 ≤ arr.size() ≤ 10^5
-106 ≤ arr[i] ≤ 10^6 */

class Solution {
    public int missingNumber(int[] arr) {
        // code here
        int n = arr.length;
        int i = 0;
        
        while(i < n){
            int correctIdx = arr[i] - 1;

            if(arr[i] > 0 && arr[i] <= n && arr[i] != arr[correctIdx]){
                int temp = arr[i];
                arr[i] = arr[correctIdx];
                arr[correctIdx] = temp;
            }else{
                i++;
            }
        }
        
        for(i=0;i<n;i++){
            if(arr[i] != i + 1){
                return i + 1;
            }
        }
        
        return n + 1;
    }
}
