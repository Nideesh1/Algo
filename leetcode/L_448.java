class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> r = new ArrayList<>();
        int[] a = new int[nums.length+1];
        for(int i = 0; i < nums.length; i++){
            int n = nums[i];
            a[n] = -1;
        }
       // System.out.println(Arrays.toString(a));
        for(int i = 1; i < a.length; i++){
            if(a[i] == 0){r.add(i);}
        }
        return r;
    }
}

//https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
