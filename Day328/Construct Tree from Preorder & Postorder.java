/* Construct Tree from Preorder & Postorder
Given two arrays pre[] and post[] that represent the preorder and postorder traversals of a full binary tree.
Your task is to construct the binary tree and return its root.
Note:  Full Binary Tree is a binary tree where every node has either 0 or 2 children.
The preorder and postorder traversals contain unique values,
and every value present in the preorder traversal is also found in the postorder traversal.

Examples:

Input: pre[] = [1, 2, 4, 8, 9, 5, 3, 6, 7], post[] = [8, 9, 4, 5, 2, 6, 7, 3, 1]
Output: [1, 2, 3, 4, 5, 6, 7, 8, 9]
   
Input: pre[] = [1, 2, 4, 5, 3, 6, 7] , post[] = [4, 5, 2, 6, 7, 3, 1]
Output: [1, 2, 3, 4, 5, 6, 7]
   
Constraints:

1 ≤ number of nodes ≤ 10^3
1 ≤ pre[i], post[i] ≤ 10^4 */

/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    private Node solve(int prestart, int poststart, int preend, int[] pre, int[] post, Map<Integer, Integer> map){
        if(prestart > preend){
            return null;
        }
        
        Node root = new Node(pre[prestart]);
        
        if(prestart == preend){
            return root;
        }
        
        int nextNode = pre[prestart+1];
        int j = map.get(nextNode);
        int num = j - poststart + 1;
        
        root.left = solve(prestart + 1, poststart, prestart + num, pre, post, map);
        root.right = solve(prestart + num + 1, j + 1, preend, pre, post, map);
        
        return root;
    }
    
    public Node constructTree(int[] pre, int[] post) {
        // code here
        int n = pre.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(post[i], i);
        }
        
        return solve(0, 0, n - 1, pre, post, map);
    }
}
