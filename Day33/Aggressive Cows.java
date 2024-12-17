/*Aggressive Cows
You are given an array with unique elements of stalls[], which denote the position of a stall.
You are also given an integer k which denotes the number of aggressive cows. 
Your task is to assign stalls to k cows such that the minimum distance between any two of them is the maximum possible.

Examples :

Input: stalls[] = [1, 2, 4, 8, 9], k = 3
Output: 3
Explanation: The first cow can be placed at stalls[0], 
the second cow can be placed at stalls[2] and 
the third cow can be placed at stalls[3]. 
The minimum distance between cows, in this case, is 3, which also is the largest among all possible ways.

Input: stalls[] = [10, 1, 2, 7, 5], k = 3
Output: 4
Explanation: The first cow can be placed at stalls[0],
the second cow can be placed at stalls[1] and
the third cow can be placed at stalls[4].
The minimum distance between cows, in this case, is 4, which also is the largest among all possible ways.

Input: stalls[] = [2, 12, 11, 3, 26, 7], k = 5
Output: 1
Explanation: Each cow can be placed in any of the stalls, as the no. of stalls are exactly equal to the number of cows.
The minimum distance between cows, in this case, is 1, which also is the largest among all possible ways.

Constraints:

2 <= stalls.size() <= 10^6
0 <= stalls[i] <= 10^8
1 <= k <= stalls.size()*/

class Solution {
    public static int aggressiveCows(int[] stalls, int k) {
        // code here
        Arrays.sort(stalls);
        
        int n = stalls.length;
        int low = 0;
        int high = stalls[n - 1] - stalls[0];
        int res = 0;
        
        while(low <= high){ // binary search
            int mid = low + (high - low) / 2;
            if(canPlace(mid, k, stalls)){
                res = mid; // update the result as it is feasible
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return res;
    }
    
    public static boolean canPlace(int mid, int k, int[] stalls){ // check whether cows can be placed with minimum distance mid
        int count = 1, lastCow = stalls[0];
        for(int i=1;i<stalls.length;i++){
            if(stalls[i] - lastCow >= mid){
                count++;
                lastCow = stalls[i]; // update the last placed cow position
                if(count >= k){ // all cows are placed
                    return true;
                }
            }
        }
        return false;
    } 
}
