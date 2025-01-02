/*Subarrays with sum K
Given an unsorted array of integers, find the number of continuous subarrays having sum exactly equal to a given number k.

Examples:

Input: arr = [10, 2, -2, -20, 10], k = -10
Output: 3
Explaination: Subarrays: arr[0...3], arr[1...4], arr[3...4] have sum exactly equal to -10.

Input: arr = [9, 4, 20, 3, 10, 5], k = 33
Output: 2
Explaination: Subarrays: arr[0...2], arr[2...4] have sum exactly equal to 33.

Input: arr = [1, 3, 5], k = 0
Output: 0
Explaination: No subarray with 0 sum.

Constraints:

1 ≤ arr.size() ≤ 10^5
-10^3 ≤ arr[i] ≤ 10^3
-10^7 ≤ k ≤ 10^7*/

class Solution {
    public int countSubarrays(int arr[], int k) {
        // code here
        int res  = 0, currSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>(); // to store prefix sums and their frequencies
        
        map.put(0, 1); // initial entry for prefix sum = 0 with frequency 1
        
        for(int num : arr){
            currSum += num;
            
            if(map.containsKey(currSum - k)){ // this means there's a subarray with a sum equal to k
                res += map.get(currSum - k); // add frequency of (currSum - k) to the result
            }
            map. put(currSum, map.getOrDefault(currSum, 0) + 1); // increment frequency if it already exists, otherwise set it to 1
        }
        return res;
    }
}
