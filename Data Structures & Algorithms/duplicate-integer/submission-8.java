class Solution {
    public boolean hasDuplicate(int[] nums) {
        //optimal
        int n = nums.length;

        Set<Integer> s = new HashSet<>();

        for(int i=0;i<n;i++) {
            if(s.contains(nums[i])) {
                return true;
            }
            s.add(nums[i]);
        }
        return false;
    }

    //Tc -O(n) SC-O(n)
}