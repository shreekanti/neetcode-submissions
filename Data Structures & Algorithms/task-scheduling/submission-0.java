class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];

        for(int i=0;i<tasks.length;i++) {
            freq[tasks[i]-'A']++;
        }

        PriorityQueue<Integer> maxh = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<26;i++) {
            if(freq[i]>0) {
                maxh.add(freq[i]);
            }
        }

        Queue<int[]> q = new LinkedList<>();
        int time=0;

        while(!maxh.isEmpty() || !q.isEmpty()) {
            time++;
            if(!maxh.isEmpty()) {
                int cnt = maxh.poll() -1;
                if(cnt>0) {
                    q.add(new int[]{cnt, time+n});
                }
            }

            if(!q.isEmpty()  && q.peek()[1]==time) {
                maxh.add(q.poll()[0]);
            }
        }
        return time;
    }
}
