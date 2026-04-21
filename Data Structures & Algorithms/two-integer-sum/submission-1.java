class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[] res = new int[2];

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++) {
            map.put(nums[i],i);
        }

        for(int i=0;i<n;i++) {
            int find = target-nums[i];
            if(map.containsKey(find) && i!=map.get(find)) {
                return new int[]{i,map.get(find)};
            }
        }
        return new int[]{-1,-1};
    }
}
