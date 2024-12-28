/*Find All Triplets with Zero Sum
Given an array arr[], find all possible triplets i, j, k in the arr[] whose sum of elements is equals to zero. 
Returned triplet should also be internally sorted i.e. i<j<k.

Examples:

Input: arr[] = [0, -1, 2, -3, 1]
Output: [[0, 1, 4], [2, 3, 4]]
Explanation: Triplets with sum 0 are:
arr[0] + arr[1] + arr[4] = 0 + (-1) + 1 = 0
arr[2] + arr[3] + arr[4] = 2 + (-3) + 1 = 0

Input: arr[] = [1, -2, 1, 0, 5]
Output: [[0, 1, 2]]
Explanation: Only triplet which satisfies the condition is arr[0] + arr[1] + arr[2] = 1 + (-2) + 1 = 0

Input: arr[] = [2, 3, 1, 0, 5]
Output: [[]]
Explanation: There is no triplet with sum 0.

Constraints:

3 <= arr.size() <= 10^3
-10^4 <= arr[i] <= 10^4*/

class Solution {
    public List<List<Integer>> findTriplets(int[] arr) {
        // Your code here
        HashMap<Integer, List<int[]>> map = new HashMap<>(); // to store sum and pair of indices
        HashSet<List<Integer>> set = new HashSet<>(); // to store unique triplets to avoid duplicates
        int n = arr.length;
        
        for(int i=0;i<n;i++){ // find all pairs of elements and store their sums with their indices
            for(int j=i+1;j<n;j++){
                int sum = arr[i] + arr[j];
                if(!map.containsKey(sum)){ // if sum not present already in map
                    map.put(sum, new ArrayList<>());
                }
                map.get(sum).add(new int[]{i, j}); // if sum present already in map
            }
        }
        
        for(int i=0;i<n;i++){ // find a pair whose sum equals the negative of the current element
            int target  = -arr[i];
            if(map.containsKey(target)){
                List<int[]> pairs = map.get(target); // get all pairs which matches the target sum
                for(int []pair : pairs){
                    if(pair[0] != i && pair[1] != i){ // ensure that element are not reused
                        List<Integer> tripletRes = Arrays.asList(i, pair[0], pair[1]); // list of triplet
                        Collections.sort(tripletRes); // make the triplets in sorted order
                        set.add(tripletRes); // add to the set
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }
}
