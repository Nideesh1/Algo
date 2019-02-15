class Solution {
    public int numMagicSquaresInside(int[][] grid) {
 //       System.out.println(magic(grid, 0, 0, 2, 2));
        int res = 0;
        for(int i = 0; i < grid.length - 2; i++){
            for(int j = 0; j < grid[0].length -2; j++){
                if(magic(grid,i,j,i+2,j+2)){res++;}
            }
        }
        System.out.println(res);   
        return res;
    }
    
    public boolean magic(int[][] grid, int topLeftI, int topLeftJ, int botRightI, int botRightJ){
        Set<Integer> set = new HashSet<>();
        Set<Integer> dist = new HashSet<>();
        for(int i = 1; i <= 9; i++){
            dist.add(i);
        }
        
       
            //check distinct
        for(int i = topLeftI; i <= botRightI; i++){
            for(int j = topLeftJ; j <= botRightJ; j++){
                set.add(grid[i][j]);
            }
        }
         System.out.println(dist);
        System.out.println(set); 
        
        if(!set.equals(dist)){
            System.out.println("1-9");
            return false;
        }
        
        
        int count = 0; int sum =0;
        for(int i = topLeftI; i <= botRightI; i++ ){
            count += grid[i][topLeftJ];
        }
        System.out.println(count + "count is");
        //row check
        for(int i = topLeftI; i <= botRightI; i++ ){
            for(int j = topLeftJ; j <= botRightJ; j++){
                sum += grid[i][j];
            }
            if(sum != count){
                System.out.println("row");
                return false;
            }
            sum = 0;
        }
        sum = 0;
        //col check
        for(int i = topLeftJ; i <= botRightJ; i++ ){
            for(int j = topLeftI; j <= botRightI; j++ ){
                sum += grid[j][i];
            }
            if(sum != count){                System.out.println("col"); return false;}
            sum = 0;            
        }
        sum = 0;
        
        //diag  check
        int i = topLeftI; int j = topLeftJ;
        while(i <= botRightI && j <= botRightJ ){
            sum += grid[i][j];
            i++; j++;
        }
        if(sum != count){
                            System.out.println("left diag");
            return false;}
        sum = 0;
        i = botRightI; j =  botRightJ;
        while(i >= topLeftI && j >= topLeftJ ){
            sum += grid[i][j];
            i--; j--;
        }
        if(sum != count){
                            System.out.println("right diag");
            return false;}
             
        return true;  
    }
}

//https://leetcode.com/problems/magic-squares-in-grid/description/
