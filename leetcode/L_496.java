class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stk = new Stack<>();
        Map<Integer,Integer> map = new HashMap<>();
        int[] res = new int[nums1.length];

        for(int i = 0; i < nums2.length; i++){
            while(!stk.isEmpty() && nums2[i] > stk.peek()){
                map.put(stk.pop(), nums2[i]);
            }
            stk.push(nums2[i]);
        }
        
        while(!stk.isEmpty()){
            map.put(stk.pop(), -1);
        }
        
        for(int i = 0; i < nums1.length; i++){
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}

//https://leetcode.com/problems/next-greater-element-i/
