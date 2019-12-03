class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int k = 0;
        int[] count = new int[1001],
        ans = new int[arr1.length];
        
        for(int i : arr1){
            count[i]++;
        }
        
        for(int i : arr2){
            while(count[i]-- > 0){
                ans[k++] = i;
            }
        }
        
        for(int i = 0; i < 1001; i++){
            while(count[i]-- > 0){
                ans[k++] = i;
            }
        }
        
        return ans;
    }
}


    class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int n : arr1) map.put(n, map.getOrDefault(n, 0) + 1);
        int i = 0;
        for(int n : arr2) {
            while(map.get(n) > 0) {
                arr1[i++] = n;
                map.put(n, map.get(n)-1);
            }
        }
        for(int n : map.keySet()){
            while(map.get(n) > 0) {
                arr1[i++] = n;
                map.put(n, map.get(n)-1);
            }
        }
        return arr1;
    }
}

//https://leetcode.com/problems/relative-sort-array/discuss/335056/Java-in-place-solution-using-counting-sort
