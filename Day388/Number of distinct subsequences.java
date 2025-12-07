/* Number of distinct subsequences
Given a string str consisting of lowercase english alphabets,
the task is to find the number of distinct subsequences of the string
Note: Answer can be very large, so, ouput will be answer modulo 109+7.

Examples:

Input: str = "gfg"
Output: 7
Explanation: 
The seven distinct subsequences are "", "g", "f", "gf", "fg", "gg" and "gfg" .

Input: str = "ggg"
Output: 4
Explanation: 
The four distinct subsequences are "", "g", "gg", "ggg".

Constraints:

1 ≤ |str| ≤ 10^5
str contains lower case English alphabets */

class Solution {
    int distinctSubseq(String str) {
        // code here
        int n = str.length();
        int MOD = 1_000_000_007;
        int []dp = new int[n + 1];

        dp[0] = 1;

        int []last = new int[26];
        Arrays.fill(last, -1);

        for(int i=1;i<=n;i++){
            dp[i] = (2 * dp[i - 1]) % MOD;
            int idx = str.charAt(i - 1) - 'a';
            if(last[idx] != -1){
                dp[i] = (dp[i] - dp[last[idx]] + MOD) % MOD;
            }
            
            last[idx] = i - 1;
        }

        return dp[n];
    }
}
