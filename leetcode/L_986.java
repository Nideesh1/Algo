class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> res = new ArrayList<>();
        int i = 0; int j = 0;
        while(i < A.length && j < B.length){
            if(block(A[i], B[j]) != null){
                res.add(block(A[i], B[j]));
            }
            
            if(A[i][1] < B[j][1]){
                i++;
            }else{
                j++;
            }
        }
        int[][] ret = new int[res.size()][2];
        for(int k = 0; k < ret.length; k++){
            ret[k] = res.get(k);
        }
        return ret;
    }
    
    public int[] block(int[] a, int[] b){
        int front = Math.max(a[0],b[0]);
        int back = Math.min(a[1], b[1]);
        return back >= front ? new int[]{front, back}: null;
    }    
    
}

//https://leetcode.com/problems/interval-list-intersections/
//https://leetcode.com/problems/interval-list-intersections/solution/
