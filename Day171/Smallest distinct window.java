/*Smallest distinct window
Given a string str, your task is to find the length of the smallest window that contains all the characters of the given string at least once.

Example:

Input: str = "aabcbcdbca"
Output: 4
Explanation: Sub-String "dbca" has the smallest length that contains all the characters of str.

Input: str = "aaab"
Output: 2
Explanation: Sub-String "ab" has the smallest length that contains all the characters of str.

Input: str = "geeksforgeeks"
Output: 8
Explanation: There are multiple substring with smallest length that contains all characters of str, "geeksfor" and "forgeeks". 

Constraints:
1 ≤ str.size() ≤ 105
str contains only lower-case english alphabets.*/

class Solution {
    public int findSubString(String str) {
        // code here
        int n = str.length();
        boolean []visited = new boolean[26];
        int distinct = 0;
        
        for(int i=0;i<n;i++){
            if(visited[str.charAt(i) - 'a'] == false){
                visited[str.charAt(i) - 'a'] = true;
                distinct++;
            }
        }
        
        int []curr = new int[26];
        int count = 0;
        int res = n;
        int start = 0;
        
        for(int i=0;i<n;i++){
            curr[str.charAt(i) - 'a']++;
            
            if(curr[str.charAt(i) - 'a'] == 1){
                count++;
            }
            while(count == distinct){
                res = Math.min(res, i - start + 1);
                curr[str.charAt(start) - 'a']--;
                if(curr[str.charAt(start) - 'a'] == 0){
                    count--;
                }
                start++;
            }
        }
        
        return res;
    }
}
