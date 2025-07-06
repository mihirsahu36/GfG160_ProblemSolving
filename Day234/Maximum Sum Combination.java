/* Maximum Sum Combination
Difficulty: MediumAccuracy: 49.69%Submissions: 87K+Points: 4Average Time: 30m
You are given two integer arrays a[] and b[] of equal size.
A sum combination is formed by adding one element from a[] and one from b[], using each index pair (i, j) at most once.
Return the top k maximum sum combinations, sorted in non-increasing order.

Examples:

Input: a[] = [3, 2], b[] = [1, 4], k = 2
Output: [7, 6]
Explanation: Possible sums: 3 + 1 = 4, 3 + 4 = 7, 2 + 1 = 3, 2 + 4 = 6, Top 2 sums are 7 and 6.

Input: a[] = [1, 4, 2, 3], b[] = [2, 5, 1, 6], k = 3
Output: [10, 9, 9]
Explanation: The top 3 maximum possible sums are : 4 + 6 = 10, 3 + 6 = 9, and 4 + 5 = 9

Constraints:

1 ≤ a.size() = b.size() ≤ 10^5
1 ≤ k ≤ a.size()
1 ≤ a[i], b[i] ≤ 10^4 */

class Solution {
    private void reverse(int []arr){
        int left = 0, right = arr.length - 1;
        while(left < right){
            int temp = arr[left];
            arr[left++] = arr[right];
            arr[right--] = temp;
        }
    }
    
    public ArrayList<Integer> topKSumPairs(int[] a, int[] b, int k) {
        // code here
        int n = a.length;
        Arrays.sort(a);
        reverse(a);
        Arrays.sort(b);
        reverse(b);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> Integer.compare(y[0],x[0]));
        HashSet<String> set = new HashSet<>();
        
        pq.offer(new int[]{a[0] + b[0], 0, 0});
        set.add("0#0");
        
        ArrayList<Integer> res = new ArrayList<>();
        
        while(res.size() < k && !pq.isEmpty()){
            int []top = pq.poll();
            int sum = top[0], i = top[1], j = top[2];
            res.add(sum);
            
            if(j + 1 < n && !set.contains(i + "#" + (j + 1))){
                pq.offer(new int[]{a[i] + b[j+1], i, j + 1});
                set.add(i + "#" + (j + 1));
            }
            
            if(i + 1 < n && !set.contains((i + 1) + "#" + j)){
                pq.offer(new int[]{a[i+1] + b[j], i + 1, j});
                set.add((i + 1) + "#" + j);
            }
        }
        
        return res;
    }
}
