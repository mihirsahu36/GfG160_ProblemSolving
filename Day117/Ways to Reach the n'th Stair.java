/*Ways to Reach the n'th Stair
There are n stairs, a person standing at the bottom wants to reach the top. The person can climb either 1 stair or 2 stairs at a time.
Your task is to count the number of ways, the person can reach the top (order does matter).

Examples:

Input: n = 1
Output: 1
Explanation: There is only one way to climb 1 stair. 

Input: n = 2
Output: 2
Explanation: There are 2 ways to reach 2th stair: {1, 1} and {2}.  

Input: n = 4
Output: 5
Explanation: There are five ways to reach 4th stair: {1, 1, 1, 1}, {1, 1, 2}, {2, 1, 1}, {1, 2, 1} and {2, 2}.

Constraints:

1 ≤ n ≤ 44*/

class Solution {
    int solve(int n, int []t){
        if(n == 0){
            return 1;
        }
        
        if(n < 0){
            return 0;
        }
        
        if(t[n] != -1){
            return t[n];
        }
        
        return t[n] = solve(n - 1, t) + solve(n - 2, t);
    }
    
    int countWays(int n) {
        // your code here
        int []t = new int[n+1];
        Arrays.fill(t, -1);
        
        return solve(n, t);
    }
}
