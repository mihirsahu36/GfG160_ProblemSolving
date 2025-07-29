/* Subarrays with sum K
Given an unsorted array arr[] of integers, find the number of subarrays whose sum exactly equal to a given number k.

Examples:

Input: arr[] = [10, 2, -2, -20, 10], k = -10
Output: 3
Explaination: Subarrays: arr[0...3], arr[1...4], arr[3...4] have sum exactly equal to -10.

Input: arr[] = [9, 4, 20, 3, 10, 5], k = 33
Output: 2
Explaination: Subarrays: arr[0...2], arr[2...4] have sum exactly equal to 33.

Input: arr[] = [1, 3, 5], k = 0
Output: 0
Explaination: No subarray with 0 sum.

Constraints:

1 ≤ arr.size() ≤ 10^5
-10^3 ≤ arr[i] ≤ 10^3
-10^5 ≤ k ≤ 10^5 */

class Solution {
    public int cntSubarrays(int[] arr, int k) {
        // code here
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        int currSum = 0;
        
        for(int i=0;i<arr.length;i++){
            currSum += arr[i];
            
            if(currSum == k){
                res++;
            }
            
            if(map.containsKey(currSum - k)){
                res += map.get(currSum - k);
            }
            
            map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        }
        
        return res;
    }
}
