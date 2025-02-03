/*Height of Binary Tree
Given a binary tree, find its height.
The height of a tree is defined as the number of edges on the longest path from the root to a leaf node. A leaf node is a node that does not have any children.

Examples:

Input: root[] = [12, 8, 18, 5, 11]
Output: 2
Explanation: One of the longest path from the root (node 12) goes through node 8 to node 5, which has 2 edges.

Input: root[] = [1, 2, 3, 4, N, N, 5, N, N, 6, 7]  
Output: 3
Explanation: The longest path from the root (node 1) to a leaf node 6 with 3 edge.

Constraints:

1 <= number of nodes <= 10^5
0 <= node->data <= 10^5*/


/*
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
 */

class Solution {
    // Function to find the height of a binary tree.
    int height(Node node) {
        // code here
        if(node == null){
            return -1;
        }
        
        int l = height(node.left);
        int r = height(node.right);
        return Math.max(l, r) + 1;
    }
}
