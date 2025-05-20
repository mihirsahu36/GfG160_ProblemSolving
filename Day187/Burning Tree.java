/*Burning Tree
Given a binary tree and a target node, determine the minimum time required to burn the entire tree if the target node is set on fire.
In one second, the fire spreads from a node to its left child, right child, and parent.
Note: The tree contains unique values.

Examples : 

Input: root[] = [1, 2, 3, 4, 5, 6, 7], target = 2
Output: 3
Explanation: Initially 2 is set to fire at 0 sec 
At 1 sec: Nodes 4, 5, 1 catches fire.
At 2 sec: Node 3 catches fire.
At 3 sec: Nodes 6, 7 catches fire.
It takes 3s to burn the complete tree.

Input: root[] = [1, 2, 3, 4, 5, N, 7, 8, N, 10], target = 10
Output: 5
Explanation: Initially 10 is set to fire at 0 sec 
At 1 sec: Node 5 catches fire.
At 2 sec: Node 2 catches fire.
At 3 sec: Nodes 1 and 4 catches fire.
At 4 sec: Node 3 and 8 catches fire.
At 5 sec: Node 7 catches fire.
It takes 5s to burn the complete tree.

Constraints:

1 ≤ number of nodes ≤ 10^5
1 ≤ node->data ≤ 10^5*/

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
}  */
class Solution {
    public static int minTime(Node root, int target) {
        // code here
        Queue<Node> queue = new LinkedList<>();
        HashMap<Node, Node> parent = new HashMap<>();
        Node tar = null;
        queue.offer(root);
        parent.put(root, null);
        
        while(!queue.isEmpty()){
            Node curr = queue.poll();
            if(curr.data == target){
                tar = curr;
            }
            
            if(curr.left != null){
                queue.offer(curr.left);
                parent.put(curr.left, curr);
            }
            
            if(curr.right != null){
                queue.offer(curr.right);
                parent.put(curr.right, curr);
            }
        }
        
        HashMap<Node, Boolean> visited = new HashMap<>();
        int time = -1;
        queue.offer(tar);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            while(size-- > 0){
                Node curr = queue.poll();
                visited.put(curr, true);
                
                if(curr.left != null && !visited.containsKey(curr.left)){
                    queue.offer(curr.left);
                }
                
                if(curr.right != null && !visited.containsKey(curr.right)){
                    queue.offer(curr.right);
                }
                
                if(parent.get(curr) != null && !visited.containsKey(parent.get(curr))){
                    queue.offer(parent.get(curr));
                }
            }
            time++;
        }
        
        return time;
    }
}
