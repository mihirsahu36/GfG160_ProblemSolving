/*Set Matrix Zeroes
You are given a 2D matrix mat[][] of size n×m. The task is to modify the matrix such that if mat[i][j] is 0, all the elements in the i-th row and j-th column are set to 0 and do it in constant space complexity.

Examples:

Input: mat[][] = [[1, -1, 1],
                [-1, 0, 1],
                [1, -1, 1]]
Output: [[1, 0, 1],
        [0, 0, 0],
        [1, 0, 1]]
Explanation: mat[1][1] = 0, so all elements in row 1 and column 1 are updated to zeroes.

Input: mat[][] = [[0, 1, 2, 0],
                [3, 4, 5, 2],
                [1, 3, 1, 5]]
Output: [[0, 0, 0, 0],
        [0, 4, 5, 0],
        [0, 3, 1, 0]]
Explanation: mat[0][0] and mat[0][3] are 0s, so all elements in row 0, column 0 and column 3 are updated to zeroes.

Constraints:

1 ≤ n, m ≤ 500
- 2^31 ≤ mat[i][j] ≤ 2^31 - 1*/

// Time Complexity: O(mxn)
// Space Complexity: O(1)

class Solution {
    public void setMatrixZeroes(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int x = 1;
        int y = 1;
        
        for(int i=0;i<m;i++){
            if(mat[i][0] == 0) y = 0; // mark the first column contains zero, marker column
        }
        
        for(int j=0;j<n;j++){
            if(mat[0][j] == 0) x = 0; // mark the first row contains zero, marker row
        }
        
        // the first row and first column are used as markers
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(mat[i][j] == 0){ // if found zero
                    mat[i][0] = 0; // mark the corresponding row
                    mat[0][j] = 0; // mark the corresponding column
                }
            }
        }
        
        for(int j=1;j<n;j++){ // make the column zero based on the markers in first row
            if(mat[0][j] == 0){ // check if the column need to be marked zero
                for(int i=1;i<m;i++){
                    mat[i][j] = 0; // set the entire column to zero
                }
            }
        }
        
        for(int i=1;i<m;i++){ // make the row zero based on the makers in first column
            if(mat[i][0] == 0){ // check if the row need to be marked zeros
                for(int j=1;j<n;j++){
                    mat[i][j] = 0; // set the entire row to zero
                }
            }
        }
        
        if(y == 0){ // if the first column was marked
            for(int i=0;i<m;i++){
                mat[i][0] = 0; // set the entire first column to zero
            }
        }
        
        if(x == 0){ // if first row was marked
            for(int j=0;j<n;j++){
                mat[0][j] = 0; // set the entire first row to zero
            }
        }
    }
}
