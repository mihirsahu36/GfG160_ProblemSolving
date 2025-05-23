/*Dice throw
Given n dice each with m faces. Find the number of ways to get sum x which is the summation of values on each face when all the dice are thrown.

Example:

Input: m = 6, n = 3, x = 12
Output: 25
Explanation: There are 25 total ways to get the Sum 12 using 3 dices with faces from 1 to 6.

Input: m = 2, n = 3, x = 6
Output: 1
Explanation: There is only 1 way to get the Sum 6 using 3 dices with faces from 1 to 2. All the dices will have to land on 2.

Constraints:

1 <= m,n,x <= 50*/

class Solution {
    static int [][]t = new int[51][51];
    
    static int solve(int m, int n, int x){
        if(x < 0){
            return 0;
        }
        
        if(t[n][x] != -1){
            return t[n][x];
        }
        
        if(n == 0 && x == 0){
            return 1;
        }
        
        if(n == 0){
            return 0;
        }
        
        int res = 0;
        for(int val=1;val<=m;val++){
            res += solve(m, n - 1, x - val);
        }
        
        return t[n][x] = res;
    }
    
    static int noOfWays(int m, int n, int x) {
        // code here
        for(int i=0;i<=50;i++){
            for(int j=0;j<=50;j++){
                t[i][j] = -1;
            }
        }
        
        return solve(m, n, x);
    }
};
