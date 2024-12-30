/*Longest Consecutive Subsequence
Given an array arr[] of non-negative integers. Find the length of the longest sub-sequence such that elements in the subsequence are consecutive integers, the consecutive numbers can be in any order.

Examples:

Input: arr[] = [2, 6, 1, 9, 4, 5, 3]
Output: 6
Explanation: The consecutive numbers here are 1, 2, 3, 4, 5, 6. These 6 numbers form the longest consecutive subsquence.

Input: arr[] = [1, 9, 3, 10, 4, 20, 2]
Output: 4
Explanation: 1, 2, 3, 4 is the longest consecutive subsequence.

Input: arr[] = [15, 13, 12, 14, 11, 10, 9]
Output: 7
Explanation: The longest consecutive subsequence is 9, 10, 11, 12, 13, 14, 15, which has a length of 7.

Constraints:

1 <= arr.size() <= 10^5
0 <= arr[i] <= 10^5*/

class Solution {

    // Function to return length of longest subsequence of consecutive integers.
    public int longestConsecutive(int[] arr) {
        // code here
        HashSet<Integer> set = new HashSet<>();
        for(int num : arr){ // add each element into the set
            set.add(num);
        }
        
        int res = 0;
        
        for(int num : arr){
            int curr = 0; // count of elements in the current subsequence
            int temp1 = num, temp2 = num - 1;
            
            if(set.contains(num)){
                while(set.contains(temp1)){ // for consecutive numbers starting from num and going forward
                    curr++;
                    set.remove(temp1);
                    temp1++;
                }
                while(set.contains(temp2)){ // for consecutive numbers going backward
                    curr++;
                    set.remove(temp2);
                    temp2--;
                }
            }
            res = Math.max(res, curr);
        }
        return res;
    }
}
