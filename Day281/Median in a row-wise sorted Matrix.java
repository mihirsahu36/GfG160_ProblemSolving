/* Median in a row-wise sorted Matrix
Given a row-wise sorted matrix mat[][] of size n*m, where the number of rows and columns is always odd. Return the median of the matrix.

Examples:

Input: mat[][] = [[1, 3, 5], 
                [2, 6, 9], 
                [3, 6, 9]]
Output: 5
Explanation: Sorting matrix elements gives us [1, 2, 3, 3, 5, 6, 6, 9, 9]. Hence, 5 is median.

Input: mat[][] = [[2, 4, 9],
                [3, 6, 7],
                [4, 7, 10]]
Output: 6
Explanation: Sorting matrix elements gives us [2, 3, 4, 4, 6, 7, 7, 9, 10]. Hence, 6 is median.

Input: mat = [[3], [4], [8]]
Output: 4
Explanation: Sorting matrix elements gives us [3, 4, 8]. Hence, 4 is median.

Constraints:

1 ≤ n, m ≤ 400
1 ≤ mat[i][j] ≤ 2000 */

class Solution {
    public int median(int[][] mat) {
        // code here
        int n = mat.length;
        int m = mat[0].length;
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;
        
        for(int i=0;i<n;i++){
            minVal = Math.min(minVal, mat[i][0]);
            maxVal = Math.max(maxVal, mat[i][m-1]);
        }
        
        int desired = (n * m + 1) / 2;
        
        while(minVal < maxVal){
            int midVal = minVal + (maxVal - minVal) / 2;
            int place = 0;
            for(int i=0;i<n;i++){
                place += upperBound(mat[i], midVal);
            }
            
            if(place < desired){
                minVal = midVal + 1;
            }else{
                maxVal = midVal;
            }
        }
        
        return minVal;
    }
    
    private int upperBound(int []row, int target){
        int low = 0, high = row.length;
        while(low < high){
            int mid = low + (high - low) / 2;
            if(row[mid] <= target){
                low = mid + 1;
            }else{
                high = mid;
            }
        }
        
        return low;
    }
}
