class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n==0) return 0;
        HashSet<Integer> set = new HashSet<>();

        for(int i=0;i<n;i++) {
            set.add(nums[i]);
        }
        
        int ans = 0;
        for(int i=0;i<n;i++) {
            if(!set.contains(nums[i]-1)) {
                int count =1;
                int curr = nums[i];
                while(set.contains(curr+1)) {
                    curr++;
                    count++;
                }
                ans = Math.max(ans,count);
            }

        }
        return ans;
    }
}
