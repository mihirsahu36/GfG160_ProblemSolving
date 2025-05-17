/*Sort the given array after applying the given equation
Given an integer array arr[] sorted in ascending order, along with three integers: A, B, and C.
The task is to transform each element x in the array using the quadratic function A*(x2) + B*x + C.
After applying this transformation to every element, return the modified array in sorted order.

Examples:

Input: arr[] = [-4, -2, 0, 2, 4], A = 1, B = 3, C = 5
Output: [3, 5, 9, 15, 33]
Explanation: After applying f(x) = 1*(x2)+ 3*x + 5 to each x, we get [9, 3, 5, 15, 33]. After sorting this array, the array becomes [3, 5, 9, 15, 33].

Input: arr[] = [-3, -1, 2, 4], A = -1, B = 0, C = 0
Output: [-16, -9, -4, -1]
Explanation: After applying f(x) = -1*(x2) + 0*x + 0 to each x, we get [ -9, -1, -4, -16 ]. After sorting this array, the array becomes  [-16, -9, -4, -1].

Constraints:

1 ≤ arr.size() ≤ 10^6
-103 ≤ arr[i], A, B, C ≤ 10^3*/

// Approach 1 (TLE)
class Solution {
    public ArrayList<Integer> sortArray(int[] arr, int A, int B, int C) {
        // Code here
        ArrayList<Integer> res = new ArrayList<>();
        
        for(int x : arr){
            int num = A * x * x + B * x + C;
            res.add(num);
        }
        
        Collections.sort(res);
        return res;
    }
}

// Approach 2
class Solution {
    private int solve(int x, int A, int B, int C){
        return A * x * x + B * x + C;
    }
    
    public ArrayList<Integer> sortArray(int[] arr, int A, int B, int C) {
        // Code here
        int n = arr.length;
        ArrayList<Integer> res = new ArrayList<>(Collections.nCopies(n, 0));
        int l = 0;
        int r = n - 1;
        int idx = (A >= 0) ? n - 1 : 0;
        
        while(l <= r){
            int leftVal = solve(arr[l], A, B, C);
            int rightVal = solve(arr[r], A, B, C);
            
            if(A >= 0){
                if(leftVal > rightVal){
                    res.set(idx--, leftVal);
                    l++;
                }else{
                    res.set(idx--, rightVal);
                    r--;
                }
            }else{
                if(leftVal < rightVal){
                    res.set(idx++, leftVal);
                    l++;
                }else{
                    res.set(idx++, rightVal);
                    r--;
                }
            }
        }
        
        return res;
    }
}
