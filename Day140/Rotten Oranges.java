/*Rotten Oranges
Given a matrix mat[][] of dimension n * m where each cell in the matrix can have values 0, 1 or 2 which has the following meaning:
0 : Empty cell
1 : Cell have fresh oranges
2 : Cell have rotten oranges
We have to determine what is the earliest time after which all the oranges are rotten.
A rotten orange at index (i, j) can rot other fresh orange at indexes (i-1, j), (i+1, j), (i, j-1), (i, j+1) (up, down, left and right) in a unit time.
Note: Your task is to return the minimum time to rot all the fresh oranges. If not possible returns -1.

Examples:

Input: mat[][] = [[0, 1, 2], [0, 1, 2], [2, 1, 1]]
Output: 1
Explanation: Oranges at positions (0,2), (1,2), (2,0) will rot oranges at (0,1), (1,1), (2,2) and (2,1) in unit time.

Input: mat[][] = [[2, 2, 0, 1]]
Output: -1
Explanation: Oranges at (0,0) and (0,1) can't rot orange at (0,3).

Input: mat[][] = [[2, 2, 2], [0, 2, 0]]
Output: 0
Explanation: There is no fresh orange. 

Constraints:

1 ≤ mat.size() ≤ 500
1 ≤ mat[0].size() ≤ 500
mat[i][j] = {0, 1, 2} */

class Solution {
    public int orangesRotting(int[][] mat) {
        // Code here
        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j] == 2){
                    queue.offer(new int[]{i, j});
                }else if(mat[i][j] == 1){
                    freshCount++;
                }
            }
        }
        
        if(freshCount == 0){
            return 0;
        }
        
        int [][]directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int time = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                int []curr = queue.poll();
                int x = curr[0];
                int y = curr[1];
                
                for(int []dir : directions){
                    int newX = x + dir[0];
                    int newY = y + dir[1];
                    
                    if(newX >= 0 && newX < m && newY >= 0 && newY < n && mat[newX][newY] == 1){
                        mat[newX][newY] = 2;
                        queue.offer(new int[]{newX, newY});
                        freshCount--;
                    }
                }
            }
            time++;
        }
        
        return freshCount == 0 ? time - 1 : -1;
    }
}
