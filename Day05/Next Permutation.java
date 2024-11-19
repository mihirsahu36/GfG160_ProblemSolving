/*Next Permutation
Given an array of integers arr[] representing a permutation, implement the next permutation that rearranges the numbers into the lexicographically next greater permutation. If no such permutation exists, rearrange the numbers into the lowest possible order (i.e., sorted in ascending order). 
Note - A permutation of an array of integers refers to a specific arrangement of its elements in a sequence or linear order.

Examples: 

Input: arr = [2, 4, 1, 7, 5, 0]
Output: [2, 4, 5, 0, 1, 7]
Explanation: The next permutation of the given array is {2, 4, 5, 0, 1, 7}.

Input: arr = [3, 2, 1]
Output: [1, 2, 3]
Explanation: As arr[] is the last permutation, the next permutation is the lowest one.

Input: arr = [3, 4, 2, 5, 1]
Output: [3, 4, 5, 1, 2]
Explanation: The next permutation of the given array is {3, 4, 5, 1, 2}.

Constraints:

1 ≤ arr.size() ≤ 105
1 ≤ arr[i] ≤ 105*/

class Solution {
    void nextPermutation(int[] arr) {
        // code here
        int n = arr.length;
        int swapA = -1;
        for(int i=n-2;i>=0;i--){
            if(arr[i]<arr[i+1]){
                swapA = i;
                break;
            }
        }
        if(swapA != -1){
            int swapB = -1;
            for(int j=n-1;j>swapA;j--){
                if(arr[j]>arr[swapA]){
                    swapB = j;
                    break;
                }
            }
            swap(arr, swapA, swapB);
        }
        reverse(arr, swapA+1, n-1);
    }
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }
}
