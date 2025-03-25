/*Boolean Parenthesization
You are given a boolean expression s containing
    'T' ---> true
    'F' ---> false 
and following operators between symbols
   &   ---> boolean AND
    |   ---> boolean OR
   ^   ---> boolean XOR
Count the number of ways we can parenthesize the expression so that the value of expression evaluates to true.
Note: The answer is guaranteed to fit within a 32-bit integer.

Examples:

Input: s = "T|T&F^T"
Output: 4
Explaination: The expression evaluates to true in 4 ways: ((T|T)&(F^T)), (T|(T&(F^T))), (((T|T)&F)^T) and (T|((T&F)^T)).

Input: s = "T^F|F"
Output: 2
Explaination: The expression evaluates to true in 2 ways: ((T^F)|F) and (T^(F|F)).

Constraints:

1 ≤ |s| ≤ 100 */

class Solution {
    static int solve(int i, int j, int req, String s, int [][][]t){
        if(i == j){
            return (req == (s.charAt(i) == 'T' ? 1 : 0)) ? 1 : 0;
        }
        
        if(t[i][j][req] != -1){
            return t[i][j][req];
        }
        
        int ways = 0;
        for(int k=i+1;k<j;k+=2){
            int leftT = solve(i, k - 1, 1, s, t);
            int leftF = solve(i, k - 1, 0, s, t);
            int rightT = solve(k + 1, j, 1, s, t);
            int rightF = solve(k + 1, j, 0, s, t);
            
            char op = s.charAt(k);
            if(op == '&'){
                if(req == 1){
                    ways += leftT * rightT;
                }else{
                    ways += (leftF * rightF) + (leftT * rightF) + (leftF * rightT);
                }
            }else if(op == '|'){
                if(req == 1){
                    ways += (leftT * rightT) + (leftT * rightF) + (leftF * rightT);
                }else{
                    ways += leftF * rightF;
                }
            }else if(op == '^'){
                if(req == 1){
                    ways += (leftT * rightF) + (leftF * rightT);
                }else{
                    ways += (leftT * rightT) + (leftF * rightF);
                }
            }
        }
        
        return t[i][j][req] = ways;
    }
    
    static int countWays(String s) {
        // code here
        int n = s.length();
        int [][][]t = new int[n][n][2];
        
        for (int [][]m : t) {
            for (int []row : m) {
                Arrays.fill(row, -1);
            }
        }
        
        return solve(0, n - 1, 1, s, t);
    }
}
