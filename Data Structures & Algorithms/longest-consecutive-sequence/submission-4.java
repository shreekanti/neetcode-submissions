class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> s = new HashSet<>();

        for(int i=0;i<nums.length;i++) {
            s.add(nums[i]);
        }

        int res =0;

        for(int i =0;i<nums.length;i++) {
            int count=0;
            int curr = nums[i];

            while(s.contains(curr)) {
                count++;
                curr++;
            }

            res= Math.max(res, count);
        }
        return res;
    }
}
