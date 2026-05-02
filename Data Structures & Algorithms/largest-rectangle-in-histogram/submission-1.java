class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        Stack<Integer> s = new Stack<>();
        int max =0;

        for(int i=0;i<n;i++) {
            while(!s.isEmpty() && heights[s.peek()]>=heights[i]) {
                int ind = s.peek();
                s.pop();
                int nse = i;
                int pse = s.isEmpty()?-1:s.peek();
                max =Math.max(max, heights[ind]*(nse-pse-1));
            }
            s.push(i);
        }

        while(!s.isEmpty()) {
            int ind = s.peek();
            s.pop();
            int nse = n;
            int pse = s.isEmpty()?-1:s.peek();
            max =Math.max(max, heights[ind]*(nse-pse-1));
        }
        return max;
    }
}
