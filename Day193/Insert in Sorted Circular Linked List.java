/*Insert in Sorted Circular Linked List
Given a sorted circular linked list, the task is to insert a new node in this circular linked list so that it remains a sorted circular linked list.

Examples:

Input: head = 1->2->4, data = 2
Output: 1->2->2->4
Explanation: We can add 2 after the second node.

Input: head = 1->4->7->9, data = 5
Output: 1->4->5->7->9
Explanation: We can add 5 after the second node.

Constraints:
2 <= number of nodes <= 10^6
0 <= node->data <= 10^6
0 <= data <= 10^6*/

/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
} */

class Solution {
    public Node sortedInsert(Node head, int data) {
        // code here
        Node newNode = new Node(data);
        
        if(head == null){
            newNode.next = newNode;
            return newNode;
        }
        
        Node curr = head;
        Node nextToCurr = head.next;
        
        while(true){
            if(curr.data <= data && data <= nextToCurr.data){
                break;
            }
            
            if(curr.data > nextToCurr.data){
                if(data >= curr.data || data <= nextToCurr.data){
                    break;
                }
            }
            
            curr = curr.next;
            nextToCurr = curr.next;
            
            if(curr == head){
                break;
            }
        }
        
        curr.next = newNode;
        newNode.next = nextToCurr;
        
        if(data < head.data){
            return newNode;
        }
        
        return head;
    }
}
