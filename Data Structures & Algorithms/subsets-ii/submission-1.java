class Solution {

    class Pair {
        int ind;
        List<Integer> arr;

        public Pair(int ind, List<Integer> arr) {
            this.ind = ind;
            this.arr = arr;
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(0, new ArrayList<>()));

        Map<Integer, List<List<Integer>>> map = new HashMap<>();

        
        map.put(0, new ArrayList<>());

        while (!q.isEmpty()) {

            Pair curr = q.poll();

            if (curr.ind == nums.length) {
                res.add(new ArrayList<>(curr.arr));
                continue;
            }

          
           

            List<List<Integer>> skipLists =
                    map.getOrDefault(curr.ind + 1, new ArrayList<>());

            if (!skipLists.contains(curr.arr)) {

                skipLists.add((curr.arr));
                map.put(curr.ind + 1, skipLists);

                q.add(new Pair(curr.ind + 1, curr.arr));
            }

            
            List<Integer> take = new ArrayList<>(curr.arr);
            take.add(nums[curr.ind]);

            List<List<Integer>> takeLists =
                    map.getOrDefault(curr.ind + 1, new ArrayList<>());

            if (!takeLists.contains(take)) {

                takeLists.add(new ArrayList<>(take));
                map.put(curr.ind + 1, takeLists);

                q.add(new Pair(curr.ind + 1, take));
            }
        }

        return res;
    }
}