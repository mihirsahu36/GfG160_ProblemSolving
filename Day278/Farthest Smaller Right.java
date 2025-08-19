/* Farthest Smaller Right
You are given an array arr[].
For each element at index i (0-based indexing), find the farthest index j to the right (i.e., j > i) such that arr[j] < arr[i].
If no such index exists for a given position, return -1 for that index. Return the resulting array of answers.

Examples:

Input: arr[] = [2, 5, 1, 3, 2]
Output: [2, 4, -1, 4, -1]
Explanation: arr[0] = 2: Farthest smaller element to the right is arr[2] = 1.
arr[1] = 5: Farthest smaller element to the right is arr[4] = 2.
arr[2] = 1: No smaller element to the right → -1.
arr[3] = 3: Farthest smaller element to the right is arr[4] = 2.
arr[4] = 2: No elements to the right → -1.

Input: arr[] = [2, 3, 5, 4, 1] 
Output: [4, 4, 4, 4, -1]
Explanation: arr[4] is the farthest smallest element to the right for arr[0], arr[1], arr[2] and arr[3].

Constraints:

1 ≤ arr.size() ≤ 10^6
1 ≤ arr[i] ≤ 10^6 */

class Solution {
    public ArrayList<Integer> farMin(int[] arr) {
        // Code Here
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            ans.add(-1);
        }
        
        int []suffixMin = new int[n];
        suffixMin[n-1] = arr[n-1];
        for(int i=n-2;i>=0;i--){
            suffixMin[i] = Math.min(suffixMin[i+1], arr[i]);
        }
        
        for(int i=0;i<n;i++){
            int low = i + 1, high = n - 1, res = -1;
            
            while(low <= high){
                int mid = low + (high - low) / 2;
                if(suffixMin[mid] < arr[i]){
                    res = mid;
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }
            ans.set(i, res);
        }
        
        return ans;
    }
}
