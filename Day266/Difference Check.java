/* Difference Check
Given an array arr[] of time strings in 24-hour clock format "HH:MM:SS",
return the minimum difference in seconds between any two time strings in the arr[].
The clock wraps around at midnight, so the time difference between "23:59:59" and "00:00:00" is 1 second.

Examples:

Input: arr[] = ["12:30:15", "12:30:45"]
Output: 30
Explanation: The minimum time difference is 30 seconds.

Input: arr[] = ["00:00:01", "23:59:59", "00:00:05"]
Output: 2
Explanation: The time difference is minimum between "00:00:01" and "23:59:59".

Constraints:

2 ≤ arr.size() ≤ 10^5
arr[i] is in "HH:MM:SS" format. */

class Solution {
    public int minDifference(String[] arr) {
        // code here
        boolean []timeSeen = new boolean[86400];
        for(String time : arr){
            int sec = convertToSec(time);
            if(timeSeen[sec]){
                return 0;
            }
            timeSeen[sec] = true;
        }
        
        int minDiff = Integer.MAX_VALUE;
        int first = -1, prev = -1;
        for(int i=0;i<86400;i++){
            if(timeSeen[i]){
                if(first == -1){
                    first = i;
                }
                if(prev != -1){
                    minDiff = Math.min(minDiff, i - prev);
                }
                prev = i;
            }
        }
        
        minDiff = Math.min(minDiff, (86400 - prev + first));
        
        return minDiff;
    }
    
    private int convertToSec(String time){
        String []parts = time.split(":");
        int h = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        int s = Integer.parseInt(parts[2]);
        
        return h * 3600 + m * 60 + s;
    }
}
