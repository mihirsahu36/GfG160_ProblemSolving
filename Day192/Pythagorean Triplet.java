/*Pythagorean Triplet
Given an array arr[], return true if there is a triplet (a, b, c) from the array (where a, b, and c are on different indexes) that satisfies a2 + b2 = c2, otherwise return false.

Examples:

Input: arr[] = [3, 2, 4, 6, 5]
Output: true
Explanation: a=3, b=4, and c=5 forms a pythagorean triplet.

Input: arr[] = [3, 8, 5]
Output: false
Explanation: No such triplet possible.

Input: arr[] = [1, 1, 1]
Output: false

Constraints:

1 <= arr.size() <= 10^5
1 <= arr[i] <= 10^3*/

class Solution {
    boolean pythagoreanTriplet(int[] arr) {
        // code here
        int n = arr.length;
        int maxEl = 0;
        for(int i=0;i<n;i++){
            maxEl = Math.max(maxEl, arr[i]);
        }
        
        boolean []visited = new boolean[maxEl + 1];
        for(int i=0;i<n;i++){
            visited[arr[i]] = true;
        }
        
        for(int a=1;a<=maxEl;a++){
            if(!visited[a]){
                continue;
            }
        
            for(int b=1;b<=maxEl;b++){
                if(!visited[b]){
                    continue;
                }
        
                int c = (int)Math.sqrt(a * a + b * b);
                
                if((c * c) != (a * a + b * b) || c > maxEl){
                    continue;
                }
        
                if(visited[c]){
                    return true;
                }
            }
        }
        
        return false;
    }
}
