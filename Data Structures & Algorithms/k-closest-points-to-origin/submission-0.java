class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> minh = new PriorityQueue<>((a,b)-> Integer.compare(a[0],b[0]));

        for(int i=0;i<points.length;i++) {
            
            int dis  = points[i][0]*points[i][0] +points[i][1]*points[i][1];
            minh.add(new int[]{dis,points[i][0], points[i][1]});
            
        }
        int[][] res = new int[k][2];

        for(int i=0;i<k;i++) {
            int[] point  = minh.poll();
            res[i]  = new int[]{point[1],point[2]};
        }

        return res;

    }
}
