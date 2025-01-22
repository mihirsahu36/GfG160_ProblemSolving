/*Add Number Linked Lists
Given the head of two singly linked lists num1 and num2 representing two non-negative integers. The task is to return the head of the linked list representing the sum of these two numbers.
For example, num1 represented by the linked list : 1 -> 9 -> 0, similarly num2 represented by the linked list: 2 -> 5. Sum of these two numbers is represented by 2 -> 1 -> 5.
Note: There can be leading zeros in the input lists, but there should not be any leading zeros in the output list.

Examples:

Input: num1 = 4 - > 5, num2 = 3 -> 4 -> 5
Output:  3 -> 9 -> 0
Explanation: Given numbers are 45 and 345. There sum is 390.

Input: num1 = 0 -> 0 -> 6 -> 3, num2 = 0 -> 7 
Output: 7 -> 0 
Explanation: Given numbers are 63 and 7. There sum is 70.

Constraints:

1 <= size of both linked lists <= 10^6
0 <= elements of both linked lists <= 9*/

class Solution {
    static Node addTwoLists(Node num1, Node num2) {
        // code here
        Node list1 = reverseList(num1); // reverse the linkedlist
        Node list2 = reverseList(num2); // reverse the linkedlist
        Node curr = null;
        int carry = 0;
        while(list1 != null || list2 != null || carry > 0){  // traverse both lists and calculate sum 
            int val1 = (list1 != null) ? list1.data : 0;
            int val2 = (list2 != null) ? list2.data : 0;
            int sum = val1 + val2 + carry;
            carry = sum / 10;
            
            Node temp = new Node(sum % 10);
            temp.next = curr;
            curr = temp;
            
            if(list1 != null){
                list1 = list1.next;
            }
            if(list2 != null){
                list2 = list2.next;
            }
        }
        
        while(curr != null && curr.data == 0){ // remove leading zeroes
            curr = curr.next;
        }
        return curr;
    }
    
    static Node reverseList(Node head) {
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
