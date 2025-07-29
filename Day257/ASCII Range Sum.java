/* ASCII Range Sum
Given a string s consisting of lowercase English letters,
for every character whose first and last occurrences are at different positions,
calculate the sum of ASCII values of characters strictly between its first and last occurrence.
Return all such non-zero sums (order does not matter).

Examples:

Input: s = "abacab"
Output: [293, 294]
Explanation: characters 'a' and 'b' appear more than once:
'a' : between positions 1 and 5 → characters are b, a, c and ascii sum is 98 + 97 + 99 = 294.
'b' : between positions 2 and 6 → characters are a, c, a and ascii sum is 97 + 99 + 97 = 293.

Input: s = "acdac"
Output: [197, 199]
Explanation: characters 'a' and 'c' appear more than once:
'a' : between positions 1 and 4 → characters are c, d and ascii sum is 99 + 100 = 199.
'c' : between positions 2 and 5 → characters are d, a and ascii sum is 100 + 97 = 197.
Constraints:

1 ≤ s.size() ≤ 10^5 */


// Approach 1
class Solution {
    public ArrayList<Integer> asciirange(String s) {
        // code here
        int n = s.length();
        int []prefixSum = new int[n+1];
        ArrayList<Integer>[] charPos = new ArrayList[26];
        
        for(int i=0;i<26;i++){
            charPos[i] = new ArrayList<>();
        }
        
        for(int i=1;i<=n;i++){
            char currChar = s.charAt(i-1);
            int charIdx = currChar - 'a';
            
            if(charPos[charIdx].isEmpty()){
                charPos[charIdx].add(i);
                charPos[charIdx].add(i);
            }else{
                charPos[charIdx].set(1, i);
            }
            
            prefixSum[i] = prefixSum[i-1] + currChar;
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0;i<26;i++){
            if(!charPos[i].isEmpty()){
                int first = charPos[i].get(0);
                int last = charPos[i].get(1);
                
                if(first != last){
                    int sum = prefixSum[last-1] - prefixSum[first];
                    if(sum != 0){
                        res.add(sum);
                    }
                }
            }
        }
        
        return res;
    }
}

// Approach 2
class Solution {
    public ArrayList<Integer> asciirange(String s) {
        // code here
        int n = s.length();
        ArrayList<Integer> res = new ArrayList<>();
        int []first = new int[26];
        int []last = new int[26];
        
        for(int i=0;i<26;i++){
            first[i] = -1;
            last[i] = -1;
        }
        
        for(int i=0;i<n;i++){
            int charIdx = s.charAt(i) - 'a';
            if(first[charIdx] == -1){
                first[charIdx] = i;
            }else{
                last[charIdx] = i;
            }
        }
        
        for(int i=0;i<26;i++){
            if(first[i] != -1 && last[i] != -1){
                int sum = 0;
                for(int j=first[i]+1;j<last[i];j++){
                    sum += s.charAt(j);
                }
                if(sum != 0){
                    res.add(sum);
                }
            }
        }
        
        return res;
    }
}
