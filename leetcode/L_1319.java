class Solution {
    public int makeConnected(int n, int[][] connections) {
        int res = 0;
        int cc = 0;
        int red = 0;
        UF uf = new UF(n);
        Set<Integer> set = new HashSet<>();
        for(int[] co : connections){
            int x = co[0];
            int y = co[1];
            if(uf.union(x, y)){

            }else{
                red++;
            }
        }
        
        for(int i = 0; i < n; i++){
            set.add(uf.find(i));
        }
        
        cc = set.size();
        //System.out.println("cc is " + cc);
        //System.out.println("red is " + red);
        return red + 1 >= cc ? cc - 1 : -1;
    }
}

class UF {
    int[] arr;
    
    UF(int n){
        arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = i;
        }
    }
    //if both successfully become new union, we return true
    public boolean union(int x, int y){
        boolean success = true;
        int xr = find(x);
        int yr = find(y);
        
        if(xr != yr){
            arr[xr] = yr;
            return success;
        }
        return !success;
    }
    
    public int find(int x){
        if(x != arr[x]){
            arr[x] = find(arr[x]);
        }
        return arr[x];
    }
}

