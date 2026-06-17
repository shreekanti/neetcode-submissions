class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxh = new PriorityQueue<>((a,b)-> b[0]-a[0]);

        for(int i=0;i<points.length;i++) {
            int[] point = points[i];

            int dis = point[0]*point[0] + point[1]*point[1];
            maxh.add(new int[]{dis,point[0],point[1]});

            if(maxh.size()>k) {
                maxh.poll();
            }
        }
        int[][] res = new int[k][2];
        int count=0;
        while(!maxh.isEmpty()) {
            int[] entry = maxh.poll();
            res[count++] = new int[]{entry[1],entry[2]};
        }
        return res;
        

    }
}
