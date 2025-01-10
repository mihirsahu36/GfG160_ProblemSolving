/*Count distinct elements in every window
Given an integer array arr[] and a number k. Find the count of distinct elements in every window of size k in the array.

Examples:

Input: arr[] = [1, 2, 1, 3, 4, 2, 3], k = 4
Output:  [3, 4, 4, 3]
Explanation: Window 1 of size k = 4 is 1 2 1 3. Number of distinct elements in this window are 3. 
Window 2 of size k = 4 is 2 1 3 4. Number of distinct elements in this window are 4.
Window 3 of size k = 4 is 1 3 4 2. Number of distinct elements in this window are 4.
Window 4 of size k = 4 is 3 4 2 3. Number of distinct elements in this window are 3.

Input: arr[] = [4, 1, 1], k = 2
Output: [2, 1]
Explanation: Window 1 of size k = 2 is 4 1. Number of distinct elements in this window are 2. 
Window 2 of size k = 2 is 1 1. Number of distinct elements in this window is 1. 

Input: arr[] = [1, 1, 1, 1, 1], k = 3
Output: [1, 1, 1]

Constraints:

1 <= k <= arr.size() <= 10^5
1 <= arr[i] <= 10^5*/

class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0;i<k;i++){ // first window
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        res.add(map.size());
        
        for(int i=k;i<arr.length;i++){ // Slide the window across the array
            map.put(arr[i-k], map.get(arr[i-k]) - 1);
            if(map.get(arr[i-k]) == 0){ // if integer frequency is 0 then remove the integer from map
                map.remove(arr[i-k]);
            }
            
            map.put(arr[i], map.getOrDefault(arr[i] , 0) + 1); // add the new integer in the current window to the map
            
            res.add(map.size());
        }
        return res;
    }
}
