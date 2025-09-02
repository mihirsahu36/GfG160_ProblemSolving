/* Swap Kth nodes from ends
Given the head of a singly linked list and an integer k.
Swap the kth node (1-based index) from the beginning and the kth node from the end of the linked list.
Return the head of the final formed list and if it's not possible to swap the nodes return the original list.

Examples:

Input: k = 1,  
Output: 5 -> 2 -> 3 -> 4 -> 1
Explanation: Here k = 1, hence after swapping the 1st node from the beginning and end the new list will be 5 -> 2 -> 3 -> 4 -> 1.
  
Input: k = 2, 
Output: 5 -> 9 -> 8 -> 5 -> 10 -> 3
Explanation: Here k = 2, hence after swapping the 2nd node from the beginning and end the new list will be 5 -> 9 -> 8 -> 5 -> 10 -> 3.
  
Constraints:

1 ≤ list size ≤ 10^4
1 ≤ node->data ≤ 10^6
1 ≤ k ≤ 10^4 */

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
    public Node swapKth(Node head, int k) {
        // code here
        if(head == null){
            return null;
        }
        
        int n = 0;
        Node temp = head;
        while(temp != null){
            n++;
            temp = temp.next;
        }
        
        if(k > n){
            return head;
        }
        
        Node first = head;
        for(int i=1;i<k;i++){
            first = first.next;
        }
        
        Node second = head;
        for(int i=1;i<n-k+1;i++){
            second = second.next;
        }
        
        int tempVal = first.data;
        first.data = second.data;
        second.data = tempVal;
        
        return head;
    }
    
    private void printList(Node head){
        Node curr = head;
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
