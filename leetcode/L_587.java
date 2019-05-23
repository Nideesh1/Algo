class Solution {
    public int[][] outerTrees(int[][] points) {
        int[][] res = null; int n = points.length;
        List<int[]> list = new ArrayList<>();
        if(n < 4) return points;
        int l = 0;
        int p = 0, q = 0;
        for(int i = 0; i < n; i++){
            if(points[i][0] < points[l][0]){
                l = i;
            }
        }
        p = l;
        do{
            list.add(points[p]);
            q = (p+1) % n ;

            //find q which is the most counterclock point from p
            for(int i = 0; i < n; i++){
                if(orient(points[p], points[i], points[q]) == 2){
                    q = i;
                }
            }
            System.out.println("p is " + Arrays.toString(points[p]));
            System.out.println("q is " + Arrays.toString(points[q]));
            //add any points directly between p and q
            for(int i = 0; i < n; i++){
                if(i != p && i != q && orient(points[p], points[i], points[q]) == 0 && onSeg(points[p], points[q], points[i])){
                    list.add(points[i]);
                }
            }
            
            //switch main to q
            p = q;
            
        }while(p != l);
        //System.out.println(list.size());
        res = new int[list.size()][2];
        for(int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
    }
    
    //if r is on seg p,q
    public boolean onSeg(int[] p, int[] q, int[] r){
        return r[0] >= Math.min(p[0], q[0]) && r[0] <= Math.max(p[0], q[0]) && r[1] >= Math.min(p[1], q[1]) && r[1] <= Math.max(p[1], q[1]);
    }
    
    public int orient(int[] p, int[] q, int[] r){
        int v = (q[1] - p[1])*(r[0]-q[0]) - (r[1]-q[1])*(q[0]-p[0]);
        if(v == 0 ) return 0;
        return v > 0 ? 1 : 2;
    }
}

//https://leetcode.com/problems/erect-the-fence/solution/
