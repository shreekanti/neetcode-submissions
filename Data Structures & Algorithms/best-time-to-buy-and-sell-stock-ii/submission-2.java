class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // int[][] dp = new int[n+1][2];
        int[] cur = new int[2];
        int[] prev = new int[2];
        prev[0] = prev[1] =0;
        for(int ind=n-1;ind>=0;ind--) {
            for(int buy=0;buy<=1;buy++) {
               int profit=0;
               if(buy==1) {
                 profit = Math.max(-prices[ind] + prev[0], 0+prev[1]);
               }else {
                 profit = Math.max(prices[ind]+prev[1], 0+prev[0]);
                }
               cur[buy] =  profit;
            }
            prev =cur;
            
        }
        return cur[1];
    }
}