/*Count Subarrays with given XOR
Given an array of integers arr[] and a number k, count the number of subarrays having XOR of their elements as k.

Examples: 

Input: arr[] = [4, 2, 2, 6, 4], k = 6
Output: 4
Explanation: The subarrays having XOR of their elements as 6 are [4, 2], [4, 2, 2, 6, 4], [2, 2, 6], and [6]. Hence, the answer is 4.

Input: arr[] = [5, 6, 7, 8, 9], k = 5
Output: 2
Explanation: The subarrays having XOR of their elements as 5 are [5] and [5, 6, 7, 8, 9]. Hence, the answer is 2.

Input: arr[] = [1, 1, 1, 1], k = 0
Output: 4
Explanation: The subarrays are [1, 1], [1, 1], [1, 1] and [1, 1, 1, 1].

Constraints:

1 ≤ arr.size() ≤ 10^5
0 ≤ arr[i] ≤10^5
0 ≤ k ≤ 10^5*/

class Solution {
    public long subarrayXor(int arr[], int k) {
        // code here
        long res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int currXOR = 0;
        
        map.put(0, 1);
        
        for(int num : arr){
            currXOR ^= num; // update the current XOR by XORing it with current element
            
            if(map.containsKey(currXOR^k)){ // if currXOR ^ k exists in the map
                res += map.get(currXOR^k); // add the frequency of such XOR to the result
            }
            map.put(currXOR, map.getOrDefault(currXOR, 0) + 1); // update the frequency of the current XOR in the map
        }
        return res;
    }
}
