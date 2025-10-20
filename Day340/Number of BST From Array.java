/* Number of BST From Array
You are given an integer array arr[] containing distinct elements.
Your task is to return an array where the ith element denotes
the number of unique BSTs formed when arr[i] is chosen as the root.

Examples :

Input: arr[] = [2, 1, 3]
Output: [1, 2, 2]

Input: arr[] = [2, 1]
Ouput: [1, 1]

Constraints:

1 ≤ arr.size() ≤ 6
1 ≤ arr[i] ≤ 15 */

class Solution {
    private ArrayList<Integer> computeFact(int num){
        ArrayList<Integer> fact = new ArrayList<>(Collections.nCopies(num + 1, 1));
        
        for(int i=1;i<=num;i++){
            fact.set(i, fact.get(i - 1) * i);
        }
        
        return fact;
    }
    
    private int catalan(int n, ArrayList<Integer> fact){
        return fact.get(2 * n) / (fact.get(n) * fact.get(n + 1));
    }
    
    public ArrayList<Integer> countBSTs(int[] arr) {
        // Code here
        int n = arr.length;
        int[][] sorted = new int[n][2];
        
        for(int i=0;i<n;i++){
            sorted[i][0] = arr[i];
            sorted[i][1] = i;
        }
        
        Arrays.sort(sorted, Comparator.comparingInt(a -> a[0]));
        
        ArrayList<Integer> fact = computeFact(2 * n);
        ArrayList<Integer> res = new ArrayList<>(Collections.nCopies(n, 0));
        
        for(int i=0;i<n;i++){
            int j = sorted[i][1];
            res.set(j, catalan(i, fact) * catalan(n - i - 1, fact));
        }
        
        return res;
    }
}
