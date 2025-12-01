/* XOR Pairs less than K
Given an array arr[] and an integer k,
we need to count the number of pairs from the given array such that the Bitwise XOR of each pair is less than k.

Examples:

Input: arr = [1, 2, 3, 5], k = 5 
Output: 4
Explanation: Bitwise XOR of all possible pairs that satisfy the given conditions are:
arr[0] ^ arr[1] = 1 ^ 2 = 3 
arr[0] ^ arr[2] = 1 ^ 3 = 2 
arr[0] ^ arr[3] = 1 ^ 5 = 4 
arr[1] ^ arr[2] = 2 ^ 3 = 1 
Therefore, the required output is 4.

Input: arr[] = [3, 5, 6, 8], k = 7 
Output: 3
Explnation: Bitwise XOR of all possible pairs that satisfy the given conditions are:
arr[0] ^ arr[1] = 6
arr[0] ^ arr[2] = 5
arr[1] ^ arr[2] = 3
Therefore, the required output is 3. 

Constraints:

1 ≤ arr.size(), k ≤ 5*10^4
1 ≤ arr[i] ≤ 5*10^4 */

class TrieNode{
    TrieNode []child = new TrieNode[2];
    int cnt;

    TrieNode(){
        child[0] = child[1] = null;
        cnt = 0;
    }
}

class Solution {
    static void insertTrie(TrieNode root, int n){

        for(int i=31;i>=0;i--){
            boolean x = (n & (1 << i)) != 0;

            if(root.child[x ? 1 : 0] == null){
                root.child[x ? 1 : 0] = new TrieNode();
            }

            root.child[x ? 1 : 0].cnt += 1;

            root = root.child[x ? 1 : 0];
        }
    }

    static int cntSmaller(TrieNode root, int n, int k){
        int cntPairs = 0;

        for(int i=31;i>=0&&root!=null;i--){
            boolean x = (n & (1 << i)) != 0;
            boolean y = (k & (1 << i)) != 0;

            if (y){
                if(root.child[x ? 1 : 0] != null){
                    cntPairs += root.child[x ? 1 : 0].cnt;
                }

                root = root.child[x ? 0 : 1];
            }
            else{
                root = root.child[x ? 1 : 0];
            }
        }

        return cntPairs;
    }
    
    public int cntPairs(int[] arr, int k) {
        // code here
        TrieNode root = new TrieNode();
        int cntPairs = 0;
        int n = arr.length;

        for(int i=0;i<n;i++){
            cntPairs += cntSmaller(root, arr[i], k);
            insertTrie(root, arr[i]);
        }

        return cntPairs;
    }
}
