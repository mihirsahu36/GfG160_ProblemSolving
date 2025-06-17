/*Find all possible palindromic partitions of a String
Given a string s, find all possible ways to partition it such that every substring in the partition is a palindrome.

Examples:

Input: s = "geeks"
Output: [[g, e, e, k, s], [g, ee, k, s]]
Explanation: [g, e, e, k, s] and [g, ee, k, s] are the only partitions of "geeks" where each substring is a palindrome.

Input: s = "abcba"
Output: [[a, b, c, b, a], [a, bcb, a], [abcba]]
Explanation: [a, b, c, b, a], [a, bcb, a] and [abcba] are the only partitions of "abcba" where each substring is a palindrome.

Constraints:

1 ≤ s.size() ≤ 20 */

class Solution {
    private int n;
    
    private boolean isPalindrome(String s, int i, int j){
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        
        return true;
    }
    
    private void solve(String s, int idx, ArrayList<String> curr, ArrayList<ArrayList<String>> res){
        if(idx == n){
            res.add(new ArrayList<>(curr));
            return;
        }
        
        for(int i=idx;i<n;i++){
            if(isPalindrome(s, idx, i)){
                curr.add(s.substring(idx, i + 1));
                solve(s, i + 1, curr, res);
                curr.remove(curr.size() - 1);
            }
        }
    }
    
    public ArrayList<ArrayList<String>> palinParts(String s) {
        // code here
        n = s.length();
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        ArrayList<String> curr = new ArrayList<>();
        
        solve(s, 0, curr, res);
        
        return res;
    }
}
