/*Longest String Chain
You are given an array of words where each word consists of lowercase English letters.
wordA is a predecessor of wordB if and only if we can insert exactly one letter anywhere in wordA without changing the order of the other characters to make it equal to wordB.
For example, "abc" is a predecessor of "abac", while "cba" is not a predecessor of "bcad".

A word chain is a sequence of words [word1, word2, ..., wordk] with k >= 1, where word1 is a predecessor of word2,
word2 is a predecessor of word3, and so on. A single word is trivially a word chain with k = 1.
Return the length of the longest possible word chain with words chosen from the given list of words in any order.

Examples:

Input: words[] = ["ba", "b", "a", "bca", "bda", "bdca"]
Output: 4
Explanation: One of the longest word chains is ["a", "ba", "bda", "bdca"].

Input: words[] = ["abc", "a", "ab"]
Output: 3
Explanation: The longest chain is {"a", "ab" "abc"}

Input: words[] = ["abcd", "dbqca"]
Output: 1
Explanation: The trivial word chain ["abcd"] is one of the longest word chains.

Constraint:

1 <= words.length <= 10^4
1 <= words[i].length <= 10
words[i] only consists of lowercase English letters.*/

// Approach 1 (Using bottom up) - TLE
class Solution {
    public int longestStringChain(String words[]) {
        // code here
        int n = words.length;
        Arrays.sort(words, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
        int []t = new int[n];
        Arrays.fill(t, 1);
        int maxLength = 1;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(predecessor(words[j], words[i])){
                    t[i] = Math.max(t[i], t[j] + 1);
                    maxLength = Math.max(maxLength, t[i]);
                }
            }
        }
        
        return maxLength;
    }
    
    public boolean predecessor(String prev, String curr){
        int m = prev.length();
        int n = curr.length();
        
        if(m >= n || n - m != 1){
            return false;
        }
        
        int i = 0, j = 0;
        while(i < m && j < n){
            if(prev.charAt(i) == curr.charAt(j)){
                i++;
            }
            j++;
        }
        
        return i == m;
    }
}

// Approach 2 (Using HashMap)
class Solution {
    public int longestStringChain(String words[]) {
        // code here
        Arrays.sort(words, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
        HashMap<String, Integer> map = new HashMap<>();
        int maxLength = 1;
        
        for(String word : words){
            int currLength = 1;
            
            for(int i=0;i<word.length();i++){
                String predecessor = word.substring(0, i) + word.substring(i + 1);
                
                if(map.containsKey(predecessor)){
                    currLength = Math.max(currLength, map.get(predecessor) + 1);
                }
            }
            
            map.put(word, currLength);
            
            maxLength = Math.max(maxLength, currLength);
        }
        
        return maxLength;
    }
}
