/* Generate all binary strings
Given an integer n. You need to generate all the binary strings of n characters representing bits.
Note: Return the strings in  ascending order.

Examples:

Input: n = 2
Output: [00, 01, 10, 11]
Explanation: As each position can be either 0 or 1, the total possible combinations are 4.

Input: n = 3
Output: [000, 001, 010, 011, 100, 101, 110, 111]
Explanation: As each position can be either 0 or 1, the total possible combinations are 8.

Constraints:

1 ≤ n ≤ 20 */

class Solution {
    public ArrayList<String> binstr(int n) {
        // code here
        ArrayList<String> res = new ArrayList<>();
        generate(n, "", res);
        
        return res;
    }
    
    private void generate(int n, String curr, ArrayList<String> res){
        if(curr.length() == n){
            res.add(curr);
            return;
        }
        
        generate(n, curr + "0", res);
        generate(n, curr + "1", res);
    }
}
