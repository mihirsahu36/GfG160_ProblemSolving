/* Longest subarray with Atmost two distinct integers
Given an array arr[] consisting of positive integers, your task is to find the length of the longest subarray that contains at most two distinct integers.

Examples:

Input: arr[] = [2, 1, 2]
Output: 3
Explanation: The entire array [2, 1, 2] contains at most two distinct integers (2 and 1). Hence, the length of the longest subarray is 3.

Input: arr[] = [3, 1, 2, 2, 2, 2]
Output: 5
Explanation: The longest subarray containing at most two distinct integers is [1, 2, 2, 2, 2], which has a length of 5.

Constraints:

1 ≤ arr.size() ≤ 10^5
1 ≤ arr[i] ≤ 10^5 */

class Solution {
    public int totalElements(int[] arr) {
        // code here
        int n = arr.length;
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0, j = 0;
        
        while(j < n){
            map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
            
            while(map.size() > 2){
                map.put(arr[i], map.get(arr[i]) - 1);
                
                if(map.get(arr[i]) == 0){
                    map.remove(arr[i]);
                }
                i++;
            }
        
            res = Math.max(res, j - i + 1);
            j++;
        }
        
        return res;
    }
}
