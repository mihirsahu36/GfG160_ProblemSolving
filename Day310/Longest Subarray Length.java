/* Longest Subarray Length
You are given an array of integers arr[].
Your task is to find the length of the longest subarray such that all the elements of the subarray are smaller than or equal to the length of the subarray.

Examples:

Input: arr[] = [1, 2, 3]
Output: 3
Explanation: The longest subarray is the entire array itself, which has a length of 3.
All elements in the subarray are less than or equal to 3.

Input: arr[] = [6, 4, 2, 5]
Output: 0
Explanation: There is no subarray where all elements are less than or equal to the length of the subarray.
The longest subarray is empty, which has a length of 0.

Constraints:

1 ≤ arr.size() ≤ 10^5
1 ≤ arr[i] ≤ 10^9 */

class Solution {
    public static int longestSubarray(int[] arr) {
        // code here
        int n = arr.length;
        int []nextGreater = new int[n];
        int []prevGreater = new int[n];
        
        for(int i=0;i<n;i++){
            nextGreater[i] = n;
            prevGreater[i] = -1;
        }
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]){
                nextGreater[stack.pop()] = i;
            }
            stack.push(i);
        }
        
        stack.clear();
        
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]){
                prevGreater[stack.pop()] = i;
            }
            stack.push(i);
        }
        
        int maxLen = 0;
        
        for(int i=0;i<n;i++){
            int size = nextGreater[i] - prevGreater[i] - 1;
            if(size >= arr[i]){
                maxLen = Math.max(maxLen, size);
            }
        }
        
        return maxLen;
    }
}
