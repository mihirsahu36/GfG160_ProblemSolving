/*Is Binary Tree Heap
You are given a binary tree, and the task is to determine whether it satisfies the properties of a max-heap.
A binary tree is considered a max-heap if it satisfies the following conditions:
Completeness: Every level of the tree, except possibly the last, is completely filled, and all nodes are as far left as possible.
Max-Heap Property: The value of each node is greater than or equal to the values of its children.

Examples:

Input: root[] = [97, 46, 37, 12, 3, 7, 31, 6, 9]
Output: true
Explanation: The tree is complete and satisfies the max-heap property.

Input: root[] = [97, 46, 37, 12, 3, 7, 31, N, 2, 4] 
Output: false
Explanation: The tree is not complete and does not follow the Max-Heap Property, hence it is not a max-heap.

Constraints:

1 ≤ number of nodes ≤ 10^3
1 ≤ node->data ≤ 10^3*/

/*
Node defined as
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/

class Solution {
    boolean isHeap(Node tree) {
        // code here
        int totalNodes = countNodes(tree);
        return isCompleteAndHeap(tree, 1, totalNodes);
    }
    
    int countNodes(Node root){
        if(root == null){
            return 0;
        }
        
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    
    boolean isCompleteAndHeap(Node root, int index, int totalNodes){
        if(root == null){
            return true;
        }
        
        if(index > totalNodes){
            return false;
        }
        
        if(root.left != null && root.left.data > root.data){
            return false;
        }
        if(root.right != null && root.right.data > root.data){
            return false;
        }
        
        return isCompleteAndHeap(root.left, index * 2, totalNodes) && 
        isCompleteAndHeap(root.right, index * 2 + 1, totalNodes);
    }
}
