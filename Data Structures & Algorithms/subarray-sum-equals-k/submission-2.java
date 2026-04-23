class Solution {
    public int subarraySum(int[] nums, int k) {

        int n = nums.length;
        int [] ps = new int[n+1];
        ps[0]=0;
        for(int i=0;i<n;i++){
            ps[i+1] = ps[i]+nums[i];
        }
        for(int i=0;i<n+1;i++){
            System.out.print(ps[i]);
            
        }

        Map<Integer , Integer> mp = new HashMap<>();
        int ans=0;

        for(int i=0;i<n+1;i++){
            ans+=mp.getOrDefault(ps[i]-k,0);
            mp.put(ps[i],mp.getOrDefault(ps[i],0)+1);
            System.out.println(ans);

        }

        return ans;



        
    }
}