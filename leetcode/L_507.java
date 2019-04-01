class Solution {
    public boolean checkPerfectNumber(int num) {
        if(num == 0) return false;
        Set<Integer> set = new HashSet<>();
        for(int i = 1; i <= Math.sqrt(num); i++){
            
            if(num % i == 0){
                if(num/i == i) {set.add(i);}
                else{
                    set.add(i);
                    set.add(num/i);
                }
            }
            
        }
        
        set.remove(num);
        int tot = 0;
        for(int i : set){
            tot += i;
        }
            return num == tot;
    }
}

//https://leetcode.com/problems/perfect-number/
