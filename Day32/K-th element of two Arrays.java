/*K-th element of two Arrays
Given two sorted arrays a[] and b[] and an element k, the task is to find the element that would be at the kth position of the combined sorted array.

Examples :

Input: a[] = [2, 3, 6, 7, 9], b[] = [1, 4, 8, 10], k = 5
Output: 6
Explanation: The final combined sorted array would be [1, 2, 3, 4, 6, 7, 8, 9, 10]. The 5th element of this array is 6.

Input: a[] = [100, 112, 256, 349, 770], b[] = [72, 86, 113, 119, 265, 445, 892], k = 7
Output: 256
Explanation: Combined sorted array is [72, 86, 100, 112, 113, 119, 256, 265, 349, 445, 770, 892]. The 7th element of this array is 256.

Constraints:

1 <= a.size(), b.size() <= 10^6
1 <= k <= a.size() + b.size()
0 <= a[i], b[i] < 10^8*/

class Solution {
    public int kthElement(int a[], int b[], int k) {
        // code here
        int n1 = a.length;
        int n2 = b.length;
        
        if(n1 > n2){ // ensure binary search is performed on the smaller array
            return kthElement(b, a, k);
        }
        
        int low = Math.max(0, k - n2);
        int high = Math.min(k, n1);
        
        while(low <= high){
            int mid1 = (low + high) / 2; // number of elements taken from 'a'
            int mid2 = k - mid1;  // remaining elements taken from 'b'
            
            int l1 = (mid1 == 0) ? Integer.MIN_VALUE : a[mid1 - 1]; // left of 'a''s partition
            int l2 = (mid2 == 0) ? Integer.MIN_VALUE : b[mid2 - 1]; // left of 'b''s partition
            int r1 = (mid1 == n1) ? Integer.MAX_VALUE : a[mid1]; // right of 'a''s partition
            int r2 = (mid2 == n2) ? Integer.MAX_VALUE : b[mid2]; // right of 'b''s partition
            
            // Check if partitions are valid
            if(l1 <= r2 && l2 <= r1){
                return Math.max(l1, l2); // return the k-th element
            }else if(l1 > r2){
                high = mid1 - 1; // move left in 'a'
            }else{
                low = mid1 + 1; // move right in 'a'
            }
        }
        return -1;
    }
}
