class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        int maxKey = 0, n = 0, i = 0;
        for (int r = nums.size() - 1; r >= 0; r--) {
            for (int c = 0; c < nums.get(r).size() ; c++) {
                List<Integer> list = map.getOrDefault(r + c, new ArrayList<>());
                list.add(nums.get(r).get(c));
                map.put(r + c, list);
                maxKey = Math.max(maxKey, r + c);
                n++;
            }
        }
        
        int[] res = new int[n];
        for (int key = 0; key <= maxKey ; key ++) {
            if (!map.containsKey(key)) continue;
            for (int k : map.get(key)) res[i++] = k;
        }
        //System.out.println(map);
        return res;
    }
}
