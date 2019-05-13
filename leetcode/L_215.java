class Solution {
    public int findKthLargest(int[] nums, int k) {
        int res = 0;
        Comparator co = new Comparator<Integer>(){
            public int compare(Integer a , Integer b){
                return b - a;
            }
        };
        PriorityQueue pq  = new PriorityQueue<>(co);
        for(int i : nums) pq.add(i);
        System.out.println(pq);
        while(k != 0){
            res = (int) pq.poll(); k--;
        }
        return res;
    }
}
class Solution {
    public int findKthLargest(int[] nums, int k) {
      Arrays.sort(nums);
        int res = 0;
      for(int i = nums.length-1; i >= 0 && k > 0; i--, k-- ){
          res = nums[i];
      }
        return res;
    }
}

//https://leetcode.com/problems/kth-largest-element-in-an-array/
