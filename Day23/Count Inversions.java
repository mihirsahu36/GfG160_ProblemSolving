/*Count Inversions
Given an array of integers arr[]. Find the Inversion Count in the array.
Two elements arr[i] and arr[j] form an inversion if arr[i] > arr[j] and i < j.
Inversion Count: For an array, inversion count indicates how far (or close) the array is from being sorted. If the array is already sorted then the inversion count is 0.
If an array is sorted in the reverse order then the inversion count is the maximum. 

Examples:

Input: arr[] = [2, 4, 1, 3, 5]
Output: 3
Explanation: The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1), (4, 3).

Input: arr[] = [2, 3, 4, 5, 6]
Output: 0
Explanation: As the sequence is already sorted so there is no inversion count.

Input: arr[] = [10, 10, 10]
Output: 0
Explanation: As all the elements of array are same, so there is no inversion count.

Constraints:

1 ≤ arr.size() ≤ 10^5
1 ≤ arr[i] ≤ 10^4*/

class Solution {
    // Function to count inversions in the array.
    static int inversionCount(int arr[]) {
        // Your Code Here
        return mergeSort(arr, 0, arr.length - 1);
    }
    
    static int mergeSort(int []arr, int left, int right){
        if(left >= right){
            return 0;
        }
        int mid = left + (right - left) / 2;
        
        int leftInv = mergeSort(arr, left, mid);
        int rightInv = mergeSort(arr, mid + 1, right);
        int m = merge(arr, left, mid, right);
        
        return leftInv + rightInv + m;
    }
    
    static int merge(int []arr, int left, int mid, int right){
        int j = mid + 1;
        int count = 0;
        
        for(int i=left;i<=mid;i++){
            while(j<=right && arr[i]>arr[j]){
                j++;
            }
            count += j - (mid+1);
        }
        
        Arrays.sort(arr, left, right+1);
        return count;
    }
}
