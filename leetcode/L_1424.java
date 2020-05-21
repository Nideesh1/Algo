class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        int max = 0; int tot = 0;
        for(int i = nums.size() - 1; i >= 0; i--){
            for(int j = 0; j < nums.get(i).size(); j++){
                int sum = i + j;
                max = Math.max(max, sum);
                List<Integer> list = map.getOrDefault(sum, new ArrayList<>());
                list.add(nums.get(i).get(j));
                map.put(sum, list);
                tot++;
            }
        }

        int[] res = new int[tot]; int p = 0;
        for(int i = 0; i <= max; i++){
            List<Integer> each = map.get(i);
            for(Integer k : each) res[p++] = k;
        }
        
        return res;
    }
}

//https://leetcode.com/problems/diagonal-traverse-ii/discuss/597698/JavaC%2B%2B-HashMap-with-Picture-Clean-code-O(N)