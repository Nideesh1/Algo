class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] leftMultiple = new int[nums.length];
        int[] rightMultiple = new int[nums.length];
        int n = nums.length;
        leftMultiple[0] = nums[0];
        int[] res = new int[n];
        
        for(int i = 1; i < nums.length; i++){
            leftMultiple[i] = leftMultiple[i-1]*nums[i];
        }
        rightMultiple[n-1] = nums[n-1];
        for(int i = n-2; i >= 0; i--){
            rightMultiple[i] = rightMultiple[i+1]*nums[i];
        }

        for(int i = 0; i < res.length; i++){
            int left = i-1;
            int right = i +1;
            int multiple = 1;
            if(left >= 0){multiple = multiple*leftMultiple[left];}
            if(right < n){multiple = multiple*rightMultiple[right];}  
            res[i] = multiple;
        }
        System.out.println(Arrays.toString(res));
        return res;
    }
}

//https://leetcode.com/problems/product-of-array-except-self/description/
