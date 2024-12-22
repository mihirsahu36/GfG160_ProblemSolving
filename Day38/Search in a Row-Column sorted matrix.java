/*Search in a Row-Column sorted matrix
Given a 2D integer matrix mat[][] of size n x m, where every row and column is sorted in increasing order and a number x, the task is to find whether element x is present in the matrix.

Examples:

Input: mat[][] = [[3, 30, 38],[20, 52, 54],[35, 60, 69]], x = 62
Output: false
Explanation: 62 is not present in the matrix, so output is false.

Input: mat[][] = [[18, 21, 27],[38, 55, 67]], x = 55
Output: true
Explanation: 55 is present in the matrix.

Input: mat[][] = [[1, 2, 3],[4, 5, 6],[7, 8, 9]], x = 3
Output: true
Explanation: 3 is present in the matrix.

Constraints:

1 <= n, m <=1000
1 <= mat[i][j] <= 10^9
1<= x <= 10^9*/

class Solution {
    public static boolean matSearch(int mat[][], int x) {
        // your code here
        int i = 0, j = mat[0].length - 1;
        
        while(i < mat.length && j >= 0){ // traverse the matrix
            if(mat[i][j] == x){ // current element matches the target
                return true;
            }
            if(mat[i][j] > x){ // if current element is greater than target then move left in current row
                j--;
            }else{ // otherwise move down to the next row
                i++;
            }
        }
        return false;
    }
}
