/*Coin Piles
You are given an array arr[] of integers, where each element represents the number of coins in a pile. You are also given an integer k.
Your task is to remove the minimum number of coins such that the absolute difference between the number of coins in any two updated piles is at most k.
Note: You can also remove a pile by removing all the coins of that pile.

Examples:

Input: arr[] = [2, 2, 2, 2], k = 0
Output: 0
Explanation: For any two piles the difference in the number of coins is <= 0. So no need to remove any coin. 

Input: arr[] = [1, 5, 1, 2, 5, 1], k = 3
Output: 2
Explanation: If we remove one coin each from both the piles containing 5 coins, then for any two piles the absolute difference in the number of coins is <= 3.

Constraints:

1 ≤ arr.size() ≤ 10^5
1 ≤ arr[i] ≤ 10^4
0 ≤ k ≤ 10^4 */

class Solution {
    private int upperBound(int []arr, int start, int end, int target){
        int low = start, high = end;
        
        while(low < high){
            int mid = low + (high - low) / 2;
            if(arr[mid] <= target){
                low = mid + 1;
            }else{
                high = mid;
            }
        }
        
        return low;
    }
    
    public int minimumCoins(int[] arr, int k) {
        // code here
        int n = arr.length;
        Arrays.sort(arr);
        int []prefix = new int[n];
        
        prefix[0] = arr[0];
        for(int i=1;i<n;i++){
            prefix[i] = prefix[i-1] + arr[i];
        }
        
        int res = Integer.MAX_VALUE;
        int prev = 0;
        
        for(int i=0;i<n;i++){
            int idx = upperBound(arr, i, n, arr[i] + k);
            
            if(i > 0){
                prev = prefix[i-1];
            }
            
            int totalToRemove = prev + prefix[n-1] - prefix[idx-1] - (arr[i] + k) * (n - idx);
            res = Math.min(res, totalToRemove);
        }
        
        return res;
    }
}
