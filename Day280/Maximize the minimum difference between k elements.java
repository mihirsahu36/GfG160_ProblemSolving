/* Maximize the minimum difference between k elements
Given an array arr[] of integers and an integer k,
select k elements from the array such that the minimum
absolute difference between any two of the selected elements is maximized.
Return this maximum possible minimum difference.

Examples:

Input: arr[] = [2, 6, 2, 5], k = 3
Output: 1
Explanation: 3 elements out of 4 elements are to be selected with a minimum difference as large as possible.
Selecting 2, 2, 5 will result in minimum difference as 0. Selecting 2, 5, 6 will result in minimum difference as 6 - 5 = 1.

Input: arr[] = [1, 4, 9, 0, 2, 13, 3], k = 4
Output: 4
Explanation: Selecting 0, 4, 9, 13 will result in minimum difference of 4, which is the largest minimum difference possible.

Constraints:

1 ≤ arr.size() ≤ 10^5
0 ≤ arr[i] ≤ 10^6
2 ≤ k ≤ arr.size() */

class Solution {
    public int maxMinDiff(int[] arr, int k) {
        // code here
        Arrays.sort(arr);
        int low = 0, high = arr[arr.length-1] - arr[0];
        int res = 0;
        
        while(low <= high){
            int mid = low + (high - low) / 2;
            
            if(isPossible(arr, k, mid)){
                res = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        
        return res;
    }
    
    private boolean isPossible(int[] arr, int k, int minDiff){
        int count = 1;
        int last = arr[0];
        
        for(int i=1;i<arr.length;i++){
            if(arr[i] - last >= minDiff){
                count++;
                last = arr[i];
                
                if(count >= k){
                    return true;
                }
            }
        }
        
        return false;
    }
}
