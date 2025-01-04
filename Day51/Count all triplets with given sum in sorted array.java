/*Count all triplets with given sum in sorted array
Given a sorted array arr[] and a target value, the task is to count triplets (i, j, k) of valid indices, such that arr[i] + arr[j] + arr[k] = target and i < j < k.

Examples:

Input: arr[] = [-3, -1, -1, 0, 1, 2], target = -2
Output: 4
Explanation: Two triplets that add up to -2 are:
arr[0] + arr[3] + arr[4] = (-3) + 0 + (1) = -2
arr[0] + arr[1] + arr[5] = (-3) + (-1) + (2) = -2
arr[0] + arr[2] + arr[5] = (-3) + (-1) + (2) = -2
arr[1] + arr[2] + arr[3] = (-1) + (-1) + (0) = -2

Input: arr[] = [-2, 0, 1, 1, 5], target = 1
Output: 0
Explanation: There is no triplet whose sum is equal to 1. 

Constraints:

3 ≤ arr.size() ≤ 10^3
-10^5 ≤ arr[i], target ≤ 10^5*/

class Solution {
    public int countTriplets(int[] arr, int target) {
        // Code Here
        int res = 0, n = arr.length;
        for(int i=0;i<n-2;i++){ // iterate over each element of the array, treating it as first element of triplet
            int left = i + 1, right = n - 1;
            
            while(left < right){ // use of two pointer which result in target when added with arr[i]
                int sum = arr[i] + arr[left] + arr[right];
                
                if(sum < target){ // if sum is less than target increment left pointer
                    left++;
                }else if(sum > target){ // if sum is greater than target decrement right pointer
                    right--;
                }else{
                    int e1 = arr[left], e2 = arr[right], leftCount = 0, rightCount = 0;
                    
                    while(left <= right && arr[left] == e1){ // if left value repeats
                        leftCount++;
                        left++;
                    }
                    
                    while(left <= right && arr[right] == e2){ // if right value repeats
                        rightCount++;
                        right--;
                    }
                    if(e1 == e2){
                        res += (leftCount * (leftCount -1)) / 2;
                    }else{
                        res += leftCount * rightCount;
                    }
                }
            }
        }
        return res;
    }
}
