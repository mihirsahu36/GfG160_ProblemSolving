/* Longest Bounded-Difference Subarray
Given an array of positive integers arr[] and a non-negative integer x,
the task is to find the longest sub-array where the absolute difference between any two elements is not greater than x.
If multiple such subarrays exist, return the one that starts at the smallest index.

Examples:

Input: arr[] = [8, 4, 5, 6, 7], x = 3 
Output: [4, 5, 6, 7] 
Explanation: The sub-array described by index [1..4], i.e. [4, 5, 6, 7]
contains no two elements whose absolute differnce is greater than 3.

Input: arr[] = [1, 10, 12, 13, 14], x = 2 
Output: [12, 13, 14] 
Explanation: The sub-array described by index [2..4], i.e. [12, 13, 14]
contains no two elements whose absolute differnece is greater than 2. 

Constraints:

1 ≤ arr.size() ≤ 10^5
1 ≤ arr[i] ≤ 10^9
0 ≤ x ≤ 10^9 */

class Solution {
    public ArrayList<Integer> longestSubarray(int[] arr, int x) {
        // code here
        int n = arr.length;
        Deque<Integer> maxDeque = new ArrayDeque<>();
        Deque<Integer> minDeque = new ArrayDeque<>();
        int left = 0, bestStart = 0, bestLen = 0;
        
        for(int right=0;right<n;right++){
            while(!maxDeque.isEmpty() && arr[maxDeque.peekLast()] <= arr[right]){
                maxDeque.pollLast();
            }
            maxDeque.addLast(right);
            
            while(!minDeque.isEmpty() && arr[minDeque.peekLast()] >= arr[right]){
                minDeque.pollLast();
            }
            minDeque.addLast(right);
            
            while(!maxDeque.isEmpty() && !minDeque.isEmpty() && arr[maxDeque.peekFirst()] - arr[minDeque.peekFirst()] > x){
                if(maxDeque.peekFirst() == left){
                    maxDeque.pollFirst();
                }
                
                if(minDeque.peekFirst() == left){
                    minDeque.pollFirst();
                }
                
                left++;
            }
            
            int currLen = right - left + 1;
            if(currLen > bestLen){
                bestLen = currLen;
                bestStart = left;
            }
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=bestStart;i<bestStart+bestLen;i++){
            res.add(arr[i]);
        }
        
        return res;
    }
}
