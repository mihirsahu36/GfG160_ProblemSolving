/*Unique Paths in a Grid
You are given a 2d list grid[][] of size n x m consisting of values 0 and 1.
A value of 0 means that you can enter that cell and 1 implies that entry to that cell is not allowed.
You start at the upper-left corner of the grid (1, 1) and you have to reach the bottom-right corner 
(n, m) such that you can only move in the right or down direction from every cell.
Your task is to calculate the total number of ways of reaching the target.

Note: The first (1, 1) and last (n, m) cell of the grid can also be 1.
It is guaranteed that the total number of ways will fit within a 32-bit integer.

Examples:

Input: n = 3, m = 3,
grid[][] = [[0, 0, 0], [0, 1, 0], [0, 0, 0]]
Output: 2
Explanation: There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right

Input: n = 1, m = 3,
grid[][] = [[1, 0, 1]]
Output: 0
Explanation: There is no possible path to reach the end.

Constraints:

1 ≤ n*m ≤ 10^6*/

class Solution {
    private int solve(int i, int j, int [][]grid, int [][]t){
        int m = grid.length;
        int n = grid[0].length;
        
        if(i >= m || j >= n || grid[i][j] == 1){
            return 0;
        }
        
        if(i == m - 1 && j == n - 1){
            return 1;
        }
        
        if(t[i][j] != -1){
            return t[i][j];
        }
        
        int right = solve(i, j + 1, grid, t);
        int down = solve(i + 1, j, grid, t);
        
        return t[i][j] = right + down;
    }
    
    public int uniquePaths(int[][] grid) {
        // code here
        int m = grid.length;
        int n = grid[0].length;
        
        if(grid[0][0] == 1 || grid[m-1][n-1] == 1){
            return 0;
        }
        
        int [][]t = new int[m][n];
        for(int []row : t){
            Arrays.fill(row, -1);
        }
        
        return solve(0, 0, grid, t);
    }
};
