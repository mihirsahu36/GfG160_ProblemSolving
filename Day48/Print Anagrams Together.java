/*Print Anagrams Together
Given an array of strings, return all groups of strings that are anagrams. The groups must be created in order of their appearance in the original array. Look at the sample case for clarification.

Note: The final output will be in lexicographic order.

Examples:

Input: arr[] = ["act", "god", "cat", "dog", "tac"]
Output: [["act", "cat", "tac"], ["god", "dog"]]
Explanation: There are 2 groups of anagrams "god", "dog" make group 1. "act", "cat", "tac" make group 2.
Input: arr[] = ["no", "on", "is"]
Output: [["is"], ["no", "on"]]
Explanation: There are 2 groups of anagrams "is" makes group 1. "no", "on" make group 2.

Input: arr[] = ["listen", "silent", "enlist", "abc", "cab", "bac", "rat", "tar", "art"]
Output: [["abc", "cab", "bac"], ["listen", "silent", "enlist"], ["rat", "tar", "art"]]
Explanation: 
Group 1: "abc", "bac", and "cab" are anagrams.
Group 2: "listen", "silent", and "enlist" are anagrams.
Group 3: "rat", "tar", and "art" are anagrams.

Constraints:

1<= arr.size() <=100
1<= arr[i].size() <=10*/

class Solution {
    public ArrayList<ArrayList<String>> anagrams(String[] arr) {
        // code here
        HashMap<String, List<String>> map = new HashMap<>(); // map, the key is sorted word and the value is a list of words that match the key when sorted 
        
        for(String str : arr){
            char []ch = str.toCharArray();
            Arrays.sort(ch);
            String sortedWord = String.valueOf(ch);  // convert the sorted character array back to string
            
            if(!map.containsKey(sortedWord)){ // if the sorted string is not present in map then nitialize a new list for it
                map.put(sortedWord, new ArrayList());
            }
            map.get(sortedWord).add(str); // add the original word to the list corresponding to its sorted key
        }
        return new ArrayList(map.values());
    }
}