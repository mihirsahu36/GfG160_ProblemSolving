/* Distance of nearest cell having 1
Given a binary grid[][], where each cell contains either 0 or 1, find the distance of the nearest 1 for every cell in the grid.
The distance between two cells (i1, j1)  and (i2, j2) is calculated as |i1 - i2| + |j1 - j2|. 
You need to return a matrix of the same size, where each cell (i, j) contains the minimum distance from grid[i][j] to the nearest cell having value 1.
Note: It is guaranteed that there is at least one cell with value 1 in the grid.

Examples

Input: grid[][] = [[0, 1, 1, 0], 
                   [1, 1, 0, 0], 
                   [0, 0, 1, 1]]
Output: [[1, 0, 0, 1], 
        [0, 0, 1, 1], 
        [1, 1, 0, 0]]
Explanation: The grid is -
- 0's at (0,0), (0,3), (1,2), (1,3), (2,0) and (2,1) are at a distance of 1 from 1's at (0,1), (0,2), (0,2), (2,3), (1,0) and (1,1) respectively.

Input: grid[][] = [[1, 0, 1], 
                   [1, 1, 0], 
                   [1, 0, 0]]
Output: [[0, 1, 0], 
        [0, 0, 1], 
        [0, 1, 2]]
Explanation: The grid is -
- 0's at (0,1), (1,2), (2,1) and (2,2) are at a  distance of 1, 1, 1 and 2 from 1's at (0,0), (0,2), (2,0) and (1,1) respectively.

Constraints:
1 ≤ grid.size() ≤ 200
1 ≤ grid[0].size() ≤ 200 */

class Solution {
    public ArrayList<ArrayList<Integer>> nearest(int[][] grid) {
        // code here
        int n = grid.length;
        int m = grid[0].length;
        int [][]dist = new int[n][m];
        
        for(int []row : dist){
            Arrays.fill(row, -1);
        }
        
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                    queue.offer(new int[]{i, j});
                    dist[i][j] = 0;
                }
            }
        }
        
        int []dx = {-1, 1, 0, 0};
        int []dy = {0, 0, -1, 1};
        
        while(!queue.isEmpty()){
            int []cell = queue.poll();
            int x = cell[0], y = cell[1];
            
            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx >= 0 && ny >= 0 && nx < n && ny < m && dist[nx][ny] == -1){
                    dist[nx][ny] = dist[x][y] + 1;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            ArrayList<Integer> row = new ArrayList<>();
            for(int j=0;j<m;j++){
                row.add(dist[i][j]);
            }
            res.add(row);
        }
        
        return res;
    }
}
