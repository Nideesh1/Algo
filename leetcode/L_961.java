class Solution {
    public int repeatedNTimes(int[] A) {
        int n = A.length/2;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i < A.length; i++){
                if(!map.containsKey(A[i])){ map.put(A[i], 1);}else{
                    int g = map.get(A[i]);
                    map.put(A[i], g+1);
                }
        }
        System.out.println(map);
        for(Map.Entry<Integer,Integer> e: map.entrySet()){
            int v = e.getValue();
            if(v == n){return e.getKey();}
        }
        return 0;
    }
}

//https://leetcode.com/problems/n-repeated-element-in-size-2n-array/description/
