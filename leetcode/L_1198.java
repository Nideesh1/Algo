class Solution {
public int smallestCommonElement(int[][] mat) {
        int M = mat.length;
        int N = mat[0].length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int[] ints : mat) {
            map.put(ints[0], map.getOrDefault(ints[0], 0) + 1);

            for (int j = 1; j < N; j++) {
                if (ints[j] != ints[j - 1])
            map.put(ints[j], map.getOrDefault(ints[j], 0) + 1);

            }
        }
    
    
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == M) {
                return entry.getKey();
            }
        }
        return -1;
    }
}
//https://leetcode.com/problems/find-smallest-common-element-in-all-rows/discuss/386998/Simple-hashMap-Solution
