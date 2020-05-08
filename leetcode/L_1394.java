class Solution {
    public int findLucky(int[] arr) {
        int max = -1;
        Map<Integer,Integer> map = new HashMap<>();
        for(int a : arr){
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        for(int m : map.keySet()){
            if(m == map.get(m)) {
                max = Math.max(max, m);
            }
        }
        return max;
    }
}