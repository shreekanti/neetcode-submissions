class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for(int i=0;i<prices.length;i++) {
            Arrays.fill(dp[i],-1);
        }
        return f(0, 1 , prices, dp);
    }


    public int f(int ind, int canbuy, int[] prices, int[][] dp) {
        if(ind==prices.length) {
            return 0;
        }
        if(dp[ind][canbuy]!=-1) return dp[ind][canbuy];
        int res =0;
        if(canbuy==1) {
            res = Math.max(-prices[ind] + f(ind+1, 0,prices, dp) , 0 + f(ind+1, 1,prices, dp));
        }else {
            res = Math.max(prices[ind] +f(ind+1, 1,prices, dp) , 0 + f(ind+1, 0, prices, dp));
        }
        return dp[ind][canbuy]=res;
    }
}