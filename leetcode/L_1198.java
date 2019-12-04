class Solution {
public int smallestCommonElement(int[][] mat) {
        int M = mat.length;
        int N = mat[0].length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int[] ints : mat) {
            if (map.containsKey(ints[0])) {
                map.put(ints[0], map.get(ints[0]) + 1);
            } else {
                map.put(ints[0], 1);
            }
            for (int j = 1; j < N; j++) {
                if (ints[j] != ints[j - 1])
                    if (map.containsKey(ints[j])) {
                        map.put(ints[j], map.get(ints[j]) + 1);
                    } else {
                        map.put(ints[j], 1);
                    }
            }
        }
    
        System.out.println(map);
    
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == M) {
                return entry.getKey();
            }
        }
        return -1;
    }
}
//https://leetcode.com/problems/find-smallest-common-element-in-all-rows/discuss/386998/Simple-hashMap-Solution
