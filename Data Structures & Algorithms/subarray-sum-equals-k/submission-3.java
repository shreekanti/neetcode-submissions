class Solution {
    public int subarraySum(int[] nums, int k) {

        int n = nums.length;
        // int [] ps = new int[n+1];
        // ps[0]=0;
        int ps=0;
        // for(int i=0;i<n;i++){
        //     ps[i+1] = ps[i]+nums[i];
        // }
        // for(int i=0;i<n+1;i++){
        //     System.out.print(ps[i]);
            
        // }

        Map<Integer , Integer> mp = new HashMap<>();
        int ans=0;
        mp.put(0,1);

        for(int i=1;i<n+1;i++){
            ps+=nums[i-1];
            ans+=mp.getOrDefault(ps-k,0);
            mp.put(ps,mp.getOrDefault(ps,0)+1);
            System.out.println(ans);

        }

        return ans;



        
    }
}