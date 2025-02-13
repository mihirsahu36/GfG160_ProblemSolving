/*Pair Sum in BST
Given a Binary Search Tree(BST) and a target. Check whether there's a pair of Nodes in the BST with value summing up to the target. 

Examples:

Input: root = [7, 3, 8, 2, 4, N, 9], target = 12
Output: True
Explanation: In the binary tree above, there are two nodes (8 and 4) that add up to 12.

Input: root = [9, 5, 10, 2, 6, N, 12], target = 23
Output: False
Explanation: In the binary tree above, there are no such two nodes exists that add up to 23.

Constraints:

1 ≤ Number of Nodes ≤ 10^5
1 ≤ target ≤ 10^6*/

/*
class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}
*/
class Solution {
    boolean findTarget(Node root, int target) {
        // Write your code here
        HashSet<Integer> set = new HashSet<>();
        return findPair(root, target, set);
    }
    
    boolean findPair(Node root, int target, HashSet<Integer> set){
        if(root == null){
            return false;
        }
        if(set.contains(target - root.data)){
            return true;
        }
        set.add(root.data);
        
        return findPair(root.left, target, set) || findPair(root.right, target, set);
    }
}
