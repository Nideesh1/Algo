class Boom {
    public int[] t; public double d;
    public Boom(int[] t, double d){
        this.t = t; this.d = d;
    }

    public String toString(){
        return Arrays.toString(t) + " " + d;
    }
    
}

class Solution {
    
    public double distance(int[] one, int[] two){
        return Math.sqrt(Math.pow(two[0] - one[0], 2) + Math.pow(two[1] - one[1], 2));
    }
    
    public int factorial(int n){
        return (n== 1 || n ==0) ? 1 : n * factorial(n-1);
    }
    
    public int permutation(int n, int k){
        return factorial(n) / factorial(n-k);
    }
    
    public int numberOfBoomerangs(int[][] points) {
        Map<int[], List<Boom>> map = new HashMap<>();
        int res = 0;
        outer:
        for(int i = 0; i < points.length; i++){
            
            inner:
            for(int j = 0; j < points.length; j++){
                
                if(i == j) {continue inner;}
                List<Boom> l = map.getOrDefault(points[i], new ArrayList<>());
                l.add( new Boom(points[j],distance(points[i], points[j])));
                map.put(points[i], l);
                
            }
        }
        
        for(int[] w : map.keySet()){
            System.out.println(Arrays.toString(w) + " | " + map.get(w).toString());
        }
        
        Map<int[], Map<Double,Integer>> perm = new HashMap<>();
        
        for(int[] w : map.keySet()){
            Map<Double,Integer> temp = new HashMap<>();
            List<Boom> boomlist = map.get(w);
            for(Boom b : boomlist){
                temp.put(b.d, temp.getOrDefault(b.d,0) + 1);
            }
            perm.put(w,temp);
            
        }        

        for(int[] w : perm.keySet()){
            //System.out.println(Arrays.toString(w) + " | " + perm.get(w));
            for(double d : perm.get(w).keySet()){
                if(perm.get(w).get(d) > 1.0){
                    int n = perm.get(w).get(d);
                    res += permutation(n, 2);
                }
            }
        }             
        

        
        return res;
    }
}

//https://leetcode.com/problems/number-of-boomerangs/
