/* k-th Smallest in BST
Given the root of a BST and an integer k, the task is to find the kth smallest element in the BST.
If there is no kth smallest element present then return -1.

Examples:

Input: root = [20, 8, 22, 4, 12, N, N, N, N, 10, 14], k = 3    
Output: 10
Explanation: 10 is the 3rd smallest element in the BST.

Input: root = [2, 1, 3], k = 5
Output: -1
Explanation: There is no 5th smallest element in the BST as the size of BST is 3.

Constraints:

1 ≤ number of nodes, k ≤ 10^4
1 ≤ node->data ≤ 10^4 */

/*
class Node {
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    int count = 0, res = -1;
    
    public int kthSmallest(Node root, int k) {
        // code here
        solve(root, k);
        return res;
    }
    
    private void solve(Node root, int k){
        if(root == null || res != -1){
            return;
        }
        
        solve(root.left, k);
        count++;
        if(count == k){
            res = root.data;
            return;
        }
        solve(root.right, k);
    }
}
