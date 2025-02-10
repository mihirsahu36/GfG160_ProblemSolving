/*K Sum Paths
Given a binary tree and an integer k, determine the number of downward-only paths where the sum of the node values in the path equals k.
A path can start and end at any node within the tree but must always move downward (from parent to child).

Examples:

Input: k = 7   
Output: 3
Explanation: The following paths sum to k 
 
Input: k = 3
Output: 2
Explanation:
Path 1 : 1 -> 2 (Sum = 3)
Path 2 : 3 (Sum = 3)

Constraints:

1 ≤ number of nodes ≤ 10^4
-100 ≤ node value ≤ 100
-10^9 ≤ k ≤ 10^9*/

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
    public int sumK(Node root, int k) {
        // code here
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return solve(root, map, 0, k);
    }
    
    private int solve(Node root, HashMap<Integer, Integer> map, int sum, int k){
        if(root == null){
            return 0;
        }
        
        sum += root.data;
        int res = 0;
        if(map.containsKey(sum - k)){
            res += map.get(sum - k);
        }
        
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        res += solve(root.left, map, sum, k);
        res += solve(root.right, map, sum, k);
        map.put(sum, map.get(sum) - 1);
        
        return res;
        
    }
}
