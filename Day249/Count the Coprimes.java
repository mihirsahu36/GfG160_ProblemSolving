/* Count the Coprimes
You are given an array arr[] of positive integers. Your task is to count the number of pairs (i, j) such that:
0 ≤ i < j ≤ n-1
gcd(arr[i], arr[j]) = 1
In other words, count the number of unordered pairs of indices (i, j) where the elements at those positions are co-prime.

Examples:

Input: arr[] = [1, 2, 3]
Output: 3
Explanation: (0,1), (0,2), (1,2) are the pair of indices where gcd(arr[i], arr[j]) = 1

Input: arr[] = [4, 8, 3, 9]
Output: 4
Explanation: (0,2), (0,3), (1,2), (1,3) are the pair of indices where gcd(arr[i], arr[j]) = 1

Constraints:

2 ≤ arr.size() ≤ 10^4
1 ≤ arr[i] ≤ 10^4 */

class Solution {
    final int MAX = 10001;
    
    int cntCoprime(int[] arr) {
        // code here
        int n = arr.length;
        int []freq = new int[MAX];
        
        for(int val : arr){
            freq[val]++;
        }
        
        int []mobius = new int[MAX];
        for(int i=0;i<MAX;i++){
            mobius[i] = 1;
        }
        
        boolean []isPrime = new boolean[MAX];
        Arrays.fill(isPrime, true);
        
        for(int i=2;i<MAX;i++){
            if(isPrime[i]){
                for(int j =i;j<MAX;j+=i){
                    mobius[j] *= -1;
                    isPrime[j] = false;
                }
                
                for(int j=i*i;j<MAX;j+=i*i){
                    mobius[j] = 0;
                }
            }
        }
        
        int []divCount = new int[MAX];
        for(int i=1;i<MAX;i++){
            for(int j=i;j<MAX;j+=i){
                divCount[i] += freq[j];
            }
        }
        
        long res = 0;
        for(int i=1;i<MAX;i++){
            int count = divCount[i];
            
            if(count >= 2 && mobius[i] != 0){
                res += mobius[i] * (long)count * (count - 1) / 2;
            }
        }
        
        return (int)res;
    }
}
