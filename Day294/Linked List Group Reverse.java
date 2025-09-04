/* Linked List Group Reverse
You are given the head of a Singly linked list. You have to reverse every k node in the linked list and return the head of the modified list.
Note: If the number of nodes is not a multiple of k then the left-out nodes at the end, should be considered as a group and must be reversed.

Examples:

Input: k = 2,
Output: 2 -> 1 -> 4 -> 3 -> 6 -> 5
Explanation: Linked List is reversed in a group of size k = 2.
   
Input: k = 4,
Output: 4 -> 3 -> 2 -> 1 -> 6 -> 5
Explanation: Linked List is reversed in a group of size k = 4.
   
Constraints:

1 ≤ size of linked list ≤ 10^5
0 ≤ node->data ≤ 10^6
1 ≤ k ≤ size of linked list */


// Approach 1
/*
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}
*/

class Solution {
    public Node reverseKGroup(Node head, int k) {
        // code here
        if(head == null || k == 1){
            return head;
        }
        
        Stack<Node> stack = new Stack<>();
        Node curr = head;
        Node prev = null;
        
        while(curr != null){
            int count = 0;
            while(curr != null && count < k){
                stack.push(curr);
                curr = curr.next;
                count++;
            }
            
            while(!stack.isEmpty()){
                if(prev == null){
                    prev = stack.pop();
                    head = prev;
                }else{
                    prev.next = stack.pop();
                    prev = prev.next;
                }
            }
        }
        
        prev.next = null;
        
        return head;
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

// Approach 2
/*
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}
*/

class Solution {
    public Node reverseKGroup(Node head, int k) {
        // code here
        if(head == null || k == 1){
            return head;
        }
        
        Node dummyNode = new Node(0);
        dummyNode.next = head;
        Node curr = head;
        Node prev = dummyNode;
        
        while(curr != null){
            Node groupStart = curr;
            Node temp = curr;
            int count = 0;
            while(temp != null && count < k){
                temp = temp.next;
                count++;
            }
            
            Node newHead = reverse(groupStart, k);
            prev.next = newHead;
            groupStart.next = temp;
            
            prev = groupStart;
            curr = temp;
        }
        
        return dummyNode.next;
    }
    
    private Node reverse(Node node, int k){
        Node prev = null;
        Node curr = node;
        while(curr != null && k > 0){
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            k--;
        }
        
        return prev;
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
