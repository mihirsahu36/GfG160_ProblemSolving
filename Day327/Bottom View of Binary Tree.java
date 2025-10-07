/* Bottom View of Binary Tree
You are given the root of a binary tree, and your task is to return its bottom view.
The bottom view of a binary tree is the set of nodes visible when the tree is viewed from the bottom.
Note: If there are multiple bottom-most nodes for a horizontal distance from the root, then the latter one in the level order traversal is considered.

Examples :

Input: root = [1, 2, 3, 4, 5, N, 6]   
Output: [4, 2, 5, 3, 6]
Explanation: The Green nodes represent the bottom view of below binary tree.
    
Input: root = [20, 8, 22, 5, 3, 4, 25, N, N, 10, 14, N, N, 28, N]    
Output: [5, 10, 4, 28, 25]
Explanation: The Green nodes represent the bottom view of below binary tree.
    
Constraints:

1 ≤ number of nodes ≤ 10^5
1 ≤ node->data ≤ 10^5 */

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
    public ArrayList<Integer> bottomView(Node root) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        
        if(root == null){
            return res;
        }
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        
        queue.add(new Pair(root, 0));
        
        while(!queue.isEmpty()){
            Pair current = queue.poll();
            Node currNode = current.node;
            int hd = current.hd;
            
            map.put(hd, currNode.data);
            
            if(currNode.left != null){
                queue.add(new Pair(currNode.left, hd - 1));
            }
            
            if(currNode.right != null){
                queue.add(new Pair(currNode.right, hd + 1));
            }
        }
        
        for(int val : map.values()){
            res.add(val);
        }
        
        return res;
    }
    
    class Pair {
        Node node;
        int hd;

        Pair(Node node, int hd){
            this.node = node;
            this.hd = hd;
        }
    }
}
