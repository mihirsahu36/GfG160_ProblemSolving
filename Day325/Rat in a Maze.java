/* Rat in a Maze
Consider a rat placed at position (0, 0) in an n x n square matrix maze[][].
The rat's goal is to reach the destination at position (n-1, n-1).
The rat can move in four possible directions: 'U'(up), 'D'(down), 'L' (left), 'R' (right).

The matrix contains only two possible values:
0: A blocked cell through which the rat cannot travel.
1: A free cell that the rat can pass through.
Your task is to find all possible paths the rat can take to reach the destination, starting from (0, 0) and ending at (n-1, n-1),
under the condition that the rat cannot revisit any cell along the same path.
Furthermore, the rat can only move to adjacent cells that are within the bounds of the matrix and not blocked.
If no path exists, return an empty list.
Note: Return the final result vector in lexicographically smallest order.

Examples:

Input: maze[][] = [[1, 0, 0, 0], [1, 1, 0, 1], [1, 1, 0, 0], [0, 1, 1, 1]]
Output: ["DDRDRR", "DRDDRR"]
Explanation: The rat can reach the destination at (3, 3) from (0, 0) by two paths - DRDDRR and DDRDRR, when printed in sorted order we get DDRDRR DRDDRR.

Input: maze[][] = [[1, 0], [1, 0]]
Output: []
Explanation: No path exists as the destination cell (1, 1) is blocked.

Input: maze[][] = [[1, 1, 1], [1, 0, 1], [1, 1, 1]]
Output: ["DDRR", "RRDD"]
Explanation: The rat has two possible paths to reach the destination: DDRR and RRDD.

Constraints:

2 ≤ n ≤ 5
0 ≤ maze[i][j] ≤ 1 */

class Solution {
    public ArrayList<String> ratInMaze(int[][] maze) {
        // code here
        ArrayList<String> res = new ArrayList<>();
        int n = maze.length;
        
        if(maze[0][0] == 0 || maze[n - 1][n - 1] == 0){
            return res;
        }
        
        boolean[][] visited = new boolean[n][n];
        StringBuilder path = new StringBuilder();
        int[] row = {1, 0, 0, -1};
        int[] col = {0, -1, 1, 0};
        char[] dir = {'D', 'L', 'R', 'U'};
        
        solve(0, 0, maze, n, visited, path, res, row, col, dir);
        Collections.sort(res);
        return res;
    }
    
    private void solve(int i, int j, int[][] maze, int n, boolean[][] visited, StringBuilder path, ArrayList<String> res,int[] row, int[] col, char[] dir){
        if(i == n - 1 && j == n - 1){
            res.add(path.toString());
            return;
        }
        
        visited[i][j] = true;
        
        for(int k=0;k<4;k++){
            int i_ = i + row[k];
            int j_ = j + col[k];
            
            if(isValid(i_, j_, maze, n, visited)){
                path.append(dir[k]);
                solve(i_, j_, maze, n, visited, path, res, row, col, dir);
                path.deleteCharAt(path.length() - 1);
            }
        }
        
        visited[i][j] = false;
    }
    
    private boolean isValid(int i, int j, int[][] maze, int n, boolean[][] visited) {
        return i >= 0 && i < n && j >= 0 && j < n && maze[i][j] == 1 && !visited[i][j];
    }
}
