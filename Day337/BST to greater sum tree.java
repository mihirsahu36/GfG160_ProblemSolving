/* BST to greater sum tree
Given the root of a  BST with unique node values, transform it into greater sum tree where each node contains sum of all nodes greater than that node.

Examples:

Input: root = [11, 2, 29, 1, 7, 15, 40, N, N, N, N, N, N, 35, N]     
Output: [119, 137, 75, 139, 130, 104, 0, N, N, N, N, N, N, 40, N]
Explanation: Every node is replaced with the sum of nodes greater than itself. 
      
Input: root = [2, 1, 6, N, N, 3, 7]   
Output: [16, 18, 7, N, N, 13, 0]
Explanation: Every node is replaced with the sum of nodes greater than itself. 
     
Constraints :

1 ≤ node->data ≤ 3*10^4
1 ≤ number of nodes ≤ 3*10^4 */

/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
} */

class Solution {
    private static void updateTree(Node root, int []sum){
        if(root == null){
            return;
        }
        
        updateTree(root.right, sum);
        
        sum[0] += root.data;
        root.data = sum[0] - root.data;
        
        updateTree(root.left, sum);
    }
    
    public static void transformTree(Node root) {
        // code here
        int []sum = {0};
        updateTree(root, sum);
    }
}
