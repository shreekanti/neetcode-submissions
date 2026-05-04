class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;

        int sum =0;
        int max =weights[0];
        for(int i=0;i<n;i++) {
            max= Math.max(max, weights[i]);
            sum+=weights[i];
        }

        int low =max;
        int high = sum;

        while(low<=high) {
            int mid  = (low+high)/2;

            int daysReq = daysRequired(weights,mid);

            if(daysReq<=days) {
                high =mid-1;
            }else {
                low=mid+1;
            }
        }
        return low;
    }

    public int daysRequired(int[] weights, int capacity) {
        int day =1;
        int load=0;
        for(int i=0;i<weights.length;i++) {
            if(load+weights[i]>capacity) {
                day=day+1;
                load = weights[i];
            }else {
                load+=weights[i];
            }
        }
        return day;
    }
    //log(sum-max+1)*O(n) sc O(1)
}