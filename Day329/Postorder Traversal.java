/* Postorder Traversal
Given the root of a Binary Tree, your task is to return its Postorder Traversal.
Note: A postorder traversal first visits the left child (including its entire subtree),
then visits the right child (including its entire subtree), and finally visits the node itself.

Examples:

Input: root = [19, 10, 8, 11, 13]
Output: [11, 13, 10, 8, 19]
Explanation: The postorder traversal of the given binary tree is [11, 13, 10, 8, 19].

Input: root = [11, 15, N, 7]
Output: [7, 15, 11]
Explanation: The postorder traversal of the given binary tree is [7, 15, 11].

Constraints:

1 ≤ number of nodes ≤ 3*10^4
0 ≤ node->data ≤ 10^5 */

/*
class Node {
    int data;
    Node left, right;
    Node(int val){
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    public ArrayList<Integer> postOrder(Node root) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        solve(root, res);
        return res;
    }
    
    private void solve(Node node, ArrayList<Integer> res){
        if(node == null){
            return;
        }
        
        solve(node.left, res);
        solve(node.right, res);
        res.add(node.data);
    }
}
