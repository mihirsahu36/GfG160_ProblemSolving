/*Histogram Max Rectangular Area
You are given a histogram represented by an array arr, where each element of the array denotes the height of the bars in the histogram. All bars have the same width of 1 unit.
Your task is to find the largest rectangular area possible in the given histogram, where the rectangle can be formed using a number of contiguous bars.

Examples:

Input: arr[] = [60, 20, 50, 40, 10, 50, 60]
 Largest-Rectangular-Area-in-a-Histogram
Output: 100
Explanation: We get the maximum by picking bars highlighted above in green (50, and 60). The area is computed (smallest height) * (no. of the picked bars) = 50 * 2 = 100.

Input: arr[] = [3, 5, 1, 7, 5, 9]
Output: 15
Explanation:  We get the maximum by picking bars 7, 5 and 9. The area is computed (smallest height) * (no. of the picked bars) = 5 * 3 = 15.

Input: arr[] = [3]
Output: 3
Explanation: In this example the largest area would be 3 of height 3 and width 1.

Constraints:

1 ≤ arr.size() ≤ 10^5
0 ≤ arr[i] ≤ 10^4*/

class Solution {
    public static int getMaxArea(int arr[]) {
        // your code here
        int n = arr.length;
        int [] prevSmaller = new int[n];
        int [] nextSmaller = new int[n];
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0;i<n;i++){ // previous smaller elements
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }
            prevSmaller[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        
        stack.clear();
        
        for(int i=n-1;i>=0;i--){ // next smaller elements
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }
            nextSmaller[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i); 
        }
        
        for(int i=0;i<n;i++){ // maximum area calculation
            int w = nextSmaller[i] - prevSmaller[i] - 1;
            int area = arr[i] * w;
            maxArea = Math.max(maxArea, area);
        }
        
        return maxArea;
    }
}
