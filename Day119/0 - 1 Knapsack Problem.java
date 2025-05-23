/*0 - 1 Knapsack Problem
Given n items, each with a specific weight and value, and a knapsack with a capacity of W, the task is to put the items
in the knapsack such that the sum of weights of the items <= W and the sum of values associated with them is maximized. 
Note: You can either place an item entirely in the bag or leave it out entirely. Also, each item is available in single quantity.

Examples :

Input: W = 4, val[] = [1, 2, 3], wt[] = [4, 5, 1] 
Output: 3
Explanation: Choose the last item, which weighs 1 unit and has a value of 3.

Input: W = 3, val[] = [1, 2, 3], wt[] = [4, 5, 6] 
Output: 0
Explanation: Every item has a weight exceeding the knapsack's capacity (3).

Input: W = 5, val[] = [10, 40, 30, 50], wt[] = [5, 4, 2, 3] 
Output: 80
Explanation: Choose the third item (value 30, weight 2) and the last item (value 50, weight 3) for a total value of 80.

Constraints:

2 ≤ val.size() = wt.size() ≤ 10^3
1 ≤ W ≤ 10^3
1 ≤ val[i] ≤ 10^3
1 ≤ wt[i] ≤ 10^3*/

class Solution {
    static int solve(int W, int []val, int []wt, int i, int [][]t){
        if(i < 0 || W == 0){
            return 0;
        }
        
        if(t[i][W]!= -1){
            return t[i][W];
        }
        
        int Take = 0;
        if(wt[i] <= W){
            Take = val[i] + solve(W - wt[i], val, wt, i - 1, t);
        }
        
        int notTake = solve(W, val, wt, i - 1, t);
        
        return t[i][W] = Math.max(Take, notTake);
    }
    
    static int knapsack(int W, int val[], int wt[]) {
        // code here
        int [][]t = new int[val.length][W+1];
        
        for(int i=0;i<val.length;i++){
            for(int j=0;j<W+1;j++){
                t[i][j] = -1;
            }
        }
        
        return solve(W, val, wt, val.length-1, t);
    }
}
