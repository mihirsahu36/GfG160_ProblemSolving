/*Prime List
You are given the head of a linked list. You have to replace all the values of the nodes with the nearest prime number.
If more than one prime number exists at an equal distance, choose the smallest one. Return the head of the modified linked list.

Examples :

Input: head = 2 → 6 → 10
Output: 2 → 5 → 11
Explanation: The nearest prime of 2 is 2 itself. The nearest primes of 6 are 5 and 7, since 5 is smaller so, 5 will be chosen. The nearest prime of 10 is 11.

Input: head = 1 → 15 → 20
Output: 2 → 13 → 19
Explanation: The nearest prime of 1 is 2. The nearest primes of 15 are 13 and 17, since 13 is smaller so, 13 will be chosen. The nearest prime of 20 is 19.

Constraints:

1 <= no. of Nodes <= 10^4
1 <= node.val <= 10^4*/

/*
class Node{
    Node next;
    int val;
    public Node(int data){
        val=data;
        next=null;
    }
}
*/

class Solution {
    Node primeList(Node head) {
        // code here
        Node temp = head;
        while(temp != null){
            temp.val = nearestPrime(temp.val);
            temp = temp.next;
        }
        return head;
    }
    
    int nearestPrime(int n){
        if(isPrime(n)){
            return n;
        }
        
        int prev = n - 1;
        int next = n + 1;
        
        while(true){
            if(prev >= 2 && isPrime(prev)){
                return prev;
            }
            if(isPrime(next)){
                return next;
            }
            prev--;
            next++;
        }
    }
    
    boolean isPrime(int n){
        if(n <= 1){
            return false;
        }
        for(int i=2;i*i<=n;i++){
            if(n % i == 0){
                return false;
            }
        }
        
        return true;
    }
}
