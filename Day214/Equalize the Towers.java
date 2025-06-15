/*Equalize the Towers
Difficulty: MediumAccuracy: 33.76%Submissions: 3K+Points: 4
You are given an array heights[] representing the heights of towers and another array 
cost[] where each element represents the cost of modifying the height of respective tower.
The goal is to make all towers of same height by either adding or removing blocks from each tower.
Modifying the height of tower (add or remove) 'i' by 1 unit costs cost[i].
Return the minimum cost to equalize the heights of all towers.

Examples:

Input: heights[] = [1, 2, 3], cost[] = [10, 100, 1000]
Output: 120
Explanation: The heights can be equalized by either "Removing one block from 3 and adding one in 1" or 
"Adding two blocks in 1 and adding one in 2". Since the cost of operation in tower 3 is 1000,
the first process would yield 1010 while the second one yields 120.

Input: heights[] = [7, 1, 5], cost[] = [1, 1, 1]
Output: 6
Explanation: The minimum cost to equalize the towers is 6, achieved by setting all towers to height 5.
Constraints:

1 ≤ heights.size() = cost.size() ≤ 10^5
1 ≤ heights[i] ≤ 10^4
1 ≤ cost[i] ≤ 10^3 */

class Solution {
    private int findCost(int []heights, int []cost, int targetHeight){
        int totalCost = 0;
        
        for(int i=0;i<heights.length;i++){
            totalCost += Math.abs(heights[i] - targetHeight) * cost[i];
        }
        
        return totalCost;
    }
    
    public int minCost(int[] heights, int[] cost) {
        // code here
        int low = Arrays.stream(heights).min().getAsInt();
        int high = Arrays.stream(heights).max().getAsInt();
        int res = Integer.MAX_VALUE;
        
        while(low <= high){
            int mid = low + (high - low) / 2;
            
            int costMid = findCost(heights, cost, mid);
            int costLeft = findCost(heights, cost, mid - 1);
            int costRight = findCost(heights, cost, mid + 1);
            
            res = Math.min(res, Math.min(costMid, Math.min(costLeft, costRight)));
            
            if(costLeft < costMid){
                high = mid - 1;
            }else if(costRight < costMid){
                low = mid + 1;
            }else{
                break;
            }
        }
        
        return res;
    }
}
