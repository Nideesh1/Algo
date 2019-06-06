class Solution {
    public int findCircleNum(int[][] M) {
        int N = M.length;
        UF uf = new UF(N);
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(i == j) continue;
                if(M[i][j] == 1){
                    uf.union(i, j);
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < N; i++){
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

//https://leetcode.com/problems/friend-circles/
