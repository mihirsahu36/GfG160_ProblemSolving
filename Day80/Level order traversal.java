/*Level order traversal
Given a root of a binary tree with n nodes, the task is to find its level order traversal. Level order traversal of a tree is breadth-first traversal for the tree.

Examples:

Input: root[] = [1, 2, 3]
Output: [[1], [2, 3]]

Input: root[] = [10, 20, 30, 40, 50]
Output: [[10], [20, 30], [40, 50]]

Input: root[] = [1, 3, 2, N, N, N, 4, 6, 5]
Output: [[1], [3, 2], [4], [6, 5]]

Constraints:

1 ≤ number of nodes ≤ 10^5
0 ≤ node->data ≤ 10^9*/

/*
class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}
*/
class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder(Node root) {
        // Your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> level = new ArrayList<>();
            while(size-- > 0){
                Node temp = queue.poll();
                level.add(temp.data);
                if(temp.left != null){
                    queue.add(temp.left);
                }
                if(temp.right != null){
                    queue.add(temp.right);
                }
            }
            res.add(level);
        }
        return res;
    }
}
