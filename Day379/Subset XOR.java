/* Subset XOR
Given an positive integer n, find a subset of numbers from 1 to n (inclusive),
where each number can be used at most once, such that:
The XOR of all elements in the subset is exactly n.
The size of the subset is as large as possible.
If multiple such subsets exist, choose the lexicographically smallest one.
Lexicographical Order : A subset A[] is lexicographically smaller than subset B[]
if at the first index where they differ, A[i] < B[i] (based on character ASCII/Unicode values).
If all elements match but one subset ends earlier, the shorter subset is considered smaller.

Examples:

Input: n = 4
Output: [1, 2, 3, 4]
Explanation: We choose all the elements from 1 to 4.
Its xor value is equal to n. This is the maximum possible size of the subset.

Input: n = 3
Output: [1, 2]
Explanation: 1 ^ 2 = 3,
This is the smallest lexicographical answer possible with maximum size of subset i.e 2.

Constraints:

1 ≤ n ≤ 10^5 */

class Solution {
    public static ArrayList<Integer> subsetXOR(int n) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        int totalXor = xorUpto(n);
        int need = totalXor ^ n;

        if(need == 0){
            for(int i=1;i<=n;i++){
                res.add(i);
            }
            
            return res;
        }

        if(need >= 1 && need <= n){
            for(int i=1;i<=n;i++){
                if(i != need){
                    res.add(i);
                }
            }
            
            return res;
        }

        int removeA = -1, removeB = -1;
        for(int a=1;a<=n;a++){
            int b = a ^ need;
            if(b >= 1 && b <= n && b != a){
                removeA = a;
                removeB = b;
                break;
            }
        }

        for(int i=1;i<=n;i++){
            if(i != removeA && i != removeB){
                res.add(i);
            }
        }

        return res;
    }

    private static int xorUpto(int x){
        if(x % 4 == 0){
            return x;
        }
        
        if(x % 4 == 1){
            return 1;
        }
        
        if(x % 4 == 2){
            return x + 1;
        }
        
        return 0;
    }
}
