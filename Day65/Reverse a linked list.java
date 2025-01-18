/*Reverse a linked list
Given the head of a linked list, the task is to reverse this list and return the reversed head.

Examples:

Input: head: 1 -> 2 -> 3 -> 4 -> NULL
Output: head: 4 -> 3 -> 2 -> 1 -> NULL

Input: head: 2 -> 7 -> 10 -> 9 -> 8 -> NULL
Output: head: 8 -> 9 -> 10 -> 7 -> 2 -> NULL

Input: head: 2 -> NULL
Output: 2 -> NULL

Constraints:

1 <= number of nodes, data of nodes <= 10^5*/

/* linked list node class:

class Node {
    int data;
    Node next;
    Node(int value) {
        this.value = value;
    }
}

*/

class Solution {
    Node reverseList(Node head) {
        // code here
        Node prev = null;  
        Node curr = head;
        Node next = null;
        
        while(curr != null) { 
            next = curr.next; 
            curr.next = prev;
            prev = curr;
            curr = next;
        }
       return prev;
    }
}
