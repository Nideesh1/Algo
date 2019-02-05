class Solution {
    public int[] anagramMappings(int[] A, int[] B) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < B.length; i++){
            map.put(B[i], i);
        }
        int[] res = new int[A.length];
        for(int i = 0; i < A.length; i++){
            res[i] = map.get(A[i]);
        }
        return res;
    }
}

//https://leetcode.com/tag/hash-table/
