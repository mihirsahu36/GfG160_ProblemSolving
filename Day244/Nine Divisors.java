/* Nine Divisors
Given a positive integer n, you need to count the numbers less than or equal to n having exactly 9 divisors.

Examples :

Input: n = 100
Output: 2
Explanation: Numbers which have exactly 9 divisors are 36 and 100.

Input: n = 200
Output: 3
Explanation: Numbers which have exactly 9 divisors are 36, 100, 196.

Constraints:

1 ≤ n ≤ 10^9 */

class Solution {
    public static int countNumbers(int n) {
        // code here
        int limit = (int)Math.sqrt(n);
        boolean []isPrime = new boolean[limit+1];
        Arrays.fill(isPrime, true);
        
        isPrime[0] = false;
        isPrime[1] = false;
        
        for(int i=2;i*i<=limit;i++){
            if(isPrime[i]){
                for(int j=i*i;j<=limit;j+=i){
                    isPrime[j] = false;
                }
            }
        }
        
        List<Integer> primes = new ArrayList<>();
        for(int i=2;i<=limit;i++){
            if(isPrime[i]){
                primes.add(i);
            }
        }
        
        int count = 0;
        
        for(int p : primes){
            long val = (long)(long)Math.pow(p, 8);
            if(val <= n){
                count++;
            }else{
                break;
            }
        }
        
        int size = primes.size();
        for(int i=0;i<size;i++){
            long p2 = (long)primes.get(i) * primes.get(i);
            for(int j=i+1;j<size;j++){
                long q2 = (long)primes.get(j) * primes.get(j);
                
                if(p2 * q2 <= n){
                    count++;
                }else{
                    break;
                }
            }
        }
        
        return count;
    }
}
