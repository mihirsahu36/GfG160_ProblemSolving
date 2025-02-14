/*Fixing Two nodes of a BST
Given the root of a Binary search tree(BST), where exactly two nodes were swapped by mistake.
Your task is to fix (or correct) the BST by swapping them back. Do not change the structure of the tree.
Note: It is guaranteed that the given input will form BST, except for 2 nodes that will be wrong.
All changes must be reflected in the original Binary search tree(BST).
 
Examples :

Input: root = [10, 5, 8, 2, 20]   
Output: 1
Explanation: The nodes 20 and 8 were swapped. 

Input: root = [5, 10, 20, 2, 8]  
Output: 1    
Explanation: The nodes 10 and 5 were swapped.

Constraints:

1 ≤ Number of nodes ≤ 10^3*/

/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    Node first, middle, last, prev;
    
    void correctBST(Node root) {
        // code here.
        first = middle = last = prev = null;
        inorder(root);
        
        if(first != null && last != null){
            int temp = first.data;
            first.data = last.data;
            last.data = temp;
        }else if(first != null && middle != null){
            int temp = first.data;
            first.data = middle.data;
            middle.data = temp;
        }
    }
    
    void inorder(Node root){
        if(root == null){
            return;
        }
        
        inorder(root.left);
        if(prev != null && root.data < prev.data){
            if(first == null){
                first = prev;
                middle = root;
            }else{
                last = root;
            }
        }
        prev = root;
        
        inorder(root.right);
    }
}
