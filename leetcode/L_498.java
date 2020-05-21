class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix.length == 0) return new int[]{};
        Map<Integer,List<Integer>> map = new HashMap<>();
        int tot = 0; int max = 0;
        for(int i = matrix.length - 1; i >= 0; i--){
            for(int j = 0; j < matrix[i].length; j++){
                int sum = i + j;
                List<Integer> l = map.getOrDefault(sum, new ArrayList<>());
                l.add(matrix[i][j]);
                map.put(sum, l);
                max = Math.max(max, sum);
                tot++;
            }
        }
        int[] res = new int[tot]; boolean up = true; int p = 0;
        for(int i = 0; i <= max; i++){
            List<Integer> list = map.get(i);
            if(up){
                for(int l = 0; l < list.size(); l++){
                    res[p++] = list.get(l);
                }
            }else{
                for(int l = list.size() - 1; l >= 0; l--){
                    res[p++] = list.get(l);
                }                
            }
            up = !up;
        }
        
        return res;
    }
}

