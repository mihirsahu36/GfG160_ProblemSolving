/* Maximum sum Rectangle
Given a 2D matrix mat[][] with dimensions n×m. Find the maximum possible sum of any submatrix within the given matrix.

Examples:

Input: mat[][] = [[1, 2, -1, -4, -20], [-8, -3, 4, 2, 1], [3, 8, 10, 1, 3], [-4, -1, 1, 7, -6]]
Output: 29
Explanation: The matrix is as follows and the green rectangle denotes the maximum sum rectangle which is equal to 29.

Input: mat[][] = [[-1, -2], [-3, -4]]
Output: -1
Explanation: Taking only the first cell is the optimal choice.

Constraints:

1 ≤ n, m ≤ 300
-1000 ≤ mat[i][j] ≤ 1000 */

class Solution {
    private int getMaxSum(int []temp){
        int n = temp.length;
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        
        for(int i=0;i<n;i++){
            currSum += temp[i];
            
            if(maxSum < currSum){
                maxSum = currSum;
            }
            
            if(currSum < 0){
                currSum = 0;
            }
        }
        
        return maxSum;
    }
    
    public int maxRectSum(int mat[][]) {
        // code here
        int n = mat.length;
        int m = mat[0].length;
        int maxSum = Integer.MIN_VALUE;
        int []temp = new int[n];
        
        for(int left=0;left<m;left++){
            for(int i=0;i<n;i++){
                temp[i] = 0;
            }
            
            for(int right=left;right<m;right++){
                for(int j=0;j<n;j++){
                    temp[j] += mat[j][right];
                }
                
                int sum = getMaxSum(temp);
                maxSum = Math.max(maxSum, sum);
            }
        }
        
        return maxSum;
    }
};
