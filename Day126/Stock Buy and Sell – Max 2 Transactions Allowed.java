/*Stock Buy and Sell – Max 2 Transactions Allowed
In daily share trading, a trader buys shares and sells them on the same day.
If the trader is allowed to make at most 2 transactions in a day, find out the maximum profit that a share trader could have made.
You are given an array prices[] representing stock prices throughout the day.
Note that the second transaction can only start after the first one is complete (buy->sell->buy->sell).

Examples:

Input: prices[] = [10, 22, 5, 75, 65, 80]
Output: 87
Explanation: 
Trader will buy at 10 and sells at 22. 
Profit earned in 1st transaction = 22 - 10 = 12. 
Then he buys at 5 and sell at 80. 
Profit earned in 2nd transaction = 80 - 5 = 75. 
Total profit earned = 12 + 75 = 87. 

Input: prices[] = [2, 30, 15, 10, 8, 25, 80]
Output: 100
Explanation: 
Trader will buy at 2 and sells at 30. 
Profit earned in 1st transaction = 30 - 2 = 28. 
Then he buys at 8 and sell at 80. 
Profit earned in 2nd transaction = 80 - 8 = 72. 
Total profit earned = 28 + 72 = 100.

Constraints:

1 <= prices.size() <= 10^5
1 <= prices[i] <= 10^5*/

class Solution {
    public static int solve(int []prices, int k, int i, int transCount, int [][]t){
        int n = prices.length;
        
        if(i == n || transCount == 2 * k){
            return 0;
        }
        
        if(t[i][transCount] != -1){
            return t[i][transCount];
        }
        
        if(transCount % 2 == 0){
            int buy = -prices[i] + solve(prices, k, i + 1, transCount + 1, t);
            int notBuy = solve(prices, k, i + 1, transCount, t);
            
            t[i][transCount] = Math.max(buy, notBuy);
        }else{
           int sell = prices[i] + solve(prices, k, i + 1, transCount + 1, t);
           int notSell = solve(prices, k, i + 1, transCount, t);
           
           t[i][transCount] = Math.max(sell, notSell);
        }
        
        return t[i][transCount];
    }
    public static int maxProfit(int prices[]) {
        // code here
        int k = 2;
        int n = prices.length;
        if(n == 0 || k == 0){
            return 0;
        }
        
        int [][]t = new int[n][2*k];
        for(int []row : t){
            Arrays.fill(row, -1);
        }
        
        return solve(prices, k, 0, 0, t);
    }
}
