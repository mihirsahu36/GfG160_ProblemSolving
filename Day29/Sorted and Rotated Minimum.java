/*Sorted and Rotated Minimum
A sorted array of distinct elements arr[] is rotated at some unknown point, the task is to find the minimum element in it. 

Examples:

Input: arr[] = [5, 6, 1, 2, 3, 4]
Output: 1
Explanation: 1 is the minimum element in the array.

Input: arr[] = [3, 1, 2]
Output: 1
Explanation: Here 1 is the minimum element.

Input: arr[] = [4, 2, 3]
Output: 2
Explanation: Here 2 is the minimum element.

Constraints:

1 ≤ arr.size() ≤ 10^6
1 ≤ arr[i] ≤ 10^9*/

class Solution {
    public int findMin(int[] arr) {
        // complete the function here
        int n = arr.length;
        if(arr[0] < arr[n - 1]){ // already in sorted order
            return arr[0];
        }
        
        int start = 0, end = n - 1;
        while(start < end){
            int mid = start + (end - start) / 2;
            if(mid > 0 && arr[mid] < arr[mid - 1]){ // the mid is only the smallest element
                return arr[mid];
            }
            if(arr[start] <= arr[mid] && arr[mid] > arr[end]){ // left part of mid is sorted and the smallest element is present in right part of mid
                start = mid + 1;
            }else{ // smallest element present in left part of mid
                end = mid - 1;
            }
        }
        return arr[start];
    }
}
