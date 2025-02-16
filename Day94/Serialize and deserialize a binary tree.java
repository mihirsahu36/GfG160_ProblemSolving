/*Serialize and deserialize a binary tree
Serialization is to store a tree in an array so that it can be later restored and deserialization is reading tree back from the array. Complete the functions

serialize() : stores the tree into an array a and returns the array.
deSerialize() : deserializes the array to the tree and returns the root of the tree.
Note: Multiple nodes can have the same data and the node values are always positive integers.
Your code will be correct if the tree returned by deSerialize(serialize(input_tree)) is same as the input tree.
Driver code will print the in-order traversal of the tree returned by deSerialize(serialize(input_tree)).

Examples :

Input: root = [1, 2, 3]   
Output: [2, 1, 3]

Input: root = [10, 20, 30, 40, 60, N, N]     
Output: [40, 20, 60, 10, 30]

Constraints:

1 <= Number of nodes <= 10^4
1 <= Data of a node <= 10^9*/

/*Complete the given function
Node is as follows:
class Tree{
    int data;
    Tree left,right;
    Tree(int d){
        data=d;
        left=right=null;
    }
}*/

class Tree {
    private int index = 0;
    
    public ArrayList<Integer> serialize(Node root) {
        // code here
        ArrayList<Integer> arr = new ArrayList<>();
        preorder(root, arr);
        return arr;
    }
    
    private void preorder(Node root, ArrayList<Integer> arr){
        if(root == null){
            arr.add(-1);
            return;
        }
        
        arr.add(root.data);
        preorder(root.left, arr);
        preorder(root.right, arr);
    }

    public Node deSerialize(ArrayList<Integer> arr) {
        // code here
        if(index >= arr.size() || arr.get(index) == -1){
            index++;
            return null;
        }
        
        Node root = new Node(arr.get(index++));
        root.left = deSerialize(arr);
        root.right = deSerialize(arr);
        return root;
    }
};
