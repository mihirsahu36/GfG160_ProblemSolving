/*BST with Dead End
You are given a Binary Search Tree (BST) containing unique positive integers greater than 0.
Your task is to determine whether the BST contains a dead end.
Note: A dead end is a leaf node in the BST such that no new node can be inserted in the BST at or
below this node while maintaining the BST property and the constraint that all node values must be > 0.

Examples:

Input: root[] = [8, 5, 9, 2, 7, N, N, 1]
Output: true
Explanation: Node 1 is a Dead End in the given BST.

Input: root[] = [8, 7, 10, 2, N, 9, 13]
Output: true
Explanation: Node 9 is a Dead End in the given BST.

Constraints:

1 <= number of nodes <= 3000
1 <= node->data <= 10^5 */

/*
class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
}*/

class Solution {
    public boolean isDeadEnd(Node root) {
        // Code here.
        return solve(root, 1, Integer.MAX_VALUE);
    }
    
    private boolean solve(Node node, int min, int max){
        if(node == null){
            return false;
        }
        
        if(min == max){
            return true;
        }
        
        boolean leftEnd = solve(node.left, min, node.data - 1);
        boolean rightEnd = solve(node.right, node.data + 1, max);
        
        return leftEnd || rightEnd;
    }
}
