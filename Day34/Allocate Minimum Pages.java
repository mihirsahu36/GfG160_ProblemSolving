/*Allocate Minimum Pages
You are given an array arr[] of integers, where each element arr[i] represents the number of pages in the ith book. You also have an integer k representing the number of students. The task is to allocate books to each student such that:
Each student receives atleast one book.
Each student is assigned a contiguous sequence of books.
No book is assigned to more than one student.
The objective is to minimize the maximum number of pages assigned to any student. In other words, out of all possible allocations, find the arrangement where the student who receives the most pages still has the smallest possible maximum.
Note: Return -1 if a valid assignment is not possible, and allotment should be in contiguous order (see the explanation for better understanding).

Examples:

Input: arr[] = [12, 34, 67, 90], k = 2
Output: 113
Explanation: Allocation can be done in following ways:
[12] and [34, 67, 90] Maximum Pages = 191
[12, 34] and [67, 90] Maximum Pages = 157
[12, 34, 67] and [90] Maximum Pages = 113.
Therefore, the minimum of these cases is 113, which is selected as the output.

Input: arr[] = [15, 17, 20], k = 5
Output: -1
Explanation: Allocation can not be done.

Input: arr[] = [22, 23, 67], k = 1
Output: 112

Constraints:

1 <=  arr.size() <= 10^6
1 <= arr[i] <= 10^3
1 <= k <= 10^3 */

class Solution {
    public static int findPages(int[] arr, int k) {
        // code here
        if (k > arr.length) { // if number of student greater than number of books to be allocated
            return -1;
        }
        
        int start = 0, end = 0;
        
        for(int i : arr){ // start will be max element out of array and end will be total sum of elements
            start = Math.max(start, i);
            end  += i;
        }
        int res = start; // result can be initialize to lowest possible value of maxPages
        while(start <= end){ // binary search
            int mid = start + (end - start) / 2;
            if(isPossible(arr, k, mid)){
                res = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return res;
    }
    public static boolean isPossible(int []arr, int k, int maxPages){
        int count = 1, currSum = 0;
        for(int i : arr){
            currSum += i;
            if(currSum > maxPages){ // if adding current book exceed maxPage
                count++;
                currSum = i; // start with new allocation with the current book.
                if(count > k){ // if number of students exceeds k allocation is not possible
                    return false;
                }
            }
        }
        return true;
    }
}
