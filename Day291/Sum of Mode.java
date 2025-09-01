/* Sum of Mode
Given an array arr[] of positive integers and an integer k.
You have to find the sum of the modes of all the subarrays of size k.
Note: The mode of a subarray is the element that occurs with the highest frequency.
If multiple elements have the same highest frequency, the smallest such element is considered the mode.

Examples:

Input: arr[] = [1, 2, 3, 2, 5, 2, 4, 4], k = 3
Output: 13
Explanation: The mode of each k size subarray is [1, 2, 2, 2, 2, 4] and sum of all modes is 13.

Input: arr[] = [1, 2, 1, 3, 5], k = 2
Output: 6
Explanation: The mode of each k size subarray is [1, 1, 1, 3] and sum of all modes is 6.

Constraints:

1 ≤ k ≤ arr.size() ≤10^5
1 ≤ arr[i] ≤ 10^5 */

class Solution {
    public int sumOfModes(int[] arr, int k) {
        // code here
        int n = arr.length;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        TreeSet<int[]> set = new TreeSet<>(new Comparator<int[]>(){
            public int compare(int []a, int []b){
                if(a[0] != b[0]){
                    return Integer.compare(a[0], b[0]);
                }
                return Integer.compare(a[1], b[1]);
            }
        });
        
        for(int i=0;i<k;i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        
        for(Map.Entry<Integer, Integer> x : map.entrySet()){
            set.add(new int[]{x.getValue(), -x.getKey()});
        }
        
        int mode = -set.last()[1];
        sum += mode;
        
        for(int i=k;i<n;i++){
            int outgoing = arr[i-k];
            int incoming = arr[i];
            
            int outFreq = map.get(outgoing);
            set.remove(new int[]{outFreq, -outgoing});
            
            map.put(outgoing, outFreq - 1);
            
            if(map.get(outgoing) > 0){
                set.add(new int[]{map.get(outgoing), -outgoing});
            }else{
                map.remove(outgoing);
            }
            
            map.put(incoming, map.getOrDefault(incoming, 0) + 1);
            
            set.add(new int[]{map.get(incoming), -incoming});
            
            mode = -set.last()[1];
            sum += mode;
        }
        
        return sum;
    }
}
