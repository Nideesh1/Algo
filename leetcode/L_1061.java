class Solution {
    
    public Map<Character,Integer> map = new HashMap<>();
    
    public String smallestEquivalentString(String A, String B, String S) {
        List<Character> l = new ArrayList<>();
        for(char c : A.toCharArray()){
            if(!l.contains(c)){l.add(c);}
        }
        for(char c : B.toCharArray()){
            if(!l.contains(c)){l.add(c);}
        }
        Collections.sort(l);
        //System.out.println(l);
        UF uf = new UF(l.size(), l, map);
        //System.out.println(Arrays.toString(uf.sub));
        
        for(int i = 0; i < A.length(); i++){
            char a = A.charAt(i); char b = B.charAt(i);
            int ar = uf.find(map.get(a));
            int br = uf.find(map.get(b));
            
            if(ar != br){
                uf.union(ar, br);
                int r = uf.find(ar);
                map.put(a, r);
                map.put(b, r);
            }
            
        }
        //System.out.println(map);
        StringBuilder sb = new StringBuilder();
        System.out.println(Arrays.toString(uf.sub));  
        for(char c : S.toCharArray()){
            if(map.containsKey(c)){
                sb.append(uf.sub[uf.find(map.get(c))].c);
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}

class Subset{
    int parent; int rank; char c;
    Subset(int parent, char c){
        this.parent = parent;
        this.c = c;
    }
    public String toString(){
        return this.parent + " " + this.c;
    }
}

class UF {
    Subset[] sub;
    UF(int size, List<Character> l, Map<Character,Integer> map){
        sub = new Subset[size];
        for(int i = 0; i < sub.length; i++){
            sub[i] = new Subset(i , l.get(i));
            map.put(l.get(i), i);
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
        if(sub[xr].c < sub[yr].c){
            sub[yr].parent = xr;
        }
        else if(sub[xr].c > sub[yr].c){
            sub[xr].parent = yr;
        }
        
    }
}

//https://leetcode.com/problems/lexicographically-smallest-equivalent-string/
