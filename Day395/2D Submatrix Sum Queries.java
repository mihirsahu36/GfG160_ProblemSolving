/* 2D Submatrix Sum Queries
Given a 2D integer matrix mat[][] and a list of queries queries[][], your task is to answer a series of submatrix sum queries.
Each query is represented as a list [r1, c1, r2, c2], where:
(r1, c1) is the top-left coordinate of the submatrix
(r2, c2) is the bottom-right coordinate of the submatrix (both inclusive)
Your task is to return a list of integers, the sum of elements within the specified submatrix for each query.

Examples: 

Input: mat[][] = [[1, 2, 3], queries[][] = [[0, 0, 1, 1], [1, 0, 2, 2]]
                [1, 1, 0],
                [4, 2, 2]]
Output: [5, 10]
Explanation: 
Query 1 selects submatrix [[1, 2], [1, 1]] → sum = 5.
Query 2 selects submatrix [[1, 1, 0], [4, 2, 2]] → sum = 10.

Input: mat[][] = [[1, 1, 1], queries[][] = [[1, 1, 2, 2], [0, 0, 2, 2], [0, 2, 2, 2]]
                [1, 1, 1],
                [1, 1, 1]]
Output: [4, 9, 3]
Explanation: 
Query 1 selects submatrix [[1, 1], [1, 1]] → sum = 4.
Query 2 selects submatrix [[1, 1, 1], [1, 1, 1], [1, 1, 1]] → sum = 9.
Query 3 selects submatrix [[1], [1], [1]] → sum = 3.

Constraints:

1 ≤ n × m, q ≤ 10^5
0 ≤ mat[i][j] ≤ 10^4
0 ≤ r1 ≤ r2 ≤ n - 1
0 ≤ c1 ≤ c2 ≤ m - 1 */

class Solution {
    public ArrayList<Integer> prefixSum2D(int[][] mat, int[][] queries) {
        // code here
        int n = mat.length;
        int m = mat[0].length;

        int [][]pre = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                pre[i][j]=mat[i][j];
                if(i > 0){
                    pre[i][j] += pre[i-1][j];
                }
                if(j > 0){
                    pre[i][j] += pre[i][j-1];
                }
                if(i > 0 && j > 0){
                    pre[i][j] -= pre[i-1][j-1];
                }
            }
        }

        ArrayList<Integer> res = new ArrayList<>();

        for(int i=0;i<queries.length;i++){
            int r1 = queries[i][0];
            int c1 = queries[i][1];
            int r2 = queries[i][2];
            int c2 = queries[i][3];

            int sum = pre[r2][c2];
            if(r1 > 0){
                sum -= pre[r1-1][c2];
            }
            if(c1 > 0){
                sum -= pre[r2][c1-1];
            }
            if(r1 > 0 && c1 > 0){
                sum += pre[r1-1][c1-1];
            }

            res.add(sum);
        }

        return res;
    }
}
