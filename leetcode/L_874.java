class Solution {
    public Set<String> set = new HashSet<>();
    int face = 0;
    Map<String,Integer> map = new HashMap<>();
    public int robotSim(int[] commands, int[][] obstacles) {
        obs(obstacles);
        int res = 0;
        map.put("left" ,0);
        map.put("right", 0);

        System.out.println(set);
        System.out.println(set.size());
        
        for(int i = 0; i < commands.length; i++){
            if(1 <= commands[i] && commands[i] <= 9){
                move(map, commands[i]);
                res = Math.max(res, max());
            }
            if(commands[i] == -1){
                face = turnRight(face);
            }
            if(commands[i] == -2){
                face = turnLeft(face);
            }
 
        }

        
        return res;
    }
    
    public int turnRight(int face){
        return (face + 1) % 4;
    }
    public int turnLeft(int face){
        return (face + 3) % 4;
    }
    
    public int max(){
        return map.get("left") * map.get("left") + map.get("right") * map.get("right");        
    }
    
    public void move(Map<String,Integer> map, int x){
        int xco = map.get("left");
        int yco = map.get("right");
        
        if(face == 0 ){
            int[] t = {xco,yco};
            while(x > 0){

                t[1]++;
                String tstr = Arrays.toString(t);                
                if(set.contains(tstr)){ 
                    break;
                }
                x--; 
                map.put("left", t[0]);
                map.put("right",t[1]);
            }
        }

        if(face == 1 ){
            int[] t = {xco,yco};
            while(x > 0){

                t[0]++;
                String tstr = Arrays.toString(t);
                
                if(set.contains(tstr)){ 
                    break;
                }
                x--; 
                map.put("left", t[0]);
                map.put("right",t[1]);
            }          
        }
        
        if(face == 2 ){
            int[] t = {xco,yco};
            while(x > 0){

                t[1]--;
                String tstr = Arrays.toString(t);
                if(set.contains(tstr)){         
                    break;
                }
                x--; 
                map.put("left", t[0]);
                map.put("right",t[1]);
            }            
        }
        
        if(face == 3 ){
            int[] t = {xco,yco};
            while(x > 0){

                t[0]--;
                String tstr = Arrays.toString(t);
                if(set.contains(tstr)){ 
                    break;
                }
                x--; 
                map.put("left", t[0]);
                map.put("right",t[1]);
            }    
        }        
    
    
    
    }
    
    public void obs(int[][] obs){
        for(int[] ob : obs){
            set.add(Arrays.toString(ob));
        }
        
    }
}


//https://leetcode.com/problems/walking-robot-simulation/
