class Solution {
    public int countComponents(int n, int[][] edges) {
        UF uf = new UF(n);
        for(int[] e : edges){
            uf.union(e[0], e[1]);
        }
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            set.add(uf.find(i));
        }      
        return set.size();
    }
}

class UF{
    Subset[] sub;
    public UF(int N){
        sub = new Subset[N];
        
        for(int i = 0; i < N; i++){
            sub[i] = new Subset();
            sub[i].parent = i; sub[i].rank = 0;
        }
    }
    int find(int x){
        if(x != sub[x].parent){
            sub[x].parent = find(sub[x].parent);
        }
        return sub[x].parent;
    }
    void union(int x, int y){
        int xr = find(x); int yr = find(y);
        if(sub[xr].rank < sub[yr].rank){
            sub[xr].parent = sub[yr].parent;
        }
        if(sub[xr].rank > sub[yr].rank){
            sub[yr].parent = sub[xr].parent;
        }else{
            sub[xr].parent = sub[yr].parent;
            sub[yr].rank++;
        }
        
    }
}

class Subset{
    int parent; int rank;
}

//https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
