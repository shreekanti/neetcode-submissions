class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxh = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<stones.length;i++) {
            maxh.add(stones[i]);
        }

        while(!maxh.isEmpty() && maxh.size()>1) {
            int diff = maxh.poll()-maxh.poll();

            if(diff>0) {
                maxh.add(diff);
            }
        }

        return maxh.isEmpty()?0:maxh.poll();
    }
}
