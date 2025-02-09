/*Maximum path sum from any node
Given a binary tree, the task is to find the maximum path sum. The path may start and end at any node in the tree.

Examples:

Input: root[] = [10, 2, 10, 20, 1, N, -25, N, N, N, N, 3, 4]
Output: 42
Explanation: 
Max path sum is represented using green colour nodes in the above binary tree.

Input: root[] = [-17, 11, 4, 20, -2, 10]
Output: 31
Explanation: 
Max path sum is represented using green colour nodes in the above binary tree.

Constraints:

1 ≤ number of nodes ≤ 10^3
-10^4 ≤ node->data ≤ 10^4*/

/*
Node defined as
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/

class Solution {
    // Function to return maximum path sum from any node in a tree.
    int maxSum;
    
    int solve(Node root) {
        // your code goes here
        if(root == null){
            return 0;
        }
        
        int leftSum = solve(root.left);
        int rightSum = solve(root.right);
        
        int sumThroughRoot = leftSum + rightSum + root.data;
        int childPath = Math.max(leftSum, rightSum) + root.data;
        int singleNode = root.data;
        
        maxSum = Math.max(maxSum, Math.max(sumThroughRoot, Math.max(childPath, singleNode)));
        
        return Math.max(childPath, singleNode);
    }
    
    int findMaxSum(Node root){
        maxSum = Integer.MIN_VALUE;
        solve(root);
        return maxSum;
    }
}
