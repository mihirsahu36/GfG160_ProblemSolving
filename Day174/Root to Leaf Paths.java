/*Root to Leaf Paths
Given a Binary Tree, you need to find all the possible paths from the root node to all the leaf nodes of the binary tree.
Note: The paths should be returned such that paths from the left subtree of any node are listed first, followed by paths from the right subtree.

Examples:

Input: root[] = [1, 2, 3, 4, 5, N, N]
Output: [[1, 2, 4], [1, 2, 5], [1, 3]]
Explanation: All the possible paths from root node to leaf nodes are: 1 -> 2 -> 4, 1 -> 2 -> 5 and 1 -> 3

Input: root[] = [1, 2, 3]
Output: [[1, 2], [1, 3]] 
Explanation: All the possible paths from root node to leaf nodes are: 1 -> 2 and 1 -> 3

Input: root[] = [10, 20, 30, 40, 60, N, N]
Output: [[10, 20, 40], [10, 20, 60], [10, 30]]
Explanation: All the possible paths from root node to leaf nodes are: 10 -> 20 -> 40, 10 -> 20 -> 60 and 10 -> 30

Constraints:

1 <= number of nodes <= 10^4
1 <= node->data <= 10^4*/

/*

Definition for Binary Tree Node
class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    private static void solve(Node node, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> res){
        if(node == null){
            return;
        }
        
        path.add(node.data);
        
        if(node.left == null && node.right == null){
            res.add(new ArrayList<>(path));
        }else{
            solve(node.left, path, res);
            solve(node.right, path, res);
        }
        
        path.remove(path.size() - 1);
    }
    
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        // code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        solve(root, path, res);
        
        return res;
    }
}
