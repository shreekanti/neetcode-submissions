class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        List<Integer> nums = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        for(int i=0;i<n;i++) {
            nums.add(arr[i]);
        }

        Collections.sort(nums, (a,b)-> {
        int diff1 =Math.abs(x-a);
        int diff2 = Math.abs(x-b);
        
        if(diff1==diff2) {
            return a-b;
        }
        return diff1-diff2;
    });
        ans = nums.subList(0,k);
        Collections.sort(ans);
        return ans;

        //tc -nlogn sc -o(1)


    }
}