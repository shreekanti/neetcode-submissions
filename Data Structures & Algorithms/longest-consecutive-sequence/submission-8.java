class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> s = new HashSet<>();
        int res=0;

        for(int i=0;i<nums.length;i++) {
            s.add(nums[i]);
        }

        for(int i=0;i<nums.length;i++) {
            if(s.contains(nums[i]-1)) {
                continue;
            }

            int length=1;
            int curr= nums[i];

            while(s.contains(curr+length)) {
                length++;
            }
            res= Math.max(res, length);
        }
        return res;
    }
}
