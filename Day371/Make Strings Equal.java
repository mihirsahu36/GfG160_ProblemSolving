/* Make Strings Equal
Given two strings s and t, consisting of lowercase English letters.
You are also given, a 2D array transform[][], where each entry [x, y]
means that you are allowed to transform character x into character y and an array cost[],
where cost[i] is the cost of transforming transform[i][0] into transform[i][1].
You can apply any transformation any number of times on either string.
Your task is to find the minimum total cost required to make the strings identical.
If it is impossible to make the two strings identical using the available transformations, return -1.

Examples:

Input: s = "abcc", t = "bccc", transform[][] = [['a', 'b'], ['b', 'c'], ['c', 'a']], cost[] = [2, 1, 4]
Output: 3
Explanation: We can convert both strings into "bccc" with a cost of 3 using these operations:
transform at Position 0 in s: a -> b (cost 2)
transform at Position 1 in s: b -> c (cost 1)
Other characters already match.

Input: s = "az", t = "dc", transform[][] = [['a', 'b'], ['b', 'c'], ['c', 'd'], ['a', 'd'], ['z', 'c']], cost[] = [5, 3, 2, 50, 10]
Output: 20
Explanation: We can convert both strings into "dc" with a cost of 20 using these operations:
transform at Position 0 in s: a -> d by path a -> b -> c -> d (cost 5 + 3 + 2 = 10)
transform at Position 1 in s: z -> c (cost 10)

Input: s = "xyz", t = "xzy", transform[][] = [['x', 'y'], ['x', 'z']], cost[] = [3, 3]
Output: -1
Explanation: It is not possible to make the two strings equal.

Constraints:

1 ≤ s.size() = t.size() ≤ 10^5
1 ≤ transform.size() = cost.size() ≤ 500
'a' ≤ transform[i][0], transform[i][1] ≤ 'z'
1 ≤ cost[i] ≤ 500 */

class Solution {
    public int minCost(String s, String t, char[][] transform, int[] cost) {
        // code here
        int n = s.length();
        int [][]dist = new int[26][26];

        for(int i=0;i<26;i++){
            Arrays.fill(dist[i], (int)1e9);
            dist[i][i] = 0;
        }

        for(int i=0;i<transform.length;i++){
            int u = transform[i][0] - 'a';
            int v = transform[i][1] - 'a';
            dist[u][v] = Math.min(dist[u][v], cost[i]);
        }

        for(int k=0;k<26;k++){
            for(int i=0;i<26;i++){
                for(int j=0;j<26;j++){
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        int res = 0;

        for(int i=0;i<n;i++){
            int a = s.charAt(i) - 'a';
            int b = t.charAt(i) - 'a';

            if(a == b){
                continue;
            }

            int best = (int)1e9;

            for(int c=0;c<26;c++){
                if(dist[a][c] < 1e9 && dist[b][c] < 1e9){
                    best = Math.min(best, dist[a][c] + dist[b][c]);
                }
            }

            if(best == (int)1e9){
                return -1;
            }

            res += best;
        }

        return res;

    }
}
