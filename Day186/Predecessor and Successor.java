/*Predecessor and Successor
You are given root node of the BST and an integer key.
You need to find the in-order successor and predecessor of the given key. If either predecessor or successor is not found, then set it to NULL.
Note:- In an inorder traversal the number just smaller than the target is the predecessor and the number just greater than the target is the successor. 

Examples :

Input: root[] = [8, 1, 9, N, 4, N, 10, 3, N, N, N], key = 8
Output: 4 9
Explanation: In the given BST the inorder predecessor of 8 is 4 and inorder successor of 8 is 9.

Input: root[] = [10, 2, 11, 1, 5, N, N, N, N, 3, 6, N, 4, N, N], key = 11
Output: 10 -1
Explanation: In given BST, the inorder predecessor of 11 is 10 whereas it does not have any inorder successor.

Input: root[] = [2, 1, 3], key = 3
Output: 2 -1
Explanation: In given BST, the inorder predecessor of 3 is 2 whereas it does not have any inorder successor.

Constraints: 

1 <= no. of nodes <= 10^5
1 <= node->data <= 10^6
1 <= key <= 10^6*/

/* BST Node
class Node {
    int data;
    Node left, right;
    Node(int x) {
        data = x;
        left = right = null;
    }
} */

class Solution {
    private Node leftMost(Node node){
        while(node.left != null){
            node = node.left;
        }
        return node;
    }
    
    private Node rightMost(Node node){
        while(node.right != null){
            node = node.right;
        }
        return node;
    }
    
    public ArrayList<Node> findPreSuc(Node root, int key) {
        // code here
        Node pred = null;
        Node succ = null;
        Node curr = root;
        
        while(curr != null){
            if(curr.data > key){
                succ = curr;
                curr = curr.left;
            }else if(curr.data < key){
                pred = curr;
                curr = curr.right;
            }else{
                if(curr.left != null){
                    pred = rightMost(curr.left);
                }
                if(curr.right != null){
                    succ = leftMost(curr.right);
                }
                break;
            }
        }
        
        ArrayList<Node> res = new ArrayList<>();
        res.add(pred);
        res.add(succ);
        
        return res;
    }
}
