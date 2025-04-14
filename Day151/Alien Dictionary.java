/*Alien Dictionary
A new alien language uses the English alphabet, but the order of letters is unknown.
You are given a list of words[] from the alien language’s dictionary, where the words are claimed to be sorted lexicographically according to the language’s rules.
Your task is to determine the correct order of letters in this alien language based on the given words.
If the order is valid, return a string containing the unique letters in lexicographically increasing order as per the new language's rules. If there are multiple valid orders, return any one of them.
However, if the given arrangement of words is inconsistent with any possible letter ordering, return an empty string ("").
A string a is lexicographically smaller than a string b if, at the first position where they differ, the character in a appears earlier in the alien language than the corresponding character in b.
If all characters in the shorter word match the beginning of the longer word, the shorter word is considered smaller.
Note: Your implementation will be tested using a driver code. It will print true if your returned order correctly follows the alien language’s lexicographic rules; otherwise, it will print false.

Examples:

Input: words[] = ["baa", "abcd", "abca", "cab", "cad"]
Output: true
Explanation: A possible corrct order of letters in the alien dictionary is "bdac".
The pair "baa" and "abcd" suggests 'b' appears before 'a' in the alien dictionary.
The pair "abcd" and "abca" suggests 'd' appears before 'a' in the alien dictionary.
The pair "abca" and "cab" suggests 'a' appears before 'c' in the alien dictionary.
The pair "cab" and "cad" suggests 'b' appears before 'd' in the alien dictionary.
So, 'b' → 'd' → 'a' → 'c' is a valid ordering.

Input: words[] = ["caa", "aaa", "aab"]
Output: true
Explanation: A possible corrct order of letters in the alien dictionary is "cab".
The pair "caa" and "aaa" suggests 'c' appears before 'a'.
The pair "aaa" and "aab" suggests 'a' appear before 'b' in the alien dictionary. 
So, 'c' → 'a' → 'b' is a valid ordering.

Input: words[] = ["ab", "cd", "ef", "ad"]
Output: ""
Explanation: No valid ordering of letters is possible.
The pair "ab" and "ef" suggests "a" appears before "e".
The pair "ef" and "ad" suggests "e" appears before "a", which contradicts the ordering rules.

Constraints:

1 ≤ words.length ≤ 500
1 ≤ words[i].length ≤ 100
words[i] consists only of lowercase English letters.*/

class Solution {
    public String findOrder(String[] words) {
        // code here
        HashMap<Character, List<Character>> graph = new HashMap<>();
        HashMap<Character, Integer> inDegree = new HashMap<>();
        
        for(String word : words){
            for(char c : word.toCharArray()){
                graph.putIfAbsent(c, new ArrayList<>());
                inDegree.putIfAbsent(c, 0);
            }
        }
        
        for(int i=0;i<words.length-1;i++){
            String w1 = words[i], w2 = words[i + 1];
            if(w1.length() > w2.length() && w1.startsWith(w2)){
                return "";
            }
            
            for(int j=0;j<Math.min(w1.length(), w2.length());j++){
                char c1 = w1.charAt(j), c2 = w2.charAt(j);
                if(c1 != c2){
                    graph.get(c1).add(c2);
                    inDegree.put(c2, inDegree.get(c2) + 1);
                    break;
                }
            }
        }
        
        return topoSort(graph, inDegree);
    }
    
    private String topoSort(HashMap<Character, List<Character>> graph, HashMap<Character, Integer> inDegree){
        Queue<Character> queue = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        
        for(char c : inDegree.keySet()){
            if(inDegree.get(c) == 0){
                queue.offer(c);
            }
        }
            
        while(!queue.isEmpty()){
            char curr = queue.poll();
            res.append(curr);
            
            for(char ngbr : graph.get(curr)){
                inDegree.put(ngbr, inDegree.get(ngbr) - 1);
                if(inDegree.get(ngbr) == 0){
                    queue.offer(ngbr);
                }
            }
        }
        
        return res.length() == graph.size() ? res.toString() : "";
    }
}
