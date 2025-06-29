/*Split Array Largest Sum
Given an array arr[] and an integer k, divide the array into k contiguous subarrays such
that the maximum sum among these subarrays is minimized. Find this minimum possible maximum sum.

Examples:

Input: arr[] = [1, 2, 3, 4], k = 3
Output: 4
Exaplanation: Optimal Split is [1, 2], [3], [4]. Maximum sum of all subarrays is 4, which is minimum possible for 3 splits.

Input: arr[] = [1, 1, 2], k = 2
Output: 2
Exaplanation: Splitting the array as [1, 1] and [2] is optimal. This results in a maximum sum subarray of 2.

Constraints:

1 ≤ k ≤ arr.size() ≤ 10^5
1 ≤ arr[i] ≤ 10^4 */

class Solution {
    private boolean check(int mid, int []arr, int k){
        int n = arr.length;
        int count = 1;
        int sum = 0;
        
        for(int i=0;i<n;i++){
            if(arr[i] > mid){
                return false;
            }
            
            sum += arr[i];
            
            if(sum > mid){
                count++;
                sum = arr[i];
            }
        }
        
        return count <= k;
    }
    public int splitArray(int[] arr, int k) {
        // code here
        int n = arr.length;
        int low = Arrays.stream(arr).max().getAsInt();
        int high = Arrays.stream(arr).sum();
        int res = 0;
        
        while(low <= high){
            int mid = low + (high - low) / 2;
            
            if(check(mid, arr, k)){
                res = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        
        return res;
    }
};
