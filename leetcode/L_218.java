class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        int n = buildings.length;
        Building[] ar = new Building[n*2];
        
        List<List<Integer>> res = new ArrayList<>();
        int i = 0;
        for(int[] b : buildings){
            Building b1 = new Building(b[0], b[2], true);
            ar[i] = b1;
            
            Building b2 = new Building(b[1], b[2], false);
            ar[i+1] = b2;
            
            i += 2;
        }
        
        Comparator<Building> co = new Comparator<Building>(){
            
    public int compare(Building b1, Building b2){

        if(b1.x == b2.x){
            if(b1.start && b2.start && (b1.start == b2.start)){
                return b2.y - b1.y;
            }else if (!b1.start && !b2.start && (b1.start == b2.start)){
                return b1.y - b2.y;
            } else if (b1.start != b2.start){
                return b1.start ? -1 : 1;
            }
        }
            
        return b1.x - b2.x; 
    }
            
        };
        
        Arrays.sort(ar, co);
        
        //key is height, value is freq of hiehgt
        TreeMap<Integer,Integer> q = new TreeMap<>();
        q.put(0,1);
        int prevMax = 0;
        for(Building b : ar){
            if(b.start){
                q.compute(b.y, (k,v) -> {
                    if(v != null){
                        return v + 1;
                    }
                    return 1;
                });
            }else{
                q.compute(b.y, (k,v) ->{
                    if(v == 1){
                        return null;
                    }
                    return v-1;
                });
            }
            
            int curMax = q.lastKey();
            if(curMax != prevMax){
                List<Integer> l = new ArrayList<>();
                l.add(b.x); l.add(curMax);
                res.add(l);
                
                prevMax = curMax;
                
            }
            
        }
        
        return res;
    }
}

class Building {
    int x; int y; boolean start;
    Building(int x, int y, boolean start){
        this.x = x;
        this.y = y;
        this.start = start;
    }
}



//https://leetcode.com/problems/the-skyline-problem/
//https://github.com/mission-peace/interview/blob/master/src/com/interview/geometry/SkylineDrawing.java
//https://www.youtube.com/watch?v=GSBLe8cKu0s
