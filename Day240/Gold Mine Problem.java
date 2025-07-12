/* Gold Mine Problem
Given a gold mine called mat[][]. Each field in this mine contains a positive integer which is the amount of gold in tons.
Initially, the miner can start from any row in the first column. From a given cell, the miner can move -
1. to the cell diagonally up towards the right
2. to the right
3. to the cell diagonally down towards the right
Find out the maximum amount of gold that he can collect until he can no longer move.

Examples:

Input: mat[][] = [[1, 3, 3], [2, 1, 4], [0, 6, 4]]
Output: 12
Explaination: The path is (1, 0) -> (2, 1) -> (2, 2). Total gold collected is 2 + 6 + 4 = 12.

Input: mat[][] = [[1, 3, 1, 5], [2, 2, 4, 1], [5, 0, 2, 3], [0, 6, 1, 2]]
Output: 16
Explaination: The path is (2, 0) -> (3, 1) -> (2, 2) -> (2, 3) or (2, 0) -> (1, 1) -> (1, 2) -> (0, 3). 
Total gold collected is (5 + 6 + 2 + 3) or (5 + 2 + 4 + 5) = 16.

Input: mat[][] = [[1, 3, 3], [2, 1, 4], [0, 7, 5]]
Output: 14
Explaination: The path is (1,0) -> (2,1) -> (2,2). Total gold collected is 2 + 7 + 5 = 14.

Constraints:

1 ≤ mat.size(), mat[0].size() ≤ 500
0 ≤ mat[i][j] ≤ 100 */

class Solution {
    private int solve(int i, int j, int [][]mat, int [][]t){
        int n = mat.length;
        int m = mat[0].length;
        
        if(i < 0 || i >= n || j >= m){
            return 0;
        }
        
        if(t[i][j] != -1){
            return t[i][j];
        }
        
        int rightUp = solve(i - 1, j + 1, mat, t);
        int right = solve(i, j + 1, mat, t);
        int rightDown = solve(i + 1, j + 1, mat, t);
        
        return t[i][j] = mat[i][j] + Math.max(rightUp, Math.max(right, rightDown));
    }
    
    public int maxGold(int[][] mat) {
        // code here
        int n = mat.length;
        int m = mat[0].length;
        int res = 0;
        int [][]t = new int[501][501];
        
        for(int []row : t){
            Arrays.fill(row, -1);
        }
        
        for(int i=0;i<n;i++){
            res = Math.max(res, solve(i, 0, mat, t));
        }
        
        return res;
    }
}
