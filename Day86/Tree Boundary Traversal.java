/*Tree Boundary Traversal
Given a Binary Tree, find its Boundary Traversal. The traversal should be in the following order: 
Left Boundary: This includes all the nodes on the path from the root to the leftmost leaf node. 
You must prefer the left child over the right child when traversing. Do not include leaf nodes in this section.
Leaf Nodes: All leaf nodes, in left-to-right order, that are not part of the left or right boundary.
Reverse Right Boundary: This includes all the nodes on the path from the rightmost leaf node to the root, traversed in reverse order.
You must prefer the right child over the left child when traversing.
Do not include the root in this section if it was already included in the left boundary.
Note: If the root doesn't have a left subtree or right subtree, then the root itself is the left or right boundary. 

Examples:

Input: root[] = [1, 2, 3, 4, 5, 6, 7, N, N, 8, 9, N, N, N, N]
Output: [1, 2, 4, 8, 9, 6, 7, 3]

Input: root[] = [1, 2, N, 4, 9, 6, 5, N, 3, N, N, N, N 7, 8]
Output: [1, 2, 4, 6, 5, 7, 8]
Explanation:
As the root doesn't have a right subtree, the right boundary is not included in the traversal.

Input: root[] = [1, N, 2, N, 3, N, 4, N, N] 
    1
     \
      2
       \
        3
         \
          4

Output: [1, 4, 3, 2]
Explanation:
Left boundary: [1] (as there is no left subtree)
Leaf nodes: [4]
Right boundary: [3, 2] (in reverse order)
Final traversal: [1, 4, 3, 2]

Constraints:

1 ≤ number of nodes ≤ 10^5
1 ≤ node->data ≤ 10^5*/

/*
class Node
{
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    ArrayList<Integer> boundaryTraversal(Node node) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        
        if(node.left != null || node.right != null){
            res.add(node.data);
        }
        
        leftNodes(node.left, res);
        leafNodes(node, res);
        rightRevNodes(node.right, res);
        
        return res;
    }
    
    void leftNodes(Node node, ArrayList<Integer> res){
        if(node == null){
            return;
        }
        
        if(node.left != null){
            res.add(node.data);
            leftNodes(node.left, res);
        }else if(node.right != null){
            res.add(node.data);
            leftNodes(node.right, res);
        }
    }
    
    void leafNodes(Node node, ArrayList<Integer> res){
        if(node == null){
            return;
        }
        
        leafNodes(node.left, res);
        if(node.left == null && node.right == null){
            res.add(node.data);
        }
        leafNodes(node.right, res);
    }
    
    void rightRevNodes(Node node, ArrayList<Integer> res){
        if(node == null){
            return;
        }
        
        if(node.right != null){
            rightRevNodes(node.right, res);
            res.add(node.data);
        }else if(node.left != null){
            rightRevNodes(node.left, res);
            res.add(node.data);
        }
    }
}
