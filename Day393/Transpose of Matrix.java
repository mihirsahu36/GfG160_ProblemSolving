/* Transpose of Matrix
You are given a square matrix of size n x n.
Your task is to find the transpose of the given matrix.
The transpose of a matrix is obtained by converting all the rows to columns and all the columns to rows.

Examples :

Input: mat[][] = [[1, 1, 1, 1],
                [2, 2, 2, 2],
                [3, 3, 3, 3],
                [4, 4, 4, 4]]
Output: [[1, 2, 3, 4],
       [1, 2, 3, 4],
       [1, 2, 3, 4],
       [1, 2, 3, 4]]
Explanation: Converting rows into columns and columns into rows.

Input: mat[][] =  [[1, 2],
                 [9, -2]]
Output: [[1, 9],
        [2, -2]]
Explanation: Converting rows into columns and columns into rows.

Constraints:

1 ≤ n ≤ 10^3
-10^9 ≤ mat[i][j] ≤10^9 */

class Solution {
    public ArrayList<ArrayList<Integer>> transpose(int[][] mat) {
        // code here
        int n = mat.length;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        for(int i=0;i<n;i++){
            ArrayList<Integer> row = new ArrayList<>();
            for(int j=0;j<n;j++){
                row.add(mat[j][i]);
            }
            res.add(row);
        }
        
        return res;
    }
  }
