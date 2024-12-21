/*Rotate by 90 degree
Given a square matrix mat[][] of size n x n. The task is to rotate it by 90 degrees in an anti-clockwise direction without using any extra space. 

Examples:

Input: mat[][] = [[1, 2, 3],
                [4, 5, 6]
                [7, 8, 9]]
Output: Rotated Matrix:
[3, 6, 9]
[2, 5, 8]
[1, 4, 7]

Input: mat[][] = [[1, 2],
                [3, 4]]
Output: Rotated Matrix:
[2, 4]
[1, 3]

Constraints:

1 ≤ n ≤ 10^2
0 <= mat[i][j] <= 10^3*/

class Solution {
    // Function to rotate matrix anticlockwise by 90 degrees.
    static void rotateby90(int mat[][]) {
        // code here
        int n = mat.length;
        
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                swap(mat, i, j);
            }
        }
        
        for(int i=0;i<(n/2);i++){ // interchanging the rows of the transpose matrix to make it 90 degree anticlockwise
            for(int j=0;j<n;j++){
                int temp = mat[i][j];
                mat[i][j] = mat[n-1-i][j];
                mat[n-1-i][j] = temp;
            }
        }
    }
    
    static void swap(int mat[][], int i, int j){ // transpose the matrix
        int temp = mat[i][j];
        mat[i][j] = mat[j][i];
        mat[j][i] = temp;
    }
}
