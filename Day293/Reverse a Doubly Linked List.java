/* Reverse a Doubly Linked List
You are given the head of a doubly linked list. You have to reverse the doubly linked list and return its head.

Examples:

Input: 3 <-> 4 <-> 5
Output: 5 <-> 4 <-> 3
Explanation: After reversing the given doubly linked list the new list will be 5 <-> 4 <-> 3.
   
Input: 75 <-> 122 <-> 59 <-> 196
Output: 196 <-> 59 <-> 122 <-> 75
Explanation: After reversing the given doubly linked list the new list will be 196 <-> 59 <-> 122 <-> 75.
   
Constraints:

1 ≤ number of nodes ≤ 10^6
0 ≤ node->data ≤ 10^4 */

/*
class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
*/
class Solution {
    public Node reverse(Node head) {
        // code here
        if(head == null || head.next == null){
            return head;
        }
        
        Node curr = head;
        Node prev = null;
        
        while(curr != null){
            prev = curr.prev;
            curr.prev = curr.next;
            curr.next = prev;
            
            curr = curr.prev;
        }
        
        if(prev != null){
            head = prev.prev;
        }
        
        return head;
    }
    
    private void printList(Node node){
        while(node != null){
            System.out.print(node.data);
            if(node.next != null){
                System.out.print(" <-> ");
            }
            node = node.next;
        }
        System.out.println();
    }
}
