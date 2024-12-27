/*Count pairs with given sum
Given an array arr[] and an integer target. You have to find numbers of pairs in array arr[] which sums up to given target.

Examples:

Input: arr[] = [1, 5, 7, -1, 5], target = 6 
Output: 3
Explanation: Pairs with sum 6 are (1, 5), (7, -1) and (1, 5). 

Input: arr[] = [1, 1, 1, 1], target = 2 
Output: 6
Explanation: Pairs with sum 2 are (1, 1), (1, 1), (1, 1), (1, 1), (1, 1), (1, 1).

Input: arr[] = [10, 12, 10, 15, -1], target = 125
Output: 0

Constraints:

1 <= arr.size() <= 10^5
-10^4 <= arr[i] <= 10^4
1 <= target <= 10^4*/

class Solution {

    int countPairs(int arr[], int target) {
        // Your code here
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        
        for(int num : arr){
            if(map.containsKey(target - num)){
                count += map.get(target - num);
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return count;
    }
}
