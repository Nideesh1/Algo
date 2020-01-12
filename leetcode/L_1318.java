class Solution {
    public int minFlips(int a, int b, int c) {
        int res = 0;
        if( (a | b) == c) return 0;
        int tot = 32;
        while(tot != 0){
            int ae = a & 1;
            int be = b & 1;
            int ce = c & 1;

            

            
            a = a >> 1;
            b = b >> 1;
            c = c >> 1;
            tot--;
            
            if( (ae | be) == ce ) continue; 
            else {
            
                
                if(ce == 1){
                    
                    if(ae == 0 && be == 0){
                        res++;
                    }
                    
                }
                else{
                    
                    if( ae == 1 && be == 1){
                        res += 2;
                    }
                    else if(ae == 1 || be == 1){
                        res++;
                    }
                    
                }
            
            }

            
        }
        return res;
    }
}
