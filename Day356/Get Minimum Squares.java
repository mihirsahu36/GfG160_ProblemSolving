/* Get Minimum Squares
Given a positive integer n, find the minimum number of perfect squares (square of an integer) that sum up to n.
Note: Every positive integer can be expressed as a sum of square numbers since 1 is a perfect square,
and any number can be represented as 1*1 + 1*1 + 1*1 + ....

Examples:

Input: n = 100
Output: 1
Explanation: 10 * 10 = 100

Input: n = 6
Output: 3
Explanation = 1 * 1 + 1 * 1 + 2 * 2 = 6 

Constraints:

1 ≤ n ≤ 10^4 */

class Solution {
    private static boolean isPerfectSquare(int x){
        int r = (int)Math.sqrt(x);
        
        return r * r == x;
    }
    
    public int minSquares(int n) {
        // Code here
        if(n <= 0){
            return 0;
        }
        
        if(isPerfectSquare(n)){
            return 1;
        }
        
        for(int i=1;i*i<=n;i++){
            int rem = n - i * i;
            if(isPerfectSquare(rem)){
                return 2;
            }
        }
        
        int temp = n;
        while(temp % 4 == 0){
            temp /= 4;
        }
        
        if((temp % 8 == 7)){
            return 4;
        }
        
        return 3;
    }
}
