/* Max rectangle
You are given a 2D binary matrix mat[ ][ ], where each cell contains either 0 or 1.
Your task is to find the maximum area of a rectangle that can be formed using only 1's within the matrix.

Examples:

Input: mat[][] = [[0, 1, 1, 0],
                  [1, 1, 1, 1],
                  [1, 1, 1, 1],
                  [1, 1, 0, 0]]
Output: 8
Explanation: The largest rectangle with only 1’s is from (1, 0) to (2, 3) which is
[1, 1, 1, 1]
[1, 1, 1, 1]
and area is 4 * 2 = 8.

Input: mat[][] = [[0, 1, 1],
                  [1, 1, 1],
                  [0, 1, 1]]
Output: 6
Explanation: The largest rectangle with only 1’s is from (0, 1) to (2, 2) which is
[1, 1]
[1, 1]
[1, 1]
and area is 2 * 3 = 6.

Constraints:

1 ≤ mat.size(), mat[0].size() ≤ 1000
0 ≤ mat[][] ≤ 1 */


class Solution {
    static int MAH( int []heights, int n){
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int maxArea = 0;
        int area = 0;
        
        while(i < n){
            if(stack.isEmpty() || heights[i] >= heights[stack.peek()]){
                stack.push(i++);
            }else{
                int idx = stack.pop();
                
                if(stack.isEmpty()){
                    area = heights[idx] * i;
                }else{
                    area = heights[idx] * (i - stack.peek() - 1);
                }
                
                maxArea = Math.max(maxArea, area);
            }
        }
        
        while(!stack.isEmpty()){
            int idx = stack.pop();
            
            if(stack.isEmpty()){
                area = heights[idx] * i;
            }else{
                area = heights[idx] * (i - stack.peek() - 1);
            }
            
            maxArea = Math.max(maxArea, area);
        }
        
        return maxArea;
    }
    
    static int maxArea(int mat[][]) {
        // code here
        if(mat.length == 0){
            return 0;
        }
        
        int maxArea = 0;
        int m = mat.length;
        int n = mat[0].length;
        int []heights = new int[n];
        
        for(int col=0;col<n;col++){
            heights[col] = mat[0][col] == 0 ? 0 : 1;
        }
        
        maxArea = MAH(heights, n);
        
        for(int row=1;row<m;row++){
            for(int col=0;col<n;col++){
                if(mat[row][col] == 0){
                    heights[col] = 0;
                }else{
                    heights[col] += 1;
                }
            }
            
            maxArea = Math.max(maxArea, MAH(heights, n));
        }
        
        return maxArea;
    }
}
