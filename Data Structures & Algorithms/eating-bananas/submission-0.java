class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int max = piles[0];
        for(int i=1;i<n;i++) {
            max= Math.max(max, piles[i]);
        }

        int low =1;
        int high=max;

        while(low<=high) {
            int mid = (low+high)/2;
            int hour = findHour(piles,mid);
            if(hour<=h) {
                high = mid-1;
            }else {
                low = mid+1;
            }
        }

        return low;
    }

    public int findHour(int[] piles, int k) {
        int hour =0;
        for(int i=0;i<piles.length;i++) {
            hour+=(int)Math.ceil((double)piles[i]/k);
        }
        System.out.println(hour);
        return hour;
    }
}
