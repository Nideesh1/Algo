class Solution {
    public int majorityElement(int[] nums) {
        return maj(nums, 0, nums.length-1);   
    }
    public int maj(int[] nums, int i, int j){
        if(i == j){
            return nums[i];
        }
        
        int mid = (i+j)/2;
        
        int left = maj(nums, i, mid);
        int right = maj(nums, mid+1, j);
        
        if(left == right){
            return left;
        }
        
        int leftInt = count(nums, left, i, j);
        int rightInt = count(nums, right, i, j);
        
        return leftInt > rightInt ? left: right;
    }
    public int count(int[] nums, int num, int i, int j){
        int count = 0;
        for(int k = i; k <= j; k++){
            if(nums[k] == num){
                count++;
            }
        }
        return count;
    }
}


public int majorityElement3(int[] nums) {
    int count=0, ret = 0;
    for (int num: nums) {
        if (count==0)
            ret = num;
        if (num!=ret)
            count--;
        else
            count++;
    }
    return ret;
}



//https://leetcode.com/problems/majority-element/description/
//https://leetcode.com/problems/majority-element/discuss/51611/Java-solutions-(sorting-hashmap-moore-voting-bit-manipulation).
