class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        //List<Integer> list = new ArrayList<>();
        int p = 0;
        int n = nums.length;
        
        while(p < n){
            if(nums[p] == 1){
                p++; int count = 0;
                while(p < n && nums[p] == 0){
                    p++; count++;
                }
                if(p < n){
                    if(count < k) return false;
                }
                
            }else{
                p++;                
            }

        }
        //System.out.println(list);
        //for(int l : list) if (l < k) return false;
        return true;
    }
}