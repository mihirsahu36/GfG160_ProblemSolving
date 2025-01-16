/*Largest subarray of 0's and 1's
Given an array arr of 0s and 1s. Find and return the length of the longest subarray with equal number of 0s and 1s.

Examples:

Input: arr[] = [1, 0, 1, 1, 1, 0, 0]
Output: 6
Explanation: arr[1...6] is the longest subarray with three 0s and three 1s.

Input: arr[] = [0, 0, 1, 1, 0]
Output: 4
Explnation: arr[0...3] or arr[1...4] is the longest subarray with two 0s and two 1s.

Input: arr[] = [0]
Output: 0
Explnation: There is no subarray with an equal number of 0s and 1s.

Constraints:

1 <= arr.size() <= 10^5
0 <= arr[i] <= 1*/

class Solution {
    public int maxLen(int[] arr) {
        // Your code here
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0, sum = 0;
        
        map.put(0, -1);
        
        for(int i=0;i<arr.length;i++){
            sum += arr[i] == 1 ? 1 : -1;
            
            if(map.containsKey(sum)){
                res = Math.max(res, i - map.get(sum));
            }else{
                map.put(sum, i);
            }
        }
        return res;
    }
}
