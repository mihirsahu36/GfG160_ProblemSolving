/*Missing element of AP
Given a sorted array arr[] that represents an Arithmetic Progression (AP) with exactly one missing element, find the missing number.
Note: An element will always exist that, upon inserting into a sequence forms Arithmetic progression.
If the given sequence already forms a valid complete AP, return the (n+1)-th element that would come next in the sequence.

Examples:

Input: arr[] = [2, 4, 8, 10, 12, 14]
Output: 6
Explanation: Actual AP should be 2, 4, 6, 8, 10, 12, 14.

Input: arr[] = [1, 6, 11, 16, 21, 31]
Output: 26
Explanation: Actual AP should be 1, 6, 11, 16, 21, 26, 31.

Input: arr[] = [4, 7, 10, 13, 16]
Output: 19
Explanation: Since the sequence already forms a valid AP, the next element after 16 in the sequence would be 19. Therefore, the output is 19.

Constraints:

2 ≤ arr.size() ≤ 10^5
0 ≤ arr[i] ≤ 2*10^7 */

class Solution {
    public int findMissing(int[] arr) {
        // code here
        int n = arr.length;
        int diff;
        
        if(arr[1] - arr[0] == (arr[n - 1] - arr[0]) / n) {
            diff = arr[1] - arr[0];
        }else{
            diff = arr[n - 1] - arr[n - 2];
        }

        if (diff == 0) return arr[0];
        
        int left = 0, right = n - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            int expected = arr[0] + mid * diff;
            
            if(arr[mid] == expected){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        
        return arr[0] + left * diff;
    }
}
