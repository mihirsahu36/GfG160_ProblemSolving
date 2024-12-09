/*Insert Interval
Geek has an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith event and intervals is sorted in ascending order by starti. He wants to add a new interval newInterval= [newStart, newEnd] where newStart and newEnd represent the start and end of this interval.
Help Geek to insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

Examples:

Input: intervals = [[1,3], [4,5], [6,7], [8,10]], newInterval = [5,6]
Output: [[1,3], [4,7], [8,10]]
Explanation: The newInterval [5,6] overlaps with [4,5] and [6,7].

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,9]
Output: [[1,2], [3,10], [12,16]]
Explanation: The new interval [4,9] overlaps with [3,5],[6,7],[8,10].

Constraints:

1 ≤ intervals.size() ≤  10^5
0 ≤ start[i], end[i] ≤ 10^9*/

class Solution {
    static ArrayList<int[]> insertInterval(int[][] intervals, int[] newInterval) {
        // code here
        ArrayList<int[]> res = new ArrayList<>();
        int i = 0, n = intervals.length;
        
        while(i < n && intervals[i][1] < newInterval[0]){ // if endi of intervals < starti of newInterval
            res.add(intervals[i]);
            i++;
        }
        
        while(i < n && intervals[i][0] <= newInterval[1]){ // if starti of intervals <= endi of newInterval
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        res.add(newInterval);
        
        while(i < n){
            res.add(intervals[i]);
            i++;
        }
        return res;
    }
}
