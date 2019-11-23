class Solution {
    public int maxPoints(int[][] points) {
        if(points == null) return 0;

        
        int res = 0;
        for(int i = 0; i < points.length; i++){
            int dup = 0;
            int max = 0;
            Map<String,Integer> map = new HashMap<>();
            
            for(int j = i + 1; j < points.length; j++){
                
                int delX = points[j][0] - points[i][0];
                int delY = points[j][1] - points[i][1];
                
                if(delX == 0 && delY == 0){
                    dup++;
                    continue;
                }
                
                int gcd = gcd(delX, delY);
                int dx = delX / gcd;
                int dy = delY / gcd;
                
                String key = dx+","+dy;
                map.put(key, map.getOrDefault(key,0)+1);
                
                max = Math.max(max, map.get(key));
            }
            
            res = Math.max(res, max + dup + 1);
        }
        
        return res;
    }
    
    public int gcd(int a, int b){
        if(b == 0)return a;
        return gcd(b, a%b);
    }
}

//https://leetcode.com/problems/max-points-on-a-line/solution/
