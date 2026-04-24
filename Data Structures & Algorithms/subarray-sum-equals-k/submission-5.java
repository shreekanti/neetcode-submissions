class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;

        int prefix =0;

        Map<Integer, Integer> map = new HashMap<>();

        map.put(0,1);
        int count=0;

        for(int i=0;i<n;i++) {
            prefix+=nums[i];
            int remain = prefix-k;
            if(map.containsKey(remain)) {
                count+=map.get(remain);
            }
            map.put(prefix,map.getOrDefault(prefix,0)+1);
        }

        return count;

    }
}