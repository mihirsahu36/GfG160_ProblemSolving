/*Find rectangle with corners as 1
Given an n x m binary matrix mat[][] containing only 0s and 1s,
determine if there exists a rectangle within the matrix such that all four corners of the rectangle are 1.
If such a rectangle exists, return true; otherwise, return false.

Example:

Input: mat[][] =
[[1, 0, 0, 1, 0],
[0, 0, 1, 0, 1],
[0, 0, 0, 1, 0], 
[1, 0, 1, 0, 1]] 
Output: true
Explanation: Valid corners are at index (1,2), (1,4), (3,2), (3,4) 

Input: mat[][] =
[[0, 0, 0],
[0, 0, 0],
[0, 0, 0]]
Output: false
Explanation: There are no valid corners.

Constraints:

1 <= n, m <= 200
0 <= mat[i] <= 1*/

class Solution {
    public boolean ValidCorner(int mat[][]) {
        // Code here
        int row = mat.length;
        int col = mat[0].length;
        HashSet<String> set = new HashSet<>();
        
        for(int i=0;i<row;i++){
            ArrayList<Integer> cols = new ArrayList<>();
            
            for(int j=0;j<col;j++){
                if(mat[i][j] == 1){
                    cols.add(j);
                }
            }
            
            for(int x=0;x<cols.size();x++){
                for(int y=x+1;y<cols.size();y++){
                    String pair = cols.get(x) + "_" + cols.get(y);
                    
                    if(set.contains(pair)){
                        return true;
                    }
                    set.add(pair);
                }
            }
        }
        
        return false;
    }
}
