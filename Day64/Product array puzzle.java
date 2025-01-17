/*Product array puzzle
Given an array, arr[] construct a product array, res[] where each element in res[i] is the product of all elements in arr[] except arr[i]. Return this resultant array, res[].
Note: Each element is res[] lies inside the 32-bit integer range.

Examples:

Input: arr[] = [10, 3, 5, 6, 2]
Output: [180, 600, 360, 300, 900]
Explanation: For i=0, res[i] = 3 * 5 * 6 * 2 is 180.
For i = 1, res[i] = 10 * 5 * 6 * 2 is 600.
For i = 2, res[i] = 10 * 3 * 6 * 2 is 360.
For i = 3, res[i] = 10 * 3 * 5 * 2 is 300.
For i = 4, res[i] = 10 * 3 * 5 * 6 is 900.

Input: arr[] = [12, 0]
Output: [0, 12]
Explanation: For i = 0, res[i] is 0.
For i = 1, res[i] is 12.

Constraints:

2 <= arr.size() <= 10^5
-100 <= arr[i] <= 100*/

class Solution {
    public static int[] productExceptSelf(int arr[]) {
        // code here
        int n = arr.length, totalProd = 1, zeroCount = 0;
        int []res = new int[n];
        
        for(int num : arr){
            if(num == 0){
                zeroCount++;
            }else{
                totalProd *= num;
            }
        }
        
        if(zeroCount > 1){
            return res;
        }
        if(zeroCount == 1){
            for(int i=0;i<n;i++){
                if(arr[i] == 0){
                    res[i] = totalProd;
                }
            }
            return res;
        }
        for(int i=0;i<n;i++){
            res[i] = totalProd / arr[i];
        }
        return res;
    }
}
