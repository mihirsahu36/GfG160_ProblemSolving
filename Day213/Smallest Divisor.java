/*Smallest Divisor
Given an integer array arr[] and an integer k (where k ≥ arr.length),
find the smallest positive integer divisor such that the sum of the ceiling values of each element in arr[] divided by this divisor is less than or equal to k.

Examples:

Input: arr[] = [1, 2, 5, 9], k = 6
Output: 5
Explanation: 5 is the smallest divisor having sum of quotients (1 + 1 + 1 + 2 = 5) less than or equal to 6.

Input: arr[] = [1, 1, 1, 1], k = 4
Output: 1
Explanation: 1 is the smallest divisor having sum of quotients (1 + 1 + 1 + 1 = 4) less than or equal to 4.

Constraints:

1  ≤  arr.size()  ≤ 10^5
1  ≤  arr[i]  ≤ 10^6
arr.size()  ≤ k  ≤ 10^6 */

class Solution {
    boolean isValid(int []arr, int mid, int k){
        int sum = 0;
        
        for(int i=0;i<arr.length;i++){
            sum += Math.ceil((double)arr[i] / mid);
            if(sum > k){
                return false;
            }
        }
        
        return sum <= k;
    }
    
    int smallestDivisor(int[] arr, int k) {
        // Code here
        int low = 1;
        int high = Arrays.stream(arr).max().getAsInt();
        int res = 0;
        
        while(low <= high){
            int mid = low + (high - low) / 2;
            
            if(isValid(arr, mid, k)){
                res = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        
        return res;
    }
}
