//Put all the stone into connected components. Now remove as many stones as you can from each
//while leaving at least one stone. That's how many moves you can make. 
class Solution {
    public int removeStones(int[][] stones) {
        int N = stones.length;
        // this max is to represent the coordinate [10000,10000]
        UF uf = new UF(10000+10000);
        for(int[] stone : stones){
            uf.union(stone[0], stone[1] + 10000);
        }
        Set<Integer> seen = new HashSet<>();
        for(int[] stone : stones){
            seen.add(uf.find(stone[0]));
        }
        return N - seen.size();
    }
}
class UF{
    Subset[] sub;
    public UF(int size){
        sub = new Subset[size];
        for(int i = 0; i < size; i++){
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
        }else if(sub[xr].rank > sub[yr].rank){
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

//https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/
//https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/solution/
