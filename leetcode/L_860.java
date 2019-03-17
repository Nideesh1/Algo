class Solution {
    public boolean lemonadeChange(int[] bills) {
        //use a 2 space array to hold bills
        int[] change = new int[2];
        //change[0] is num of 5, change[1] is num of 10
        
        for(int i = 0; i < bills.length; i++){
            
            if(bills[i] == 5) change[0]++;
            else if(bills[i] == 10){
                if(change[0] == 0) return false;
                change[0]--;
                change[1]++;
            }
            //if we see a twenty
            else{
                //no five
                if(change[0] == 0) return false;
                
                //no tens
                if(change[1] == 0){
                    
                    // at least 3 fives
                    if(change[0] < 3) return false;
                    change[0] -= 3;
                }
                //we have at least one 5 and one 10
                else{
                    change[1]--;
                    change[0]--;
                }
            }
            
        }
        return true;
    }
}

//https://leetcode.com/problems/lemonade-change/
