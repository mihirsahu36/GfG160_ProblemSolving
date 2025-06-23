/*Minimum sum
Given an array arr[ ] consisting of digits, your task is to form two numbers using all the digits such that their sum is minimized.
Return the minimum possible sum as a string with no leading zeroes.

Examples :

Input: arr[] = [6, 8, 4, 5, 2, 3]
Output: "604"
Explanation: The minimum sum is formed by numbers 358 and 246.

Input: arr[] = [5, 3, 0, 7, 4]
Output: "82"
Explanation: The minimum sum is formed by numbers 35 and 047.

Input: arr[] = [9, 4]
Output: "13"
Explanation: The minimum sum is formed by numbers 9 and 4.

Constraints:

2 ≤ arr.size() ≤ 10^6
0 ≤ arr[i] ≤ 9*/

class Solution {
    String addString(String s1, String s2){
        int i = s1.length() - 1;
        int j = s2.length() - 1;
        int carry = 0;
        StringBuilder res = new StringBuilder();
        
        while(i >= 0 || j >= 0 || carry > 0){
            int sum = carry;
            
            if(i >= 0){
                sum += s1.charAt(i) - '0';
                i--;
            }
            
            if(j >= 0){
                sum += s2.charAt(j) - '0';
                j--;
            }
            
            res.append(sum % 10);
            carry = sum / 10;
        }
        
        return res.reverse().toString();
    }
    
    String minSum(int[] arr) {
        // code here
        int []count = new int[10];
        
        for(int num : arr){
            count[num]++;
        }
        
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        boolean flag = true;
        
        for(int digit=0;digit<10;digit++){
            while(count[digit]-- > 0){
                if(flag){
                    if(!(s1.length() == 0 && digit == 0)){
                        s1.append(digit);
                    }
                    flag = false;
                }else{
                    if(!(s2.length() == 0 && digit == 0)){
                        s2.append(digit);
                    }
                    flag = true;
                }
            }
        }
        
        return addString(s1.toString(), s2.toString());
    }
}
