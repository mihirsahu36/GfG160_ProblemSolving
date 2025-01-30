/*Implement Pow
Implement the function power(b, e), which calculates b raised to the power of e (i.e. be).

Examples:

Input: b = 3.00000, e = 5
Output: 243.00000

Input: b = 0.55000, e = 3
Output: 0.16638

Input: b = -0.67000, e = -7
Output: -16.49971

Constraints:

-100.0 < b < 100.0
-10^9 <= e <= 10^9
Either b is not zero or e > 0.
-10^4 <= be <= 10^4*/

class Solution {
    double power(double b, int e) {
        // code here
        if(e == 0){
            return 1;
        }
        
        if(e == 1){
            return b;
        }
        
        if(e < 0){
            return 1 / power(b, -e);
        }
        
        double halfPower = power(b, e / 2);
        
        if(e % 2 == 0){
            return halfPower * halfPower;
        }
        
        return b * halfPower * halfPower;
    }
}
