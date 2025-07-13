/* Maximum sum of elements not part of LIS
Given an array arr[] of positive integers, your task is to find the maximum possible sum of all elements that are not part of the Longest Increasing Subsequence (LIS).

Examples:

Input: arr[] = [4, 6, 1, 2, 3, 8]
Output: 10
Explanation: The elements which are not in LIS is 4 and 6.

Input: arr[] = [5, 4, 3, 2, 1]
Output: 14
Explanation: The elements which are not in LIS is 5, 4, 3 and 2.

Constraints:

1 ≤ arr.size() ≤ 10^3
1 ≤ arr[i] ≤ 10^5 */

class Solution {
    public int nonLisMaxSum(int[] arr) {
        // code here
        int n = arr.length;
        int totalSum = 0;
        
        for(int num : arr){
            totalSum += num;
        }
        
        int []t = new int[n];
        int []tSum = new int[n];
        
        for(int i=0;i<n;i++){
            t[i] = 1;
            tSum[i] = arr[i];
        }
        
        int maxLIS = 1;
        int LISSum = arr[0];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[j] < arr[i]){
                    int currLen = t[j] + 1;
                    int currSum = tSum[j] + arr[i];
                    
                    if(currLen > t[i]){
                        t[i] = currLen;
                        tSum[i] = currSum;
                    }else if(currLen == t[i]){
                        tSum[i] = Math.min(tSum[i], currSum);
                    }
                }
            }
            
            if(t[i] > maxLIS){
                maxLIS = t[i];
                LISSum = tSum[i];
            }else if(t[i] == maxLIS){
                LISSum = Math.min(LISSum, tSum[i]);
            }
        }
        
        return totalSum - LISSum;
    }
}
