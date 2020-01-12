class Solution {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        
        
        UF uf = new UF(n);
        int res = 0;
        List<int[]> edges = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            edges.add(new int[]{0, i, wells[i-1]});
        }
        
        for(int[] p : pipes){
            edges.add(new int[]{p[0], p[1], p[2]});
        }
        
        Comparator<int[]> co = (a, b) -> a[2] - b[2];
        Collections.sort(edges, co);
        
        for(int[] ed : edges){
            int xr = uf.find(ed[0]);
            int yr = uf.find(ed[1]);
            
            if(xr == yr)continue;
            
            uf.union(ed[0], ed[1]);
            res += ed[2];
        }
        
        return res;
    }
}

class UF{
    int[] ar;
    UF(int n){
        ar = new int[n + 1];
        for(int i = 1; i <= n; i++){
            ar[i] = i;
        }
    }
    
    public int find(int x){
        if(x != ar[x]){
            ar[x] = find(ar[x]);
        }
        return ar[x];
    }
    
    public void union(int x, int y){
        int xr = find(x);
        int yr = find(y);
        
        if(xr == yr) return;
        ar[xr] = yr;
    }
}

//https://leetcode.com/problems/optimize-water-distribution-in-a-village/discuss/365853/C++PythonJava-Hidden-Well-in-House-0/330223
