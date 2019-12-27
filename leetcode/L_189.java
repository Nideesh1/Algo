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

class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        rev(nums, 0, nums.length - 1);
        rev(nums, 0, k-1);
        rev(nums, k, nums.length - 1);
    }
    
    public void rev(int[] ar, int i , int j){
        while(i < j){
            int t = ar[i];
            ar[i] = ar[j];
            ar[j] = t;
            i++; j--;
        }
    }
}

//https://leetcode.com/problems/rotate-array/description/
