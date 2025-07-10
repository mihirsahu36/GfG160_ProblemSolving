/* Find the longest string
Given an array of strings words[]. Find the longest string in words[] such that every prefix of it is also present in the array words[]. 
Note: If multiple strings have the same maximum length, return the lexicographically smallest one.

Examples:

Input: words[] = ["p", "pr", "pro", "probl", "problem", "pros", "process", "processor"]
Output: pros
Explanation: "pros" is the longest word with all prefixes ("p", "pr", "pro", "pros") present in the array words[].

Input: words[] = ["ab", "a", "abc", "abd"]
Output: abc
Explanation: Both "abc" and "abd" has all the prefixes in words[]. Since, "abc" is lexicographically smaller than "abd", so the output is "abc".

Constraints:

1 ≤ words.length() ≤ 10^3 */

class Solution {
    class TrieNode{
        boolean isEndofWord;
        TrieNode []child = new TrieNode[26];
        
        TrieNode(){
            isEndofWord = false;
        }
    }
    
    private TrieNode root = new TrieNode();
    
    private void insert(String word){
        TrieNode crawler = root;
        
        for(char c : word.toCharArray()){
            int idx = c - 'a';
            if(crawler.child[idx] == null){
                crawler.child[idx] = new TrieNode();
            }
            crawler = crawler.child[idx];
        }
        crawler.isEndofWord = true;
    }
    
    private boolean search(String word){
        TrieNode crawler = root;
        
        for(char c : word.toCharArray()){
            int idx = c - 'a';
            crawler = crawler.child[idx];
            if(crawler == null || !crawler.isEndofWord){
                return false;
            }
        }
        return true;
    }
    
    public String longestString(String[] words) {
        // code here
        for(String word : words){
            insert(word);
        }
        
        String res = "";
        
        for(String word : words){
            if(search(word)){
                if(word.length() > res.length() || (word.length() == res.length() && word.compareTo(res) < 0)){
                    res = word;
                }
            }
        }
        
        return res;
    }
}
