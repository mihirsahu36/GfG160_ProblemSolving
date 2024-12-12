/*Number of occurrence
Given a sorted array, arr[] and a number target, you need to find the number of occurrences of target in arr[]. 

Examples :

Input: arr[] = [1, 1, 2, 2, 2, 2, 3], target = 2
Output: 4
Explanation: target = 2 occurs 4 times in the given array so the output is 4.

Input: arr[] = [1, 1, 2, 2, 2, 2, 3], target = 4
Output: 0
Explanation: target = 4 is not present in the given array so the output is 0.

Input: arr[] = [8, 9, 10, 12, 12, 12], target = 12
Output: 3
Explanation: target = 12 occurs 3 times in the given array so the output is 3.

Constraints:

1 ≤ arr.size() ≤ 10^6
1 ≤ arr[i] ≤ 10^6
1 ≤ target ≤ 10^6*/

class Solution {
    int countFreq(int[] arr, int target) {
        // code here
        int start = firstOccurrence(arr, target);
        if(start == -1) return 0;
        int end = lastOccurrence(arr, target);
        return end - start + 1;
    }
    
    int firstOccurrence(int []arr, int target){ // find the first Occurrence of target
        int low = 0, high = arr.length - 1, result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= target) {
                if (arr[mid] == target) result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }
    
    int lastOccurrence(int []arr, int target){ // find the last Occurrence of target
        int low = 0, high = arr.length - 1, result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= target) {
                if (arr[mid] == target) result = mid;
                low = mid + 1;
            } else {
                high = mid -1;
            }
        }
        return result;
    }
}
