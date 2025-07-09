/* Sum of subarray minimum
Given an array arr[] of positive integers, find the total sum of the minimum elements of every possible subarrays.
Note: It is guaranteed that the total sum will fit within a 32-bit unsigned integer.

Examples:

Input: arr[] = [3, 1, 2, 4]
Output: 17
Explanation: Subarrays are [3], [1], [2], [4], [3, 1], [1, 2], [2, 4], [3, 1, 2], [1, 2, 4], [3, 1, 2, 4].
Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1. Sum of all these is 17.

Input: arr[] = [71, 55, 82, 55]
Output: 593
Explanation: The sum of the minimum of all the subarrays is 593.

Constraints:

1 ≤ arr.size() ≤ 3*10^4
1 ≤ arr[i] ≤ 10^3 */

class Solution {
    private int []getNSL(int []arr, int n){
        int []res = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }
            
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        
        return res;
    }
    
    private int []getNSR(int []arr, int n){
        int []res = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                stack.pop();
            }
            
            res[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        
        return res;
    }
    
    public int sumSubMins(int[] arr) {
        // code here
        int n = arr.length;
        int []NSL = getNSL(arr, n);
        int []NSR = getNSR(arr, n);
        int sum = 0;
        
        for(int i=0;i<n;i++){
            int leftCount = i - NSL[i];
            int rightCount = NSR[i] - i;
            
            sum += arr[i] * leftCount * rightCount;
        }
        
        return sum;
    }
}
