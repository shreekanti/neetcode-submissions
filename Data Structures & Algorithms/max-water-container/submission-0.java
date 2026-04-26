class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int i =0;
        int j = n-1;
        int max =0;
        while(i<j) {
            int h = Math.min(heights[i], heights[j]);
            int w = j-i;
            max = Math.max(max, h*w);
            if(heights[i]<heights[j]) {
                i++;
            }else {
                j--;
            }
        }
        return max;
    }
}
