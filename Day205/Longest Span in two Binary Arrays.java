/*Longest Span in two Binary Arrays
Given two binary arrays, a1[] and a2[]. Find the length of longest common span (i, j) where j>= i such that a1[i] + a1[i+1] + .... + a1[j] =  a2[i] + a2[i+1] + ... + a2[j].

Examples:

Input: a1[] = [0, 1, 0, 0, 0, 0], a2[] = [1, 0, 1, 0, 0, 1]
Output: 4
Explanation: The longest span with same sum is from index 1 to 4 following zero based indexing.

Input: a1[] = [0, 1, 0, 1, 1, 1, 1], a2[] = [1, 1, 1, 1, 1, 0, 1]
Output: 6
Explanation: The longest span with same sum is from index 1 to 6 following zero based indexing.

Constraints:

1 <= a1.size() = a2.size() <= 10^6
0 <= a1[i], a2[i] <= 1 */

class Solution {
    public int longestCommonSum(int[] a1, int[] a2) {
        // Code here
        int n = a1.length;
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum1 = 0, sum2 = 0;
        
        for(int i=0;i<n;i++){
            sum1 += a1[i];
            sum2 += a2[i];
            int currDiff = sum1 - sum2;
            
            if(currDiff == 0){
                res = Math.max(res, i + 1);
            }else if(map.containsKey(currDiff)){
                res = Math.max(res, i - map.get(currDiff));
            }else{
                map.put(currDiff, i);
            }
        }
        
        return res;
    }
}
