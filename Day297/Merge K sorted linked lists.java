/* Merge K sorted linked lists
Given an array arr[] of n sorted linked lists of different sizes.
Your task is to merge all these lists into a single sorted linked list and return the head of the merged list.

Examples:

Input: 1 -> 3 -> 7 -> null
       2 -> 4 -> 8 -> null
       9 -> null
Output: 1 -> 2 -> 3 -> 4 -> 7 -> 8 -> 9
Explanation: The arr[] has 3 sorted linked list of size 3, 3, 1.
1st list: 1 -> 3 -> 7
2nd list: 2 -> 4 -> 8
3rd list: 9
The merged list will be: 1 -> 2 -> 3 -> 4 -> 7 -> 8 -> 9 -> null
    
Input: 1 -> 3 -> null
       8 -> null
       4 -> 5 -> 6 -> null
Output: 1 -> 3 -> 4 -> 5 -> 6 -> 8
Explanation: The arr[] has 3 sorted linked list of size 2, 1, 3.
1st list: 1 -> 3
2nd list: 8
3rd list: 4 -> 5 -> 6
The merged list will be: 1 -> 3 -> 4 -> 5 -> 6 -> 8 -> null
    
Constraints

1 ≤ total no. of nodes ≤ 10^5
1 ≤ node->data ≤ 10^3 */

/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
*/

class Solution {
    Node mergeKLists(Node[] arr) {
        // code here
        if(arr == null || arr.length == 0){
            return null;
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.data - b.data);
        
        for(int i=0;i<arr.length;i++){
            if(arr[i] != null){
                pq.add(arr[i]);
            }
        }
        
        Node dummyNode = new Node(0);
        Node tail = dummyNode;
        
        while(!pq.isEmpty()){
            Node curr = pq.poll();
            tail.next = curr;
            tail = tail.next;
            
            if(curr.next != null){
                pq.add(curr.next);
            }
        }
        
        return dummyNode.next;
    }
    
    private void printList(Node node){
        Node curr = node;
        while(curr != null){
            System.out.print(curr.data);
            if(curr.next != null){
                System.out.print(" ->");
                curr = curr.next;
            }
        System.out.println();
        }
    }
}
