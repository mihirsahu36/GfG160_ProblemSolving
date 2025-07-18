/*K closest elements
You are given a sorted array arr[] of unique integers, an integer k, and a target value x.
Return exactly k elements from the array closest to x, excluding x if it exists.
An element a is closer to x than b if:
a - x| < |b - x|, or
|a - x| == |b - x| and a > b (i.e., prefer the larger element if tied)
Return the k closest elements in order of closeness.

Examples:

Input: arr[] = [1, 3, 4, 10, 12], k = 2, x = 4
Output: 3 1
Explanation: 4 is excluded, Closest elements to 4 are: 3 (1), 1 (3). So, the 2 closest elements are: 3 1

Input: arr[] = [12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56], k = 4, x = 35
Output: 39 30 42 45
Explanation: First closest element to 35 is 39.
Second closest element to 35 is 30.
Third closest element to 35 is 42.
And fourth closest element to 35 is 45.

Constraints:

1 ≤ arr.size() ≤ 10^5
1 ≤ k ≤ arr.size()
1 ≤ x ≤ 10^6
1 ≤ arr[i] ≤ 10^6 */

// Approach 1
class Solution {
    int[] printKClosest(int[] arr, int k, int x) {
        // code here
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) ->{
            if(a[0] != b[0]) return a[0] - b[0];
            return b[1] - a[1];
        });
        
        for(int num : arr){
            if(num == x) continue;
            int diff = Math.abs(num - x);
            pq.offer(new int[]{diff, num});
        }
        
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<k&&!pq.isEmpty();i++){
            res.add(pq.poll()[1]);
        }
        
        int []resArr = new int[res.size()];
        for(int i=0;i<res.size();i++){
            resArr[i] = res.get(i);
        }
        
        return resArr;
    }
}

// Approach 2
class Solution {
    int[] printKClosest(int[] arr, int k, int x) {
        // code here
        int n = arr.length;
        int pos = -1;
        int low = 0, high = n - 1;
        
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(arr[mid] < x){
                pos = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        
        int left = pos, right = pos + 1;
        
        if(right < n && arr[right] == x){
            right++;
        }
        
        int []res = new int[k];
        int count = 0;
        
        while(left >= 0 && right < n && count < k){
            int leftDiff = Math.abs(arr[left] - x);
            int rightDiff = Math.abs(arr[right] - x);
            
            if(leftDiff < rightDiff){
                res[count++] = arr[left];
                left--;
            }else{
                res[count++] = arr[right];
                right++;
            }
        }
        
        while(left >= 0 && count < k){
            res[count++] = arr[left];
            left--;
        }
        
        while(right < n && count < k){
            res[count++] = arr[right];
            right++;
        }
        
        return res;
    }
}
