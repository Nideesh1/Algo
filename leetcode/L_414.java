class Solution {
    public int thirdMax(int[] nums) {
        TreeSet<Integer> ts = new TreeSet<>();
        for(int i : nums){ts.add(i);}
        int max = 0;
        int num = 3;
        int back = 0;
        while(!ts.isEmpty() && num != 0){
            max = ts.pollLast(); num--;
            back = Math.max(max, back);
        }
        return num == 0? max : back;
    }
}

//https://leetcode.com/problems/third-maximum-number/description/
