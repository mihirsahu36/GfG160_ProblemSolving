/* ZigZag Tree Traversal
Given the root of a binary tree. You have to find the zig-zag level order traversal of the binary tree.
Note: In zig zag traversal we traverse the nodes from left to right for odd-numbered levels, and from right to left for even-numbered levels.

Examples:

Input: root = [1, 2, 3, 4, 5, 6, 7]      
Output: [1, 3, 2, 4, 5, 6, 7]
Explanation:
Level 1 (left to right): [1]
Level 2 (right to left): [3, 2]
Level 3 (left to right): [4, 5, 6, 7]
Final result: [1, 3, 2, 4, 5, 6, 7]

Input: root = [7, 9, 7, 8, 8, 6, N, 10, 9]
Output: [7, 7, 9, 8, 8, 6, 9, 10] 
Explanation:
Level 1 (left to right): [7]
Level 2 (right to left): [7, 9]
Level 3 (left to right): [8, 8, 6]
Level 4 (right to left): [9, 10]
Final result: [7, 7, 9, 8, 8, 6, 9, 10]

Constraints:

1 ≤ number of nodes ≤ 10^5
1 ≤ node->data ≤ 10^5 */

 /*
class Node {
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}
*/

class Solution {
    ArrayList<Integer> zigZagTraversal(Node root) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        
        if(root == null){
            return res;
        }
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        boolean leftToRight = true;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> level = new ArrayList<>(size);
            
            for(int i=0;i<size;i++){
                Node curr = queue.poll();
                level.add(curr.data);
                
                if(curr.left != null){
                    queue.add(curr.left);
                }
                
                if(curr.right != null){
                    queue.add(curr.right);
                }
            }
            
            if(!leftToRight){
                Collections.reverse(level);
            }
            
            res.addAll(level);
            leftToRight = !leftToRight;
        }
        
        return res;
    }
}
