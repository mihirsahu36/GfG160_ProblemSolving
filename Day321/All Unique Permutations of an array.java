/* All Unique Permutations of an array
Given an array arr[] that may contain duplicates. Find all possible distinct permutations of the array in sorted order.
Note: A sequence A is greater than sequence B if there is an index i for which Aj = Bj for all j<i and Ai > Bi.

Examples:

Input: arr[] = [1, 3, 3]
Output: [[1, 3, 3], [3, 1, 3], [3, 3, 1]]
Explanation: These are the only possible distinct permutations for the given array.

Input: arr[] = [2, 3]
Output: [[2, 3], [3, 2]]
Explanation: These are the only possible distinct permutations for the given array.

Constraints:

1 ≤ arr.size() ≤ 9 */

class Solution {
    public static ArrayList<ArrayList<Integer>> uniquePerms(int[] arr) {
        // code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Arrays.sort(arr);
        Map<Integer, Integer> freq = new HashMap<>();
        
        for(int num : arr){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        
        solve(arr.length, new ArrayList<>(), freq, res);
        return res;
    }
    
    private static void solve(int n, ArrayList<Integer> curr, Map<Integer, Integer> freq, ArrayList<ArrayList<Integer>> res){
        if(curr.size() == n){
            res.add(new ArrayList<>(curr));
            return;
        }
        
        for(int key : new TreeSet<>(freq.keySet())){
            if(freq.get(key) > 0){
                curr.add(key);
                freq.put(key, freq.get(key) - 1);
                
                solve(n, curr, freq, res);
                
                curr.remove(curr.size() - 1);
                freq.put(key, freq.get(key) + 1);
            }
        }
    }
};
