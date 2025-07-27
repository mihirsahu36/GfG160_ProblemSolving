/* Set Matrix Zeros
Difficulty: MediumAccuracy: 52.54%Submissions: 46K+Points: 4
You are given a 2D matrix mat[][] of size n x m. The task is to modify the matrix such that if mat[i][j] is 0, all the elements in the i-th row and j-th column are set to 0.

Examples:
Input:  1 -1 1
        -1 0 1
        1 -1 1
Output: 1 0 1
        0 0 0
        1 0 1
Explanation: mat[1][1] = 0, so all elements in row 1 and column 1 are updated to zeroes.

Input:   0 1 2 0
         1 2 6 2
         1 3 1 8
Output:  0 0 0 0
         0 2 6 0
         0 3 1 0
Explanation: mat[0][0] and mat[0][3] are 0s, so all elements in row 0, column 0 and column 3 are updated to zeroes.

Constraints:

1 ≤ n, m ≤ 500
- 2^31 ≤ mat[i][j] ≤ 2^31 - 1 */

class Solution {
    public void setMatrixZeroes(int[][] mat) {
        // code here
        int n = mat.length;
        int m = mat[0].length;
        
        boolean firstRowZero = false;
        boolean firstColZero = false;
        
        for(int j=0;j<m;j++){
            if(mat[0][j] == 0){
                firstRowZero = true;
                break;
            }
        }
        
        for(int i=0;i<n;i++){
            if(mat[i][0] == 0){
                firstColZero = true;
                break;
            }
        }
        
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(mat[i][j] == 0){
                    mat[i][0] = 0;
                    mat[0][j] = 0;
                }
            }
        }
        
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(mat[i][0] == 0 || mat[0][j] == 0){
                    mat[i][j] = 0;
                }
            }
        }
        
        if(firstRowZero){
            for(int j=0;j<m;j++){
                mat[0][j] = 0;
            }
        }
        
        if(firstColZero){
            for(int i=0;i<n;i++){
                mat[i][0] = 0;
            }
        }
    }
}
