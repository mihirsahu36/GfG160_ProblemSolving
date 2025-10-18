/* Median of BST
You are given the root of a Binary Search Tree, find the median of it. 
Let the nodes of the BST, when written in ascending order (inorder traversal),
be represented as V1, V2, V3, …, Vn, where n is the total number of nodes in the BST.
If number of nodes are even: return V(n/2)
If number of nodes are odd: return V((n+1)/2)

Examples:

Input: root = [20, 8, 22, 4, 12, N, N, N, N, 10, 14]
Output: 12
Explanation: The inorder of given BST is 4, 8, 10, 12, 14, 20, 22. Here, n = 7, so, here median will be ((7+1)/2)th value, i.e., 4th value, i.e, 12.

Input: root = [5, 4, 8, 1]
Output: 4
Explanation: The inorder of given BST is 1, 4, 5, 8. Here, n = 4(even), so, here median will be (4/2)th value, i.e., 2nd value, i.e, 4.

Constraints:

1 ≤ number of nodes ≤ 10^5
1 ≤ node.data ≤  10^5 */

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
    private void solve(Node node, List<Integer> inorderList){
        if(node == null){
            return;
        }
        
        solve(node.left, inorderList);
        inorderList.add(node.data);
        solve(node.right, inorderList);
    }
    
    public int findMedian(Node root) {
        // Code here
        List<Integer> inorderList = new ArrayList<>();
        solve(root, inorderList);
        
        int n = inorderList.size();
        
        if(n % 2 == 0){
            return inorderList.get(n / 2 - 1);
        }else{
            return inorderList.get(n / 2);
        }
    }
}
