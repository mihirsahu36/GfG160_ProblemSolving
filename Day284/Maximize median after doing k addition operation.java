/* Maximize median after doing k addition operation
Given an array arr[] consisting of positive integers and an integer k.
You are allowed to perform at most k operations, where in each operation, you can increment any one element of the array by 1.
Determine the maximum possible median of the array that can be achieved after performing at most k such operations.
Note: The median of an array is defined as the middle element when the array (after sorting) has an odd size,
or the average of the two middle elements when the array (after sorting) has an even size.

Examples:

Input: arr[] = [1, 3, 4, 5], k = 3
Output: 5
Explanation: We can add +2 to the second element and +1 to the third element to get the array [1, 5, 5, 5].
After sorting, the array remains [1, 5, 5, 5]. Since the length is even, the median is (5 + 5) / 2 = 5.

Input: arr[] = [1, 3, 6, 4, 2], k = 10
Output: 7
Explanation: After applying operations optimally, we can transform the array to [1, 3, 7, 7, 7] (one possible way).
Sorted array becomes [1, 3, 7, 7, 7]. Since the length is odd, the median is the middle element 7.

Constraints:

1 ≤ arr.size() ≤ 10^5
0 ≤ arr[i], k ≤ 10^9 */

class Solution {
    private boolean isPossible(int []arr, int k, int targetMedian){
        int n = arr.length;
        
        if(n % 2 == 1){
            for(int i=n/2;i<n;i++){
                if(arr[i] < targetMedian){
                    k -= (targetMedian - arr[i]);
                }
                
                if(k < 0){
                    break;
                }
            }
        }else{
            if(arr[n/2] <= targetMedian && arr[n/2-1] <= targetMedian){
                k -= (targetMedian - arr[n/2]);
                k -= (targetMedian - arr[n/2-1]);
            }else{
                k -= (2 * targetMedian - (arr[n/2] + arr[n/2-1]));
            }
            
            for(int i=n/2+1;i<n;i++){
                if(arr[i] < targetMedian){
                    k -= (targetMedian - arr[i]);
                }
                
                if(k < 0){
                    break;
                }
            }
        }
        
        return k >= 0;
    }
    
    public int maximizeMedian(int[] arr, int k) {
        // code here
        Arrays.sort(arr);
        int n = arr.length;
        int median = arr[n/2];
        
        if(n % 2 == 0){
            median += arr[n/2-1];
            median /= 2;
        }
        
        int low = median;
        int high = median + k;
        int res = median;
        
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
}
