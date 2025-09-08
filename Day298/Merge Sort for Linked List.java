/* Merge Sort for Linked List
You are given the head of a linked list. You have to sort the given linked list using Merge Sort.

Examples:

Input: 40 -> 20 -> 60 -> 10 -> 50 -> 30
Output: 10 -> 20 -> 30 -> 40 -> 50 -> 60
Explanation: After sorting the given linked list, the resultant list will be:
    
Input: 9 -> 5 -> 2 -> 8
Output: 2 -> 5 -> 8 -> 9
Explanation: After sorting the given linked list, the resultant list will be:
    
Constraints:

1 ≤ number of nodes ≤ 10^5
0 ≤ node->data ≤ 10^6 */

/*
class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}
*/

class Solution {
    public Node mergeSort(Node head) {
        // code here
        if(head == null || head.next == null){
            return head;
        }
        
        Node middle = getMiddle(head);
        Node rightHalf = middle.next;
        middle.next = null;
        Node leftHalf = head;
        
        leftHalf = mergeSort(leftHalf);
        rightHalf = mergeSort(rightHalf);
        
        return sortedMerge(leftHalf, rightHalf);
    }
    
    private Node sortedMerge(Node left, Node right){
        if(left == null){
            return right;
        }
        
        if(right == null){
            return left;
        }
        
        Node res;
        if(left.data <= right.data){
            res = left;
            res.next = sortedMerge(left.next, right);
        }else{
            res = right;
            res.next = sortedMerge(left, right.next);
        }
        
        return res;
    }
    
    private Node getMiddle(Node head){
        if(head == null){
            return head;
        }
    
        Node slow = head;
        Node fast = head;
        
        while(fast .next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    private void printList(Node node){
        Node curr = node;
        while(curr != null){
            System.out.print(curr.data);
            if(curr.next != null){
                System.out.print(" ->");
            }
            curr = curr.next;
        }
        
        System.out.println();
    }
}
