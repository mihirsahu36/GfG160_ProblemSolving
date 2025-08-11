/* Maximum Non-Overlapping Odd Palindrome Sum
Given a string s consisting of lowercase English letters, find the maximum possible sum of the lengths of any two non-empty and non-overlapping palindromic substrings of odd length.
Formally, choose any two substrings s[i...j] and s[k...l] such that 1 ≤ i ≤ j < k ≤ l ≤ s.size(), both substrings are palindromes of odd length, and they do not overlap.
Return the maximum sum of their lengths.
Note: A palindrome is a string that reads the same forward and backward. A substring is a contiguous sequence of characters within the string.

Examples:

Input: s = "xyabacbcz"
Output: 6
Explanation: "aba" and "cbc" are non-overlapping odd-length palindromes. Their lengths are 3 and 3 which gives the sum as 6.

Input: s = "gfgforgeeks"
Output: 4
Explanation: "gfg" and "g" are non-overlapping odd-length palindromes. Their lengths are 3 and 1 which gives the sum as 4.

Constraints:
2 ≤ s.size() ≤ 10^5 */

class Solution {
    private static final int BASE = 911;
    private static final int MOD = (int)1e9 + 7;
    
    private static class RollingHash{
        long []hash;
        long []power;
        
        public RollingHash(String s){
            int n = s.length();
            hash = new long[n+1];
            power = new long[n+1];
            hash[0] = 0;
            power[0] = 1;
            
            for(int i=0;i<n;i++){
                hash[i+1] = (hash[i] * BASE + s.charAt(i)) % MOD;
                power[i+1] = (power[i] * BASE) % MOD;
            }
        }
        
        public long getHash(int l, int r){
            long val = (hash[r+1] - (hash[l] * power[r-l+1]) % MOD + MOD) % MOD;
            return val;
        }
    }
    
    private boolean isPalindrome(int l, int r, RollingHash fHash, RollingHash rHash, int n){
        long h1 = fHash.getHash(l, r);
        long h2 = rHash.getHash(n - 1 - r, n - 1 - l);
        return h1 == h2;
    }
    
    public int maxSum(String s) {
        // code here
        int n = s.length();
        RollingHash fHash = new RollingHash(s);
        String rev = new StringBuilder(s).reverse().toString();
        RollingHash rHash = new RollingHash(rev);
        
        int []leftMax = new int[n];
        Arrays.fill(leftMax, 1);
        
        int []rightMax = new int[n];
        Arrays.fill(rightMax, 1);
        
        for(int i=0;i<n;i++){
            int l = 0, r = Math.min(i, n - 1 - i);
            int best = 1;
            
            while(l <= r){
                int m = l + (r - l) / 2;
                int start = i - m;
                int end = i + m;
                if(isPalindrome(start, end, fHash, rHash, n)){
                    best = 2 * m + 1;
                    l = m + 1;
                }else{
                    r = m - 1;
                }
            }
            
            int endIdx = i + best / 2;
            if(endIdx < n){
                leftMax[endIdx] = Math.max(leftMax[endIdx], best);
            }
        }
        
        for(int i=n-2;i>=0;i--){
            leftMax[i] = Math.max(leftMax[i], leftMax[i+1] - 2);
        }
        
        for(int i=1;i<n;i++){
            leftMax[i] = Math.max(leftMax[i], leftMax[i-1]);
        }
        
        for(int i=n-1;i>=0;i--){
            int l = 0, r = Math.min(i, n - 1 - i);
            int best = 1;
            
            while(l <= r){
                int m = (l + r) / 2;
                int start = i - m;
                int end = i + m;
                if(isPalindrome(start, end, fHash, rHash, n)){
                    best = 2 * m + 1;
                    l = m + 1;
                }else{
                    r = m - 1;
                }
            }
            
            int startIdx = i - best / 2;
            if(startIdx >= 0){
                rightMax[startIdx] = Math.max(rightMax[startIdx], best);
            }
        }
        
        for(int i=1;i<n;i++){
            rightMax[i] = Math.max(rightMax[i], rightMax[i-1] - 2);
        }
        
        for(int i=n-2;i>=0;i--){
            rightMax[i] = Math.max(rightMax[i], rightMax[i+1]);
        }
        
        int res = 0;
        for(int i=0;i+1<n;i++){
            res = Math.max(res, leftMax[i] + rightMax[i+1]);
        }
        
        return res;
    }
}
