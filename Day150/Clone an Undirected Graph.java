/*Clone an Undirected Graph
Given a connected undirected graph represented by adjacency list, adjList[][] with n nodes, having a distinct label from 0 to n-1, where each adj[i] represents the list of vertices connected to vertex i.
Create a clone of the graph, where each node in the graph contains an integer val and an array (neighbors) of nodes, containing nodes that are adjacent to the current node.
class Node {
    val: integer
    neighbors: List[Node]
}
Your task is to complete the function cloneGraph( ) which takes a starting node of the graph as input and returns the copy of the given node as a reference to the cloned graph.
Note: If you return a correct copy of the given graph, then the driver code will print true; and if an incorrect copy is generated or when you return the original node, the driver code will print false.

Examples :
Input: n = 4, adjList[][] = [[1, 2], [0, 2], [0, 1, 3], [2]]
Output: true
Explanation: 
As the cloned graph is identical to the original one the driver code will print true.

Input: n = 3, adjList[][] = [[1, 2], [0], [0]]
Output: true
Explanation: 
As the cloned graph is identical to the original one the driver code will print true.
Constraints:

1 ≤ n ≤ 10^4
0 ≤ no. of edges ≤ 10^5
0 ≤ adjList[i][j] < n*/

/*
    class Node{
        int val;
        ArrayList<Node> neighbors;
        public Node(){
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int val){
            this.val = val;
            neighbors = new ArrayList<>();
        }

        public Node(int val, ArrayList<Node> neighbors){
            this.val = val;
            this.neighbors = neighbors;
        }
    }
*/
class Solution {
    HashMap<Node, Node> visited = new HashMap<>();
    
    Node cloneGraph(Node node) {
        // code here
        if(node == null){
            return null;
        }
        
        if(visited.containsKey(node)){
            return visited.get(node);
        }
        
        Node cloneNode = new Node(node.val);
        visited.put(node, cloneNode);
        
        for(Node ngbr : node.neighbors){
            cloneNode.neighbors.add(cloneGraph(ngbr));
        }
        
        return cloneNode;
    }
}

