/* Max of min for every window size
You are given an integer array arr[], the task is to find the maximum of minimum values for every window size k where 1≤ k ≤ arr.size().
For each window size k, consider all contiguous subarrays of length k, determine the minimum element in each subarray, and then take the maximum among all these minimums.
Return the results as an array, where the element at index i represents the answer for window size i+1.

Examples :

Input: arr[] = [10, 20, 30, 50, 10, 70, 30]
Output: [70, 30, 20, 10, 10, 10, 10] 
Explanation: 
Window size 1: minimums are [10, 20, 30, 50, 10, 70, 30], maximum of minimums is 70.
Window size 2: minimums are [10, 20, 30, 10, 10, 30], maximum of minimums is 30.
Window size 3: minimums are [10, 20, 10, 10, 10], maximum of minimums is 20.
Window size 4–7: minimums are [10, 10, 10, 10], maximum of minimums is 10.

Input: arr[] = [10, 20, 30]
Output: [30, 20, 10]
Explanation: 
Window size 1: minimums of  [10], [20], [30], maximum of minimums is 30.
Window size 2: minimums of [10, 20], [20,30], maximum of minimums is 20.
Window size 3: minimums of [10,20,30], maximum of minimums is 10.

Constraints:

1 ≤ arr.size() ≤ 10^5
1 ≤ arr[i] ≤ 10^6 */


class Solution {
    public ArrayList<Integer> maxOfMins(int[] arr) {
        // code here
        int n = arr.length;
        int []left = new int[n];
        int []right = new int[n];
        int []res = new int[n+1];
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        
        stack.clear();
        
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        
        for(int i=0;i<n;i++){
            int len = right[i] - left[i] - 1;
            res[len] = Math.max(res[len], arr[i]);
        }
        
        for(int i=n-1;i>=1;i--){
            res[i] = Math.max(res[i], res[i+1]);
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=1;i<=n;i++){
            ans.add(res[i]);
        }
        
        return ans;
    }
}
