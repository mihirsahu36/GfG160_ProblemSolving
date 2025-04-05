/*Find the number of islands
Given a grid of size n*m (n is the number of rows and m is the number of columns in the grid) consisting of 'W's (Water) and 'L's (Land). Find the number of islands.
Note: An island is either surrounded by water or the boundary of a grid and is formed by connecting adjacent lands horizontally or vertically or diagonally i.e., in all 8 directions.

Examples:

Input: grid[][] = [['L', 'L', 'W', 'W', 'W'], ['W', 'L', 'W', 'W', 'L'], ['L', 'W', 'W', 'L', 'L'], ['W', 'W', 'W', 'W', 'W'], ['L', 'W', 'L', 'L', 'W']]
Output: 4
Explanation:
The image below shows all the 4 islands in the grid.
 
Input: grid[][] = [['W', 'L', 'L', 'L', 'W', 'W', 'W'], ['W', 'W', 'L', 'L', 'W', 'L', 'W']]
Output: 2
Expanation:
The image below shows 2 islands in the grid.
 
Constraints:

1 ≤ n, m ≤ 500
grid[i][j] = {'L', 'W'}*/

class Solution {
    public int countIslands(char[][] grid) {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        boolean [][]visited = new boolean[n][m];
        int count = 0;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 'L' && !visited[i][j]){
                    dfs(grid, i, j, n, m, visited);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    private void dfs(char [][]grid, int x, int y, int n, int m, boolean [][]visited){
        visited[x][y] = true;
        int []dx = {-1, -1, 0, 1, 1, 1, 0, -1};
        int []dy = {0, 1, 1, 1, 0, -1, -1, -1};
        
        for(int k=0;k<8;k++){
            int newX = x + dx[k];
            int newY = y + dy[k];
            
            if(newX >= 0 && newX < n && newY >= 0 && newY < m && grid[newX][newY] == 'L' 
            && !visited[newX][newY]){
                 dfs(grid, newX, newY, n, m, visited);
            }
        }
    }
}
