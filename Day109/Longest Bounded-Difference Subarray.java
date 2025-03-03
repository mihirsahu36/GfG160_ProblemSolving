/*Longest Bounded-Difference Subarray
Given an array of positive integers arr[] and a non-negative integer x, the task is to find the longest sub-array where the absolute difference between any two elements is not greater than x.
If multiple such subarrays exist, return the one that starts at the smallest index.

Examples: 

Input: arr[] = [8, 4, 2, 6, 7], x = 4 
Output: [4, 2, 6] 
Explanation: The sub-array described by index [1..3], i.e. [4, 2, 6] contains no such difference of two elements which is greater than 4.

Input: arr[] = [15, 10, 1, 2, 4, 7, 2], x = 5 
Output: [2, 4, 7, 2] 
Explanation: The sub-array described by indexes [3..6], i.e. [2, 4, 7, 2] contains no such difference of two elements which is greater than 5. 

Constraints:

1 <= arr.size() <= 10^5
1 <= arr[i] <= 10^9
0 <= x<= 10^9*/

class Solution {

    public ArrayList<Integer> longestSubarray(int[] arr, int x) {
        // code here
        int left = 0, maxLength = 0, start = 0;
        Deque<Integer> minDq = new LinkedList<>();
        Deque<Integer> maxDq = new LinkedList<>();
        
        for(int right=0;right<arr.length;right++){
            while(!maxDq.isEmpty() && arr[maxDq.peekLast()] <= arr[right]){
                maxDq.pollLast();
            }
            maxDq.addLast(right);
            
            while(!minDq.isEmpty() && arr[minDq.peekLast()] >= arr[right]){
                minDq.pollLast();
            }
            minDq.addLast(right);
            
            while(arr[maxDq.peekFirst()] - arr[minDq.peekFirst()] > x){
                left++;
                if(maxDq.peekFirst() < left) maxDq.pollFirst();
                if(minDq.peekFirst() < left) minDq.pollFirst();
            }
            
            if(right - left + 1 > maxLength){
                maxLength = right - left + 1;
                start = left;
            }
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=start;i<start+maxLength;i++){
            res.add(arr[i]);
        }
        
        return res;
    }
}
