/* Maximum subarray sum 2
You are given an array arr[] of integers and two integers a and b, You have to find the maximum possible sum of a contiguous subarray whose length is at least a and at most b.

Examples:

Input: arr[] = [4, 5, -1, -2, 6], a = 2, b = 4
Output: 9
Explanation: The subarray [4, 5] has length 2 and sum 9, which is the maximum among all subarrays of length between 2 and 4.

Input: arr[] = [-1, 3, -1, -2, 5, 3, -5, 2, 2], a = 3, b = 5
Output: 8
Explanation: The subarray [3, -1, -2, 5, 3] has length 5 and sum 8, which is the maximum among all subarrays of length between 3 and 5.

Constraints:

1 ≤ arr.size() ≤ 10^5
-10^5 ≤ arr[i] ≤ 10^5 */


class Solution {
    public int maxSubarrSum(int[] arr, int a, int b) {
        // code here
        int n = arr.length;
        long []prefix = new long[n+1];
        
        for(int i=0;i<n;i++){
            prefix[i+1] = prefix[i] + arr[i];
        }
        
        Deque<Integer> dq = new ArrayDeque<>();
        long res = Long.MIN_VALUE;
        
        for(int i=a;i<=n;i++){
            int idx = i - a;
            
            while(!dq.isEmpty() && prefix[dq.peekLast()] >= prefix[idx]){
                dq.pollLast();
            }
            dq.addLast(idx);
            
            int minValid = i - b;
            while(!dq.isEmpty() && dq.peekFirst() < minValid){
                dq.pollFirst();
            }
            
            res = Math.max(res, prefix[i] - prefix[dq.peekFirst()]);
        }
        
        return (int)res;
    }
}
