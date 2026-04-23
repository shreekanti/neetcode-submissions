class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();

        int n = nums.length;
        int e1 =-1;
        int e2=-1;
        int c1=0;
        int c2=0;

        for(int i=0;i<n;i++) {
            if(nums[i]!=e2 && c1==0){
                e1=nums[i];
                c1++;
            }else if(nums[i]!=e1 && c2==0) {
                e2=nums[i];
                c2++;
            }else if(nums[i] ==e1) {
                c1++;
            }else if (nums[i]==e2) {
                c2++;
            }else {
                c1--;
                c2--;
            }
        }

        int count = n/3;
        c1=0;
        c2=0;
        for(int i=0;i<n;i++) {
            if(nums[i]==e1) c1++;
            if(nums[i]==e2) c2++;
        }

        if(c1>count) {
            res.add(e1);
        }

        if(c2>count) {
            res.add(e2);
        }

        
        return res;
    }
}