/*Maximum XOR of two numbers in an array
Given an array arr[] of non-negative integers of size n. Find the maximum possible XOR between two numbers present in the array.

Examples:

Input: arr[] = [25, 10, 2, 8, 5, 3]
Output: 28
Explanation: The maximum possible XOR is 5 ^ 25 = 28.

Input: arr[] = [1, 2, 3, 4, 5, 6, 7]
Output: 7
Explanation : The maximum possible XOR is 1 ^ 6 = 7.

Constraints:

2 ≤ arr.size() ≤ 5*10^4
1 ≤ arr[i] ≤ 10^6*/

class Solution {
    public class TrieNode{
        TrieNode left;
        TrieNode right;
    }
    
    public void insert(TrieNode head, int num){
        TrieNode curr = head;
        for(int i=31;i>=0;i--){
            int ithBit = (num >> i) & 1;
            if(ithBit == 0){
                if(curr.left == null){
                    curr.left = new TrieNode();
                }
                curr = curr.left;
            }else{
                if(curr.right == null){
                    curr.right = new TrieNode();
                }
                curr = curr.right;
            }
        }
    }
    
    public int findMaxXor(TrieNode head, int num){
        int xor = 0;
        TrieNode curr = head;
        for(int i=31;i>=0;i--){
            int ithBit = (num >> i) & 1;
            if(ithBit == 1){
                if(curr.left != null){
                    xor |= (1 << i);
                    curr = curr.left;
                }else{
                    curr = curr.right;
                }
            }else{
                if(curr.right != null){
                    xor |= (1 << i);
                    curr = curr.right;
                }else{
                    curr = curr.left;
                }
            }
        }
        
        return xor;
    }
    
    public int maxXor(int[] arr) {
        // code here
        TrieNode root = new TrieNode();
        for(int x : arr){
            insert(root, x);
        }
        
        int res = 0;
        for(int x : arr){
            res = Math.max(res, findMaxXor(root, x));
        }
        
        return res;
    }
}
