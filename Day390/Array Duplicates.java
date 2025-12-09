/* Array Duplicates
Given an array arr[] of size n, containing elements from the range 1 to n, 
and each element appears at most twice, return an array of all the integers that appears twice.
Note: You can return the elements in any order but the driver code will print them in sorted order.

Examples:

Input: arr[] = [2, 3, 1, 2, 3]
Output: [2, 3] 
Explanation: 2 and 3 occur more than once in the given array.

Input: arr[] = [3, 1, 2] 
Output: []
Explanation: There is no repeating element in the array, so the output is empty.

Constraints:

1 ≤ n ≤ 10^6
1 ≤ arr[i] ≤ n */

class Solution {
    public ArrayList<Integer> findDuplicates(int[] arr) {
        // code here
        int n = arr.length;
        ArrayList<Integer> res = new ArrayList<>();

        for(int i=0;i<n;i++){
            int x = Math.abs(arr[i]);
            if(arr[x-1] < 0){
                res.add(x);
            }else{
                arr[x-1] = -arr[x-1];
            }
        }

        return res;
    }
}
