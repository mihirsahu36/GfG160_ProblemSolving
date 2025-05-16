/*Smallest range in K lists
Given a 2d integer array arr[][] of size k*n, where each row is sorted in ascending order.
Your task is to find the smallest range [l, r] that includes at least one element from each of the k lists. If more than one such ranges are found, return the first one.

Examples:

Input: n = 5, k = 3, arr[][] = [[4, 7, 9, 12, 15], [0, 8, 10, 14, 20], [6, 12, 16, 30, 50]]
Output: [6, 8]
Explanation: Smallest range is formed by  number 7 from the first list, 8 from second list and 6 from the third list.

Input: n = 5, k = 3, arr[][] = [[1, 3, 5, 7, 9], [0, 2, 4, 6, 8], [2, 3, 5, 7, 11]]
Output: [1, 2]
Explanation: Smallest range is formed by number 1 present in first list and 2 is present in both 2nd and 3rd list.

Input: n = 2, k = 3, arr[][] = [[2, 4], [1, 7], [20, 40]]
Output: [4, 20]
Explanation: Smallest range is formed by number 4 from the first list, 7 from second list and 20 from the third list.

Constraints:

1 <= k, n <= 500
0 <= arr[ i ] <= 10^5*/

class Solution {
    class Pair{
        int val, row, col;
        Pair(int val, int row, int col){
            this.val = val;
            this.row = row;
            this.col = col;
        }
    }
    
    public ArrayList<Integer> findSmallestRange(int[][] arr) {
        // code here
        int n = arr.length;
        int m = arr[0].length;
        
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        int maxVal = Integer.MIN_VALUE;
        int maxEl = -1;
        int minEl = -1;
        int minRange = Integer.MAX_VALUE;
        
        for(int i=0;i<n;i++){
            minHeap.add(new Pair(arr[i][0], i, 0));
            maxVal = Math.max(maxVal, arr[i][0]);
        }
        
        while(true){
            Pair top = minHeap.poll();
            int minVal = top.val;
            int row = top.row;
            int col = top.col;
            
            if(maxVal - minVal < minRange){
                minRange = maxVal - minVal;
                minEl = minVal;
                maxEl = maxVal;
            }
            
            if(col + 1 == m){
                break;
            }
            
            int nextVal = arr[row][col + 1];
            minHeap.add(new Pair(nextVal, row, col + 1));
            maxVal = Math.max(maxVal, nextVal);
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        res.add(minEl);
        res.add(maxEl);
        
        return res;
    }
}
