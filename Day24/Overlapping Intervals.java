/*Overlapping Intervals
Given an array of Intervals arr[][], where arr[i] = [starti, endi]. The task is to merge all of the overlapping Intervals.

Examples:

Input: arr[][] = [[1,3],[2,4],[6,8],[9,10]]
Output: [[1,4], [6,8], [9,10]]
Explanation: In the given intervals we have only two overlapping intervals here, [1,3] and [2,4] which on merging will become [1,4]. Therefore we will return [[1,4], [6,8], [9,10]].

Input: arr[][] = [[6,8],[1,9],[2,4],[4,7]]
Output: [[1,9]]
Explanation: In the given intervals all the intervals overlap with the interval [1,9]. Therefore we will return [1,9].

Constraints:

1 ≤ arr.size() ≤ 10^5
0 ≤ starti ≤ endi ≤ 10^5*/

class Solution {
    public List<int[]> mergeOverlap(int[][] arr) {
        // Code here // Code here
        List<int[]> res = new ArrayList<>();
        
        Arrays.sort(arr, (a, b) -> a[0] - b[0]); // sorting the interval based on start index
        
        int start = arr[0][0], end = arr[0][1]; // Initialize start and end with the first interval's values
        
        for(int i=1;i<arr.length;i++){
            if(arr[i][0] <= end){ // overlap condition
                end = Math.max(arr[i][1], end);
            }else{ // add the current interval to the result list
                int []newInterval = new int[]{start, end};
                res.add(newInterval);
                
                start = arr[i][0];
                end = arr[i][1];
            }
        }
        int []newInterval = new int[]{start, end}; // adding the last interval to the result list
        res.add(newInterval);
        
        return res;
    }
}
