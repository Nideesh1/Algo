//TreeMap
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        TreeMap<Double,List<int[]>> map = new TreeMap<>();
        for(int[] point : points){
            List<int[]> l = map.getOrDefault(dist(point), new ArrayList<>());
            l.add(point);
            map.put(dist(point), l);
        }
        int[][] res = new int[K][2];
        List<int[]> hold = new ArrayList<>();
        
        for(double d : map.keySet()){
            List<int[]> t = map.get(d);
            hold.addAll(t);
        }
        for(int i = 0; i < res.length; i++){
            res[i] = hold.get(i);
        }
        return res;
    }
    
    public double dist(int[] p1){
        return (p1[0])*(p1[0]) + (p1[1])*(p1[1]); 
    }
}

class Solution {
    public int[][] kClosest(int[][] points, int K) {
        int l = 0; int r = points.length -1; int mid =0;
        while( l <= r ){
            mid = helper(points, l, r);
            if(mid <= K){ l = mid +1; }
            if(mid >= K){ r = mid -1; }
        }
        return Arrays.copyOfRange(points, 0, K);
    }
    
    public int helper(int[][] A, int l, int r){
        int[] pivot = A[l];
        while(l < r){
            while(l < r && compare(A[r], pivot) >= 0  ) r--;
            A[l] = A[r];
            while(l < r && compare(A[l], pivot) <= 0  ) l++;
            A[r] = A[l];            
        }
        A[l] = pivot;
        return l;
    }
    
    public int compare(int[] p1, int[] p2){
        return p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1];
    }
}

//https://leetcode.com/problems/k-closest-points-to-origin/description/
