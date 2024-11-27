/*Smallest Positive Missing Number
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

1 <= arr.size() <= 10^5
-10^6 <= arr[i] <= 10^6*/

class Solution {
    // Function to find the smallest positive number missing from the array.
    public int missingNumber(int[] arr) {
        // Your code here
        int n = arr.length;
        boolean contains1 = false;
        
        for(int i=0;i<n;i++){
            if(arr[i] == 1){
                contains1 = true;
            }
            if(arr[i] <= 0 || arr[i] > n){
                arr[i] = 1;
            }
        }
        
    if(!contains1) return 1;
    
    for(int i=0;i<n;i++){
        int val = Math.abs(arr[i]);
        int idx = val - 1;
        
        if(arr[idx] < 0) continue;
        arr[idx] *= -1;
    }
    
    for(int i=0;i<n;i++){
        if(arr[i] > 0){
            return i+1;
        }
    }
    return n + 1;
    }
}
