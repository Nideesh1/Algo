class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length + 1;
        UF uf = new UF(n);
        Map<Integer,List<Integer>> map = new HashMap<>();  
        List<int[]> l = new ArrayList();
        for(int[] e : edges){
            if(!uf.union(e[0], e[1]))l.add(e);
        }
        for(int[] i : l){
            System.out.println(Arrays.toString(i));
        }
        return l.get(l.size()-1);
    }
}

class UF{
    Subset[] sub;
    public UF(int size){
        sub = new Subset[size];
        for(int i = 0; i < size; i++){
            sub[i] = new Subset();
            sub[i].parent = i; 
            sub[i].rank = 0;
        }
    }
    int find(int x){
        if(x != sub[x].parent){
            sub[x].parent = find(sub[x].parent);
        }
        return sub[x].parent;
    }
    boolean union (int x, int y){
        int xr = find(x); int yr = find(y);
        
        //if they are already part of same parent return false, they don't need to 
        //combine
        if(xr == yr)
        return false;
        
        if(sub[xr].parent < sub[yr].parent){
            sub[xr].parent = sub[yr].parent;
        }
        else if(sub[xr].parent > sub[yr].parent){
            sub[yr].parent = sub[xr].parent;
        }else{
            sub[xr].parent = sub[yr].parent;
            sub[yr].rank++;
        }
        return true;
    }
}

class Subset{
    int parent; int rank;
}

//https://leetcode.com/problems/redundant-connection/
//https://leetcode.com/problems/redundant-connection/solution/


class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length + 1;
        UF uf = new UF(n);
              
        for(int[] e : edges){
            if(!uf.union(e[0], e[1]))return e;
        }

        return null;
    }
}

class UF{
    int[] sub;
    public UF(int size){
        sub = new int[size];
        for(int i = 0; i < size; i++){
            sub[i] = i;

        }
    }
    int find(int x){
        if(x != sub[x]){
            sub[x] = find(sub[x]);
        }
        return sub[x];
    }
    boolean union (int x, int y){
        int xr = find(x); int yr = find(y);
        
        //if they are already part of same parent return false, they don't need to 
        //combine
        if(xr == yr)
        return false;
        
        sub[xr] = find(yr);
        return true;
    }
}
