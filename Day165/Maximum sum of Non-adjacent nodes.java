/*Maximum sum of Non-adjacent nodes
Given a binary tree with a value associated with each node.
Your task is to select a subset of nodes such that the sum of their values is maximized,
with the condition that no two selected nodes are directly connected that is,
if a node is included in the subset, neither its parent nor its children can be included.

Examples:

Input: root[] = [11, 1, 2]
Output: 11
Explanation: The maximum sum is obtained by selecting the node 11.

Input: root[] = [1, 2, 3, 4, N, 5, 6]
Output: 16
Explanation: The maximum sum is obtained by selecting the nodes 1, 4, 5, and 6, which are not directly connected to each other. Their total sum is 16.  

Constraints:
1 ≤ no. of nodes in the tree ≤ 10^4
1 ≤ Node.val ≤ 10^5*/

/*class Node
{
    int data;
    Node left, right;

    Node(int data)
    {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}*/

class Solution {
    // Function to return the maximum sum of non-adjacent nodes.
    public int getMaxSum(Node root) {
        // code here
        int []res = solve(root);
        
        return Math.max(res[0], res[1]);
    }
    
    private int[] solve(Node node){
        if(node == null){
            return new int[]{0, 0};
        }
        
        int []left = solve(node.left);
        int []right = solve(node.right);
        
        int include = node.data + left[0] + right[0];
        int exclude = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        
        return new int[]{exclude, include};
    }
}
