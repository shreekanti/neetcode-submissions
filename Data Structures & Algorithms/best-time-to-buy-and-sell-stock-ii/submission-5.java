class Solution {
    public int maxProfit(int[] prices) {
        int n= prices.length;
        int[][] dp = new int[prices.length+1][2];
        dp[prices.length][0] = dp[prices.length][1] =0;
        for(int ind=n-1;ind>=0;ind--) {
            for(int canbuy=0;canbuy<=1;canbuy++) {
                int res =0;
                if(canbuy==1) {
                res = Math.max(-prices[ind] + dp[ind+1][0], 0 + dp[ind+1][1]);
        }else {
            res = Math.max(prices[ind] +dp[ind+1][1] , 0 + dp[ind+1][0]);
        }
        dp[ind][canbuy]=res;
           
        }
        }
        return dp[0][1];
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