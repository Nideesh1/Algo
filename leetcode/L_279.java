class Solution {
    public int numSquares(int n) {
        List<Integer> square = new ArrayList<>();
        for(int i = 1; i*i <= n; i++){
            square.add(i*i);
        }
        
        Set<Integer> q = new HashSet<>();
        q.add(n);
        
        int level = 0;
        while(q.size() > 0){
            
            level++;
            Set<Integer> nextq = new HashSet<>();
            
            for(Integer rem : q){
                
                for(Integer sq : square){
                    
                    
                    if(rem.equals(sq)){ return level;}
                    else if(rem < sq){
                        break;
                    }else{
                        nextq.add(rem - sq);
                    }
                }
                
            }
            
            
            q = nextq;
        }
        
        return level;
    }
}

//https://leetcode.com/problems/perfect-squares/solution/
