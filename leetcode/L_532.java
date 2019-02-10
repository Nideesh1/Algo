class Solution {
    
    class Pair{
        int a; int b; Pair(int a, int b){
            this.a = a; this.b = b;
        }
    }
    
    public int findPairs(int[] nums, int k) {
        Map<Integer, Pair> map = new HashMap<>();

        
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums.length;j++){
                if(i == j){continue;}
                if(Math.abs(nums[i] - nums[j]) == k){
                    
                    Pair p = nums[i] < nums[j] ? new Pair(nums[i], nums[j]) : new Pair(nums[j], nums[i]);
                    if(nums[i] < nums[j]){
                        map.put(nums[i]*10 + nums[j], p);
                    }else{
                       map.put(nums[j]*10 + nums[i], p); 
                    }
                       
                    
                }
            }
        }
        


        return map.size();
    }
}

//https://leetcode.com/problems/k-diff-pairs-in-an-array/description/
