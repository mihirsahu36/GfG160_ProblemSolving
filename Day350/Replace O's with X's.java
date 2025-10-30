/* Replace O's with X's
You are given a grid[][] of size n*m, where every element is either 'O' or 'X'.
You have to replace all 'O' or a group of 'O' with 'X' that are surrounded by 'X'.
A 'O' (or a set of 'O') is considered to be surrounded by 'X' if there are 'X' at locations just below,
just above, just left and just right of it.

Examples:

Input: 
grid[][] = [['X', 'X', 'X', 'X'], 
          ['X', 'O', 'X', 'X'], 
          ['X', 'O', 'O', 'X'], 
          ['X', 'O', 'X', 'X'], 
          ['X', 'X', 'O', 'O']]
Output: 
[['X', 'X', 'X', 'X'], 
['X', 'X', 'X', 'X'], 
['X', 'X', 'X', 'X'], 
['X', 'X', 'X', 'X'], 
['X', 'X', 'O', 'O']]
Explanation: We only changed those 'O' that are surrounded by 'X'

Input: 
grid[][] = [['X', 'O', 'X', 'X'], 
          ['X', 'O', 'X', 'X'], 
          ['X', 'O', 'O', 'X'], 
          ['X', 'O', 'X', 'X'], 
          ['X', 'X', 'O', 'O']]
Output: 
[['X', 'O', 'X', 'X'], 
['X', 'O', 'X', 'X'], 
['X', 'O', 'O', 'X'], 
['X', 'O', 'X', 'X'], 
['X', 'X', 'O', 'O']]
Explanation: There's no 'O' that's surround by 'X'.

Input: 
grid[][] = [['X', 'X', 'X'], 
          ['X', 'O', 'X'], 
          ['X', 'X', 'X']]
Output: 
[['X', 'X', 'X'], 
['X', 'X', 'X'], 
['X', 'X', 'X']]
Explanation: There's only one 'O' that's surround by 'X'.

Constraints:

1 ≤ grid.size() ≤ 100
1 ≤ grid[0].size() ≤ 100 */

class Solution {
    public void fill(char[][] grid) {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        
        for(int i=0;i<n;i++){
            if(grid[i][0] == 'O'){
                solve(i, 0, grid, n, m);
            }
            
            if(grid[i][m-1] == 'O'){
                solve(i, m - 1, grid, n, m);
            }
        }
        
        for(int j=0;j<m;j++){
            if(grid[0][j] == 'O'){
                solve(0, j, grid, n, m);
            }
            
            if(grid[n-1][j] == 'O'){
                solve(n - 1, j, grid, n, m);
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 'O'){
                    grid[i][j] = 'X';
                }else if(grid[i][j] == 'B'){
                    grid[i][j] = 'O';
                }
            }
        }
    }
    
    private void solve(int i, int j, char [][]grid, int n, int m){
        if(i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != 'O'){
            return;
        }
        
        grid[i][j] = 'B';
        
        solve(i + 1, j, grid, n, m);
        solve(i - 1, j, grid, n, m);
        solve(i, j + 1, grid, n, m);
        solve(i, j - 1, grid, n, m);
    }
}
