class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] persons) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        Arrays.sort(flowers, (a,b) -> a[0] - b[0]);
        for (int[] i : flowers) {
            map.put(i[0], map.getOrDefault(i[0], 0) + 1);
            map.put(i[1] + 1, map.getOrDefault(i[1] + 1, 0) - 1);
        }
        //System.out.println(map);
        int pre = 0, max = 0;
        TreeMap<Integer,Integer> bloom = new TreeMap<>();
        for (int k : map.keySet()){
            pre += map.get(k);
            bloom.put(k, pre);
            //System.out.println(k + " " + pre);
            max = Math.max(max, pre);
        }
        //System.out.println(bloom);
        int[] res = new int[persons.length];
        for (int i = 0; i < persons.length; i++) {
            if (bloom.floorKey(persons[i]) == null ) continue; 
            res[i] = bloom.getOrDefault(bloom.floorKey(persons[i]), 0);
        }
        return res;
    }
}
