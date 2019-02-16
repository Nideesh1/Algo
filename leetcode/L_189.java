class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        //System.out.println(Arrays.toString(nums));
        while( k != 0){
        rotateRight1(nums); k--;
        }
        //System.out.println(Arrays.toString(nums));
        
    }
    public void rotateRight1(int[] arr){ int n = arr.length;
        int t = arr[n-1];
        for(int i = n-1; i > 0; i--){
            arr[i] = arr[i-1];
        }
        arr[0] = t;
    }
}

//https://leetcode.com/problems/rotate-array/description/
