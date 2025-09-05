/* Sort a linked list of 0s, 1s and 2s
Given the head of a linked list where nodes can contain values 0s, 1s, and 2s only.
Your task is to rearrange the list so that all 0s appear at the beginning, followed by all 1s, and all 2s are placed at the end.

Examples:

Input: head = 1 → 2 → 2 → 1 → 2 → 0 → 2 → 2
Output: 0 → 1 → 1 → 2 → 2 → 2 → 2 → 2
Explanation: All the 0s are segregated to the left end of the linked list, 2s to the right end of the list, and 1s in between. The final list will be:
   
Input: head = 2 → 2 → 0 → 1
Output: 0 → 1 → 2 → 2
Explanation: After arranging all the 0s, 1s and 2s in the given format, the output will be:
   
Constraints:

1 ≤ no. of nodes ≤ 10^6
0 ≤ node->data ≤ 2 */

/*
class Node {
    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}*/

class Solution {
    public Node segregate(Node head) {
        // code here
        if(head == null || head.next == null){
            return head;
        }
        
        Node zeroDummy = new Node(0);
        Node oneDummy = new Node(0);
        Node twoDummy = new Node(0);
        
        Node zero = zeroDummy, one = oneDummy, two = twoDummy;
        
        Node curr = head;
        while(curr != null){
            if(curr.data == 0){
                zero.next = curr;
                zero = zero.next;
            }else if(curr.data == 1){
                one.next = curr;
                one = one.next;
            }else{
                two.next = curr;
                two = two.next;
            }
            curr = curr.next;
        }
        
        zero.next = (oneDummy.next != null) ? oneDummy.next : twoDummy.next;
        one.next = twoDummy.next;
        two.next = null;
        
        return zeroDummy.next;
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
