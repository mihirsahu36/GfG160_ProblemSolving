/*Word Break
You are given a string s and a list dictionary[] of words. Your task is to determine whether the string s can be formed by concatenating one or more words from the dictionary[].
Note: From dictionary[], any word can be taken any number of times and in any order.

Examples :

Input: s = "ilike", dictionary[] = ["i", "like", "gfg"]
Output: true
Explanation: s can be breakdown as "i like".

Input: s = "ilikegfg", dictionary[] = ["i", "like", "man", "india", "gfg"]
Output: true
Explanation: s can be breakdown as "i like gfg".

Input: s = "ilikemangoes", dictionary[] = ["i", "like", "man", "india", "gfg"]
Output: false
Explanation: s cannot be formed using dictionary[] words.

Constraints:

1 ≤ s.size() ≤ 3000
1 ≤ dictionary.size() ≤ 1000
1 ≤ dictionary[i].size() ≤ 100*/

class Solution {
    public boolean wordBreak(String s, String[] dictionary) {
        // code here
        HashSet<String> set = new HashSet<>(Arrays.asList(dictionary));
        int n = s.length();
        boolean []t = new boolean[n+1];
        t[0] = true;

        for(int i=1;i<=n;i++){
            for(int j=i-1;j>=Math.max(0,i-100);j--){
                if (t[j] && set.contains(s.substring(j, i))) {
                    t[i] = true;
                    break;
                }
            }
        }

        return t[n];
    }
}
