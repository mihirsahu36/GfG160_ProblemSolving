/*Largest number in K swaps
Given a number k and string s of digits denoting a positive integer, build the largest number possible by performing swap operations on the digits of s at most k times.

Examples :

Input: s = "1234567", k = 4
Output: 7654321
Explanation: Three swaps can make the input 1234567 to 7654321, swapping 1 with 7, 2 with 6 and finally 3 with 5.

Input: s = "3435335", k = 3
Output: 5543333
Explanation: Three swaps can make the input 3435335 to 5543333, swapping 3 with 5, 4 with 5 and finally 3 with 4.

Input: s = "1034", k = 2
Output: 4301
Explanation: Two swaps can make the input 1034 to 4301, swapping 1 with 4 and finally 0 with 3.

Constraints:

1 ≤ s.size() ≤ 15
1 ≤ k ≤ 7 */

// Approach 1 (TLE)
class Solution {
    // Function to find the largest number after k swaps.
    public String findMaximumNum(String s, int k) {
        // code here.
        int n = s.length();
        String res = s;
        
        if(k == 0){
            return s;
        }
        
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(s.charAt(i) < s.charAt(j)){
                    s = swap(s, i, j);
                    
                    String recRes = findMaximumNum(s, k - 1);
                    if(recRes.compareTo(res) > 0){
                        res = recRes;
                    }
                    
                    s = swap(s, i, j);
                }
            }
        }
        
        return res;
    }
    
    public String swap(String s, int i, int j){
        char []arr = s.toCharArray();
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        
        return new String(arr);
    }
}

// Approach 2
class Solution {
    String res;
    
    private void solve(char []s, int k, int idx){
        if(k == 0 || idx == s.length){
            return;
        }
        
        char maxChar = s[idx];
        
        for(int i=idx+1;i<s.length;i++){
            if(s[i] > maxChar){
                maxChar = s[i];
            }
        }
        
        boolean shouldReduce = (maxChar != s[idx]);
        for(int j=s.length-1;j>=idx+1;j--){
            if(s[j] == maxChar){
                swap(s, idx, j);
                
                String curr = new String(s);
                if(curr.compareTo(res) > 0){
                    res = curr;
                }
                
                solve(s, shouldReduce ? k - 1 : k, idx + 1);
                
                swap(s, idx, j);
            }
        }
        
        if(!shouldReduce){
            solve(s, k, idx + 1);
        }
    }
    public String findMaximumNum(String s, int k) {
        // code here.
        res = s;
        solve(s.toCharArray(), k, 0);
        
        return res;
    }
    
    private void swap(char []s, int i, int j){
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}
