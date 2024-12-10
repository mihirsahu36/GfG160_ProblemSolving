/*Non-overlapping Intervals
Given a 2D array intervals[][] of representing intervals where intervals [i] = [starti, endi ]. Return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

Examples:

Input: intervals[][] = [[1, 2], [2, 3], [3, 4], [1, 3]]
Output: 1
Explanation: [1, 3] can be removed and the rest of the intervals are non-overlapping.

Input: intervals[][] = [[1, 3], [1, 3], [1, 3]]
Output: 2
Explanation: You need to remove two [1, 3] to make the rest of the intervals non-overlapping.

Input: intervals[][] = [[1, 2], [5, 10], [18, 35], [40, 45]]
Output: 0
Explanation: All ranges are already non overlapping.

Constraints:

1 ≤ intervals.size() ≤  10^5
|intervalsi| == 2
0 ≤ starti < endi <=5*10^4*/

class Solution {
    static int minRemoval(int intervals[][]) {
        // code here
        int n = intervals.length;
        Arrays.sort(intervals, (a,b) -> a[1] - b[1]); // sort the array respect to end index
        int end = intervals[0][1];
        int count = 1;
        for(int i=1;i<n;i++){ // traverse to each interval
            if(intervals[i][0] >= end){ // if curr interval starti >= previous interval endi increment count and update new endi
                count++;
                end = intervals[i][1];
            }
        }
        return n - count;
    }
}
