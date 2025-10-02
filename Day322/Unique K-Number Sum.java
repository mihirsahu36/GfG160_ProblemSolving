/* Unique K-Number Sum
Given two integers n and k, the task is to find all valid combinations of k numbers that adds up to n based on the following conditions:
Only numbers from the range [1, 9] used.
Each number can only be used at most once.
Note: You can return the combinations in any order, the driver code will print them in sorted order.

Examples:

Input: n = 9, k = 3
Output: [[1, 2, 6], [1, 3, 5], [2, 3, 4]]
Explanation: There are three valid combinations of 3 numbers that sum to 9: [1 ,2, 6], [1, 3, 5] and [2, 3, 4].

Input: n = 3, k = 3
Output: []
Explanation: It is not possible to pick 3 distinct numbers from 1 to 9 that sum to 3, so no valid combinations exist.

Constraints:

1 ≤ n ≤ 50
1 ≤ k ≤ 9 */

class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int n, int k) {
        // code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        solve(1, k, n, new ArrayList<>(), res);
        return res;
    }
    
    private void solve(int start, int k, int target, ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> res){
        if(curr.size() == k && target == 0){
            res.add(new ArrayList<>(curr));
            return;
        }
        
        if(curr.size() > k || target < 0){
            return;
        }
        
        for(int i=start;i<=9;i++){
            curr.add(i);
            solve(i + 1, k, target - i, curr, res);
            curr.remove(curr.size() - 1);
        }
    }
}
