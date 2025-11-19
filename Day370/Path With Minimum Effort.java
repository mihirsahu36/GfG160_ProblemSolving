/* Path With Minimum Effort
You are given a 2D array mat[][], of size n*m.
Your task is to find the minimum possible path cost from the top-left cell (0, 0) to the bottom-right cell (n-1, m-1) by moving up, down, left, or right between adjacent cells.
Note: The cost of a path is defined as the maximum absolute difference between the values of any two consecutive cells along that path.

Examples:

Input: mat[][] = [[7, 2, 6, 5],
               [3, 1, 10, 8]]
Output: 4
Explanation: The route of [7, 3, 1, 2, 6, 5, 8] has a minimum value of maximum absolute difference between any two consecutive cells in the route, i.e., 4.
   
Input: mat[][] = [[2, 2, 2, 1],
               [8, 1, 2, 7],
               [2, 2, 2, 8],
               [2, 1, 4, 7],
               [2, 2, 2, 2]]
Output: 0
Explanation: The route of [2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2] has a minimum value of maximum absolute difference between any two consecutive cells in the route, i.e., 0.
    
Constraints:
1 ≤ n, m ≤ 100
0 ≤ mat[i][j] ≤ 10^6 */

class Solution {
    public int minCostPath(int[][] mat) {
        // code here
        int n = mat.length;
        int m = mat[0].length;
        int [][]effort = new int[n][m];
        
        for(int []row : effort){
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        effort[0][0] = 0;
        pq.offer(new int[]{0, 0, 0});
        int []dr = {-1, 1, 0, 0};
        int []dc = {0, 0, -1, 1};

        while(!pq.isEmpty()){
            int []top = pq.poll();
            int eff = top[0];
            int r = top[1];
            int c = top[2];

            if(r == n - 1 && c == m - 1){
                return eff;
            }

            if(eff > effort[r][c]){
                continue;
            }

            for(int i=0;i<4;i++){
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr >= 0 && nr < n && nc >= 0 && nc < m){
                    int edgeCost = Math.abs(mat[nr][nc] - mat[r][c]);
                    int newEffort = Math.max(eff, edgeCost);

                    if(newEffort < effort[nr][nc]){
                        effort[nr][nc] = newEffort;
                        pq.offer(new int[]{newEffort, nr, nc});
                    }
                }
            }
        }

        return -1;
    }
}
