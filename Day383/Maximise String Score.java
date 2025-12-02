/* Maximise String Score
You are given a string s, and a list of jumps[][] of size n,
where each jumps[i] = [s1, s2] denotes that you are allowed to jump from character s1 to s2 in the forward direction.
Additionally, you are allowed to jump forward from a character to any other occurrence of the same character within the string.
You start at index 0 of the string. After every valid jump from index i to index j, where s[i] = s1 and s[j] = s2,
you earn a score equal to the sum of ASCII values of all characters between the jump except for the characters equals s2, i.e.
score(i, j) = sum(ascii(s[k]) for i ≤ k < j and s[k] != s[j]).
Determine the maximum score that can be achieved by performing a sequence of valid jumps starting from index 0.

Examples:

Input: s = "forgfg", jumps[][] = [['f', 'r'], ['r', 'g']]
Output: 429
Explanation: We can jump from 'f' to 'r' at index 2,
this will gives a score equals to sum of ASCII value of 'f', 'o' i.e. 213.
Now we can jump from 'r' to 'g' at index 5,
this will gives a score equals to sum of ASCII value of 'r', 'f' i.e. 216.
Hence maximum total score obtain will be 429. 

Input: s = "abcda", jumps[][] = [[b, d]]
Output: 297
Explanation: We can jump from 'a' to 'a'(as both are same character) at index 4,
this will gives a score equals to sum of ASCII value of 'b', 'c', 'd' i.e. 297.
Hence maximum total score obtain will be 297. 

Constraints:

1 ≤ |s| ≤ 2 * 10^5
1 ≤ jumps.size() ≤ 676
There are atleast two distinct characters in s. */

class Solution {
    public int maxScore(String s, char[][] jumps) {
        // code here
        int n = s.length();
        ArrayList<char[]> jumpsList = new ArrayList<>();
        for(int i=0;i<jumps.length;i++){
            jumpsList.add(new char[]{jumps[i][0], jumps[i][1]});
        }
        for(char ch='a';ch<='z';ch++){
            jumpsList.add(new char[]{ch, ch});
        }

        int [][]nxtInd = new int[n][26];
        for(int i=0;i<n;i++){
            Arrays.fill(nxtInd[i], -1);
        }
        int []lastInd = new int[26];
        Arrays.fill(lastInd, -1);

        for(int i=n-1;i>=0;i--){
            for(int j=0;j<26;j++){
                nxtInd[i][j] = lastInd[j];
            }
            lastInd[s.charAt(i) - 'a'] = i;
        }

        ArrayList<ArrayList<Integer>> child = new ArrayList<>();
        for(int i=0;i<26;i++){
            child.add(new ArrayList<>());
        }
        for(int i=0;i<jumpsList.size();i++){
            char u = jumpsList.get(i)[0];
            char v = jumpsList.get(i)[1];
            child.get(u - 'a').add((int) v);
        }

        int []preScore = new int[n + 1];
        for(int i=0;i<s.length();i++){
            preScore[i + 1] = preScore[i] + s.charAt(i);
        }

        int []dp = new int[n];

        for(int ind=n-2;ind>=0;ind--){
            int score = 0;
            for(int it : child.get(s.charAt(ind) - 'a')){
                int jmpInd = nxtInd[ind][it - 'a'];
                if(jmpInd == -1){
                    continue;
                }

                if(it == s.charAt(ind)){
                    int temp = preScore[jmpInd] - preScore[ind + 1] + dp[jmpInd];
                    score = Math.max(score, temp);
                }else{
                    int temp = preScore[jmpInd] - preScore[ind] + dp[jmpInd];
                    score = Math.max(score, temp);
                }
            }
            dp[ind] = score;
        }

        return dp[0];
    }
}
