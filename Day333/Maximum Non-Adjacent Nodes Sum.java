/* Maximum Non-Adjacent Nodes Sum
Given the root of a binary tree with integer values.
Your task is to select a subset of nodes such that the sum of their values is maximized,
with the condition that no two selected nodes are directly connected that is,
if a node is included in the subset, neither its parent nor its children can be included.

Examples:

Input: root = [11, 1, 2]
Output: 11
Explanation: The maximum sum is obtained by selecting the node 11.

Input: root = [1, 2, 3, 4, N, 5, 6]
Output: 16
Explanation: The maximum sum is obtained by selecting the nodes 1, 4, 5 and 6, which are not directly connected to each other. Their total sum is 16.  

Constraints:

1 ≤ number of nodes ≤ 10^4
1 ≤ node.data ≤ 10^5 */

/*
class Node {
    int data;
    Node left, right;

    Node(int data)
    {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
*/

class Solution {
    private Map<Node, Integer> includeMap = new HashMap<>();
    private Map<Node, Integer> excludeMap = new HashMap<>();
    
    public int getMaxSum(Node root) {
        // code here
        if(root == null){
            return 0;
        }
        
        solve(root);
        
        return Math.max(includeMap.get(root), excludeMap.get(root));
    }
    
    private void solve(Node node){
        if(node == null){
            return;
        }
        
        solve(node.left);
        solve(node.right);
        
        int include = node.data;
        
        if(node.left != null){
            include += excludeMap.get(node.left);
        }
        
        if(node.right != null){
            include += excludeMap.get(node.right);
        }
        
        int exclude = 0;
        
        if(node.left != null){
            exclude += Math.max(includeMap.get(node.left), excludeMap.get(node.left));
        }
        
        if(node.right != null){
            exclude += Math.max(includeMap.get(node.right), excludeMap.get(node.right));
        }
        
        includeMap.put(node, include);
        excludeMap.put(node, exclude);
    }
}
