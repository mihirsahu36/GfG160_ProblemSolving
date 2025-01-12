/*Trapping Rain Water
Given an array arr[] with non-negative integers representing the height of blocks. If the width of each block is 1, compute how much water can be trapped between the blocks during the rainy season. 

Examples:

Input: arr[] = [3, 0, 1, 0, 4, 0 2]
Output: 10
Explanation: Total water trapped = 0 + 3 + 2 + 3 + 0 + 2 + 0 = 10 units.

Input: arr[] = [3, 0, 2, 0, 4]
Output: 7
Explanation: Total water trapped = 0 + 3 + 1 + 3 + 0 = 7 units.

Input: arr[] = [1, 2, 3, 4]
Output: 0
Explanation: We cannot trap water as there is no height bound on both sides.

Input: arr[] = [2, 1, 5, 3, 1, 0, 4]
Output: 9
Explanation: Total water trapped = 0 + 1 + 0 + 1 + 3 + 4 + 0 = 9 units.

Constraints:

1 < arr.size() < 10^5
0 < arr[i] < 10^3*/

class Solution {
    public int maxWater(int arr[]) {
        // code here
        int n = arr.length;
        int l = 0, r = n - 1;
        int leftMax = 0, rightMax = 0;
        int res = 0;
        
        while(l <= r){
            if(arr[l] <= arr[r]){
                if(leftMax <= arr[l]){
                    leftMax = arr[l];
                }else{
                    res += leftMax - arr[l];
                }
                l++;
            }else{
                if(rightMax <= arr[r]){
                    rightMax = arr[r];
                }else{
                    res += rightMax - arr[r];
                }
                r--;
            }
        }
        return res;
    }
}
