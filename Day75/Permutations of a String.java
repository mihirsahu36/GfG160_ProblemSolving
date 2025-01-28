/*Permutations of a String
Given a string s, which may contain duplicate characters, your task is to generate and return an array of all unique permutations of the string. You can return your answer in any order.

Examples:

Input: s = "ABC"
Output: ["ABC", "ACB", "BAC", "BCA", "CAB", "CBA"]
Explanation: Given string ABC has 6 unique permutations.

Input: s = "ABSG"
Output: ["ABGS", "ABSG", "AGBS", "AGSB", "ASBG", "ASGB", "BAGS", "BASG", "BGAS", "BGSA", "BSAG", "BSGA", "GABS", "GASB", "GBAS", "GBSA", "GSAB", "GSBA", "SABG", "SAGB", "SBAG", "SBGA", "SGAB", "SGBA"]
Explanation: Given string ABSG has 24 unique permutations.

Input: s = "AAA"
Output: ["AAA"]
Explanation: No other unique permutations can be formed as all the characters are same.

Constraints:

1 <= s.size() <= 9
s contains only Uppercase english alphabets*/

class Solution {
    public ArrayList<String> findPermutation(String s) {
        // Code here
        HashSet<String> res = new HashSet<>();
        boolean []visit = new boolean[s.length()];
        makePermutation(s, res, "", visit);
        return new ArrayList(res);
    }
    
    static void makePermutation(String s, HashSet<String> res, String curr, boolean []visit){
        if(curr.length() == s.length()){
            res.add(curr);
            return;
        }
        
        for(int i=0;i<s.length();i++){
            if(!visit[i]){
                visit[i] = true;
                makePermutation(s, res, curr + s.charAt(i), visit);
                visit[i] = false;
            }
        }
    }
}
