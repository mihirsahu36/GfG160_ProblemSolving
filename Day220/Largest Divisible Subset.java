/*Largest Divisible Subset
Given an array arr[] of distinct positive integers. Your task is to find the largest subset such that for every pair of elements (x, y) in the subset, either x divides y or y divides x.
Note : If multiple subsets of the same maximum length exist, return the one that is lexicographically greatest, after sorting the subset in ascending order.

Examples:

Input: arr[] = [1, 16, 7, 8, 4]
Output: [1, 4, 8, 16]
Explanation: The largest divisible subset is [1, 4, 8, 16], where each element divides the next one. This subset is already the lexicographically greatest one.

Input: arr[] = [2, 4, 3, 8]
Output: [2, 4, 8]
Explanation: The largest divisible subset is [2, 4, 8], where each element divides the next one. This subset is already the lexicographically greatest one.

Constraint:

1 ≤ arr.size() ≤ 10^3
1  ≤ arr[i] ≤ 10^9 */

class Solution {
    public ArrayList<Integer> largestSubset(int[] arr) {
        // code here
        Arrays.sort(arr);
        int n = arr.length;
        
        for(int i=0,j=n-1;i<j;i++,j--){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        
        int []t = new int[n];
        Arrays.fill(t, 1);
        
        int []parent = new int[n];
        Arrays.fill(parent, -1);
        
        int maxLen = 1;
        int lastIdx = 0;
        
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[j] % arr[i] == 0){
                    if(t[i] < t[j] + 1){
                        t[i] = t[j] + 1;
                        parent[i] = j;
                    }
                }
            }
            
            if(t[i] > maxLen){
                maxLen = t[i];
                lastIdx = i;
            }
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=lastIdx;i>=0;i=parent[i]){
            res.add(arr[i]);
            if(parent[i] == -1){
                break;
            }
        }
        
        return res;
    }
}
