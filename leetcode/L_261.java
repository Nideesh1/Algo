//UF
class Solution {
    public boolean validTree(int n, int[][] edges) {
        UF uf = new UF(n);
        for(int[] e : edges){
            int x = uf.find(e[0]);
            int y = uf.find(e[1]);
            if(x == y) return false;
            uf.union(e[0], e[1]);
        }
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            set.add(uf.find(i));
        }
        return set.size() == 1;
    }
}

class UF {
    Subset[] sub;
    UF(int N){
        sub = new Subset[N];
        for(int i = 0; i < N; i++){
            sub[i] = new Subset();
            sub[i].parent = i; sub[i].rank = 0;
        }
    }
    public int find(int x){
        if(x != sub[x].parent)
            sub[x].parent = find(sub[x].parent);
        return sub[x].parent;
    }
    
    public void union(int x, int y){
        int xroot = find(x);
        int yroot = find(y);
        
        if(sub[xroot].rank < sub[yroot].rank){
            sub[xroot].parent = sub[yroot].parent;
        }else if(sub[xroot].rank > sub[yroot].rank){
            sub[yroot].parent = sub[xroot].parent;
        }else{
            sub[xroot].parent = sub[yroot].parent;
            sub[yroot].rank++;
        }
    }
    
}

class Subset{
    int parent; int rank;
}

//BFS && DFS
class Solution {
    Map<Integer,Set<Integer>> adj = new HashMap<>();
    public boolean validTree(int n, int[][] edges) {

        for(int[] e : edges){
            Set<Integer> l = adj.getOrDefault(e[0], new HashSet<>()); l.add(e[1]); adj.put(e[0], l);
            Set<Integer> l2 = adj.getOrDefault(e[1], new HashSet<>()); l2.add(e[0]); adj.put(e[1], l2);
        }
        Set<Integer> set = new HashSet<>();
        System.out.println(adj);
        for(int i = 0; i < n; i++){
            if(!set.contains(i)){
                if(cycDFS(i, -1, set)) return false;
            }
            break;
        }
        return set.size() == n;
    }
    
    public boolean cycDFS(int u, int par, Set<Integer> set){
        if(set.contains(u)) return false;
        set.add(u);
        if(!adj.containsKey(u)) return false;
        for(int nei : adj.get(u)){
            if(!set.contains(nei)){
                if(cycDFS(nei, u, set)) return true;
            }else{
                if(nei != par) return true;
            }
        }
        return false;
    }
    
    public boolean cycBFS(int u, Set<Integer> set, int n){
        Queue<Integer> q = new LinkedList<>();
        q.add(u); set.add(u);
        int[] par = new int[n];
        Arrays.fill(par, -1);
        while(!q.isEmpty()){
            int cur = q.poll();
            if(!adj.containsKey(cur)) continue;
            for(int nei : adj.get(cur)){
                if(!set.contains(nei)){
                    set.add(nei); q.add(nei); par[nei] = cur;
                }else if (par[cur] != nei){
                    return true;
                }
            }
        }
        return false;
    }
}

//https://leetcode.com/problems/graph-valid-tree/
