/*Pair with given sum in a sorted array
You are given an integer target and an array arr[]. You have to find number of pairs in arr[] which sums up to target. It is given that the elements of the arr[] are in sorted order.
Note: pairs should have elements of distinct indexes. 

Examples :

Input: arr[] = [-1, 1, 5, 5, 7], target = 6
Output: 3
Explanation: There are 3 pairs which sum up to 6 : {1, 5}, {1, 5} and {-1, 7}.

Input: arr[] = [1, 1, 1, 1], target = 2
Output: 6
Explanation: There are 6 pairs which sum up to 2 : {1, 1}, {1, 1}, {1, 1}, {1, 1}, {1, 1} and {1, 1}.

Input: arr[] = [-1, 10, 10, 12, 15], target = 125
Output: 0
Explanation: There is no such pair which sums up to 4.

Constraints:

-10^5 <= target <=10^5
 2 <= arr.size() <= 10^5
-10^5 <= arr[i] <= 10^5*/

class Solution {

    int countPairs(int arr[], int target) {
        // Complete the function
        int res = 0, start = 0, end = arr.length - 1;
        
        while(start < end){ // use of two pointer approach
            int currSum = arr[start] + arr[end];
            
            if(currSum > target){ // if sum greater than target then decrement the end pointer
                end--;
            }else if(currSum < target){ // if sum less than target than increment the start pointer
                start++;
            }else{
                int e1 = arr[start], e2 = arr[end];
                int leftCount = 0, rightCount = 0;
                
                while(start <= end && arr[start] == e1){ // if left value repeats
                    start++;
                    leftCount++;
                }
                while(start <= end && arr[end] == e2){ // if right value repeats
                    end--;
                    rightCount++;
                }
                if(e1 == e2){ // if both elements are the same calculate the number of pairs from the repeated elements
                    res += (leftCount * (leftCount - 1)) / 2;
                }else{ // else count pairs formed by the repeated elements from both sides
                    res += leftCount * rightCount;
                }
                
            }
        }
        return res;
    }
}
