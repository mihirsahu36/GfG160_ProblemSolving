/* Balancing Consonants and Vowels Ratio
You are given an array of strings arr[], where each arr[i] consists of lowercase english alphabets.
You need to find the number of balanced strings in arr[] which can be formed by concatinating one or more contiguous strings of arr[].
A balanced string contains the equal number of vowels and consonants. 

Examples:

Input: arr[] = ["aeio", "aa", "bc", "ot", "cdbd"]
Output: 4
Explanation: arr[0..4], arr[1..2], arr[1..3], arr[3..3] are the balanced substrings with equal consonants and vowels.

Input: arr[] = ["ab", "be"]
Output: 3
Explanation: arr[0..0], arr[0..1], arr[1..1] are the balanced substrings with equal consonants and vowels.

Input: arr[] = ["tz", "gfg", "ae"]
Output: 0
Explanation: There is no such balanced substring present in arr[] with equal consonants and vowels.

Constraints:

1 ≤ arr.size() ≤ 10^5
1 ≤ arr[i].size() ≤ 10^5
Total number of lowercase english characters in arr[] is lesser than 10^5. */

class Solution {
    public int countBalanced(String[] arr) {
        // code here
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        String vowels = "aeiou";
        int balance = 0;
        int count = 0;
        
        for(String s : arr){
            int vowelCount = 0, consonantCount = 0;
            for(char ch : s.toCharArray()){
                if(vowels.indexOf(ch) != -1){
                    vowelCount++;
                }else{
                    consonantCount++;
                }
            }
            
            balance += (vowelCount - consonantCount);
            count += map.getOrDefault(balance, 0);
            map.put(balance, map.getOrDefault(balance, 0) + 1);
        }
        
        return count;
    }
}
