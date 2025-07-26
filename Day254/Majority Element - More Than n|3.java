/* Majority Element - More Than n/3
Given an array arr[] consisting of n integers, the task is to find all the array elements which occurs more than floor(n/3) times.
Note: The returned array of majority elements should be sorted.

Examples:

Input: arr[] = [2, 2, 3, 1, 3, 2, 1, 1]
Output: [1, 2]
Explanation: The frequency of 1 and 2 is 3, which is more than floor n/3 (8/3 = 2).

Input:  arr[] = [-5, 3, -5]
Output: [-5]
Explanation: The frequency of -5 is 2, which is more than floor n/3 (3/3 = 1).

Input:  arr[] = [3, 2, 2, 4, 1, 4]
Output: []
Explanation: There is no majority element.

Constraint:

1 ≤ arr.size() ≤ 10^6
-10^5 ≤ arr[i] ≤ 10^5 */

class Solution {
    public ArrayList<Integer> findMajority(int[] arr) {
        // Code here
        int n = arr.length;
        
        Integer maj1 = null;
        int count1 = 0;
        
        Integer maj2 = null;
        int count2 = 0;
        
        for(int num : arr){
            if(maj1 != null && num == maj1){
                count1++;
            }else if(maj2 != null && num == maj2){
                count2++;
            }else if(count1 == 0){
                maj1 = num;
                count1 = 1;
            }else if(count2 == 0){
                maj2 = num;
                count2 = 1;
            }else{
                count1--;
                count2--;
            }
        }
        
        count1 = 0;
        count2 = 0;
        for(int num : arr){
            if(maj1 != null && num == maj1){
                count1++;
            }else if(maj2 != null && num == maj2){
                count2++;
            }
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        if(count1 > n / 3){
            res.add(maj1);
        }
        if(count2 > n / 3){
            res.add(maj2);
        }
        
        Collections.sort(res);
        return res;
    }
}
