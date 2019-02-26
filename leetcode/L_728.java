class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) { List<Integer> res = new ArrayList<>();
        for(int i = left; i <= right; i++){
            if(self(i)){res.add(i);}
        }
        //System.out.println(self(22));                                                           
                                                                   
        return res;
    }
    
    public boolean self(int i){
        int k = i;
        while( k != 0){
            int t = k % 10;
            if(t == 0){return false;}
            if(i % t != 0){return false;}
            k = k /10;
        }
        return true;
    }
}

//https://leetcode.com/problems/self-dividing-numbers/description/
