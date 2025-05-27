/*Print leaf nodes from preorder traversal of BST
Given a preorder traversal of a BST, find the leaf nodes of the tree without building the tree.

Examples:

Input: preorder[] = [5, 2, 10]
Output: [2, 10]
Explaination: 
2 and 10 are the leaf nodes as shown in the figure.

Input: preorder[] = [4, 2, 1, 3, 6, 5]
Output: [1, 3, 5]
Explaination: 
1, 3 and 5 are the leaf nodes as shown in the figure.

Input: preorder[] = [8, 2, 5, 10, 12]
Output: [5, 12]
Explaination: 
5 and 12 are the leaf nodes as shown in the figure.

Constraints:

1 ≤ preorder.size() ≤ 10^3
1 ≤ preorder[i] ≤ 10^3*/

// Approach 1
class Solution {
    public ArrayList<Integer> leafNodes(int[] preorder) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int n = preorder.length;
        
        for(int i=0;i<n-1;i++){
            boolean isLeaf = false;
            
            if(preorder[i+1] < preorder[i]){
                stack.push(preorder[i]);
            }else{
                while(!stack.isEmpty()){
                    if(preorder[i+1] > stack.peek()){
                        stack.pop();
                        isLeaf = true;
                    }else{
                        break;
                    }
                }
            }
            
            if(isLeaf){
                res.add(preorder[i]);
            }
        }
        
        res.add(preorder[n-1]);
        return res;
    }
}

// Approach 2
class Solution {
    public ArrayList<Integer> leafNodes(int[] preorder) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int n = preorder.length;
        
        for(int i=0;i<n;i++){
            int count = 0;
            int curr = preorder[i];
            
            while(!stack.isEmpty() && curr > stack.peek()){
                stack.pop();
                count++;
            }
            
            if(count >= 2){
                res.add(preorder[i-1]);
            }
            
            stack.push(curr);
        }
        
        res.add(preorder[n-1]);
        return res;
    }
}
