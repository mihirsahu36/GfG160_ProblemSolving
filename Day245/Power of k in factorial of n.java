/* Power of k in factorial of n
Given two positive integers n and k, determine the highest value of x such that kx divides n! (n factorial) completely (i.e., n % (kx) == 0).

Examples :

Input: n = 7, k = 2
Output: 4
Explanation: 7! = 5040, and 24 = 16 is the highest power of 2 that divides 5040.

Input: n = 10, k = 9
Output: 2
Explanation: 10! = 3628800, and 9² = 81 is the highest power of 9 that divides 3628800.

Constraints:

1 ≤ n ≤ 10^5
2 ≤ k ≤ 10^5 */

class Solution {
    public int maxKPower(int n, int k) {
        // code here
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=2;i*i<=k;i++){
            while(k % i == 0){
                map.put(i, map.getOrDefault(i, 0) + 1);
                k /= i;
            }
        }
        
        if(k > 1){
            map.put(k, map.getOrDefault(k, 0) + 1);
        }
        
        int res = Integer.MAX_VALUE;
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int prime = entry.getKey();
            int expInK = entry.getValue();
            int powInFact = 0;
            int temp = n;
            
            while(temp > 0){
                powInFact += temp / prime;
                temp /= prime;
            }
            
            res = Math.min(res, powInFact / expInK);
        }
        
        return res;
    }
}
