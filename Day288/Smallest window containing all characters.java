/* Smallest window containing all characters
Given two strings s and p. Find the smallest substring in s consisting of all the characters (including duplicates) of the string p.
Return empty string in case no such substring is present.
If there are multiple such substring of the same length found, return the one with the least starting index.

Examples:

Input: s = "timetopractice", p = "toc"
Output: "toprac"
Explanation: "toprac" is the smallest substring in which "toc" can be found.

Input: s = "zoomlazapzo", p = "oza"
Output: "apzo"
Explanation: "apzo" is the smallest substring in which "oza" can be found.

Input: s = "zoom", p = "zooe"
Output: ""
Explanation: No substring is present containing all characters of p.

Constraints: 

1 ≤ s.length(), p.length() ≤ 10^6
s, p consists of lowercase english letters */

// Approach 1
class Solution {
    private static boolean containsAllChars(String sub, String p){
        int []count = new int[256];
        for(int i=0;i<p.length();i++){
            count[p.charAt(i)]++;
        }
        
        for(int i=0;i<sub.length();i++){
            if(count[sub.charAt(i)] > 0){
                count[sub.charAt(i)]--;
            }
        }
        
        for(int i=0;i<256;i++){
            if(count[i] > 0){
                return false;
            }
        }
        
        return true;
    }
    
    public static String smallestWindow(String s, String p) {
        // code here
        int n = s.length();
        int minLen = Integer.MAX_VALUE;
        String res = "";
        
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                String sub = s.substring(i, j + 1);
                
                if(containsAllChars(sub, p)){
                    int currLen = sub.length();
                    
                    if(currLen < minLen){
                        minLen = currLen;
                        res = sub;
                    }
                }
            }
        }
        
        return res;
    }
}

// Approach 2
class Solution {
    public static String smallestWindow(String s, String p) {
        // code here
        int sLen = s.length();
        int pLen = p.length();
        
        if(sLen < pLen){
            return "";
        }
        
        int []sCount = new int[256];
        int []pCount = new int[256];
        
        for(int i=0;i<pLen;i++){
            pCount[p.charAt(i)]++;
        }
        
        int start = 0, startIdx = -1;
        int minLen = Integer.MAX_VALUE;
        int count = 0;
        
        for(int j=0;j<sLen;j++){
            char currChar = s.charAt(j);
            
            sCount[currChar]++;
            
            if(pCount[currChar] > 0 && sCount[currChar] <= pCount[currChar]){
                count++;
            }
            
            if(count == pLen){
                char startChar;
                while(sCount[startChar = s.charAt(start)] > pCount[startChar] || pCount[startChar] == 0){
                    if(sCount[startChar] > pCount[startChar]){
                        sCount[startChar]--;
                    }
                    
                    start++;
                }
                
                int len = j - start + 1;
                if(minLen > len){
                    minLen = len;
                    startIdx = start;
                }
            }
        }
        
        return (startIdx == -1) ? "" : s.substring(startIdx, startIdx + minLen);
    }
}
