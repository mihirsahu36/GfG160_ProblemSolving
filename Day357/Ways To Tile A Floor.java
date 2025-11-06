/* Ways To Tile A Floor
Given a floor of dimensions 2 x n and tiles of dimensions 2 x 1, the task is to find the number of ways the floor can be tiled.
A tile can either be placed horizontally i.e as a 1 x 2 tile or vertically i.e as 2 x 1 tile. 
Note: Two tiling arrangements are considered different if the placement of at least one tile differs.

Examples :

Input: n = 3
Output: 3
Explanation: We need 3 tiles to tile the board of size 2 x 3.
We can tile in following ways:
1) Place all 3 tiles vertically.
2) Place first tile vertically and remaining 2 tiles horizontally.
3) Place first 2 tiles horizontally and remaining tiles vertically.

Input: n = 4
Output: 5
Explanation: We need 4 tiles to tile the board of size 2 x 4.
We can tile in following ways:
1) All 4 vertical
2) All 4 horizontal
3) First 2 vertical, remaining 2 horizontal.
4) First 2 horizontal, remaining 2 vertical.
5) Corner 2 vertical, middle 2 horizontal.

Constraints:
1 ≤ n ≤ 45 */

class Solution {
    public int numberOfWays(int n) {
        // code here
        if(n == 1){
            return 1;
        }
        
        if(n == 2){
            return 2;
        }
        
        int prev2 = 1;
        int prev1 = 2;
        int curr = 0;
        
        for(int i=3;i<=n;i++){
            curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        
        return curr;
    }
};
