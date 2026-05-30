class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxh = new PriorityQueue<>((a,b)-> Integer.compare(b[0],a[0]));

        for(int i=0;i<points.length;i++) {
            
            int dis  = points[i][0]*points[i][0] +points[i][1]*points[i][1];
            maxh.add(new int[]{dis,points[i][0], points[i][1]});
            if(maxh.size()>k) {
                maxh.poll();
            } 
            
        }
        int[][] res = new int[k][2];

        for(int i=0;i<k;i++) {
            int[] point  = maxh.poll();
            res[i]  = new int[]{point[1],point[2]};
        }

        return res;

    }
}
