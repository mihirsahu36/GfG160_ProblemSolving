/* Generate Binary Numbers
Given a number n. The task is to generate all binary numbers with decimal values from 1 to n.

Examples:

Input: n = 4
Output: ["1", "10", "11", "100"]
Explanation: Binary numbers from 1 to 4 are 1, 10, 11 and 100.

Input: n = 6
Output: ["1", "10", "11", "100", "101", "110"]
Explanation: Binary numbers from 1 to 6 are 1, 10, 11, 100, 101 and 110.

Constraints:

1 ≤ n ≤ 10^6 */

class Solution {
    public ArrayList<String> generateBinary(int n) {
        // code here
        ArrayList<String> res = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        
        queue.add("1");
        
        for(int i=1;i<=n;i++){
            String curr = queue.poll();
            res.add(curr);
            
            queue.add(curr + "0");
            queue.add(curr + "1");
        }
        
        return res;
    }
}
