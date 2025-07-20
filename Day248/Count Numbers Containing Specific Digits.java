/* Count Numbers Containing Specific Digits
You are given an integer n representing the number of digits in a number, and an array arr[] containing digits from 0 to 9.
Your have to count how many n-digit positive integers can be formed such that at least one digit from the array arr[] appears in the number.

Examples:

Input: n = 1, arr[] = [1, 2, 3]
Output: 3
Explanation: Only the single-digit numbers [1, 2, 3] satisfy the condition.

Input: n = 2, arr[] = [3, 5]
Output: 34
Explanation: There are a total of 34  two digit numbers which contain atleast  one out of  [3, 5].

Constraints:

1 ≤ n ≤ 9
1 ≤ arr.size() ≤ 10
0 ≤ arr[i] ≤ 9 */

class Solution {
    public int countValid(int n, int[] arr) {
        // code here
        HashSet<Integer> requiredDigits = new HashSet<>();
        for(int digit : arr){
            requiredDigits.add(digit);
        }
        
        List<Integer> nonRequiredDigits = new ArrayList<>();
        for(int i=0;i<=9;i++){
            if(!requiredDigits.contains(i)){
                nonRequiredDigits.add(i);
            }
        }
        
        if(nonRequiredDigits.size() == 0){
            return 9 * (int)Math.pow(10, n - 1);
        }
        
        int totalNumbers = 9 * (int)Math.pow(10, n - 1);
        int excludeCount = 0;
        
        if(n == 1){
            for(int digit : nonRequiredDigits){
                if(digit != 0){
                    excludeCount++;
                }
            }
        }else{
            int firstDigitChoices = 0;
            for(int digit : nonRequiredDigits){
                if(digit != 0){
                    firstDigitChoices++;
                }
            }
            
            int otherDigitChoices  = (int)Math.pow(nonRequiredDigits.size(), n - 1);
            excludeCount = firstDigitChoices * otherDigitChoices;
        }
        
        return totalNumbers - excludeCount;
    }
}
