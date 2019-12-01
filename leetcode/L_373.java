class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums1.length == 0 || nums2.length == 0 || k == 0)return res;
        
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) -> (a[0] + a[1]) - (b[0] + b[1]));
        
        for(int i = 0; i < nums1.length && i < k; i++){
            pq.add(new int[]{nums1[i], nums2[0], 0});
        }
        
        while(k-- > 0 && !pq.isEmpty()){
            int[] cur = pq.poll();
            List<Integer> curL = new ArrayList<>();
            curL.add(cur[0]); curL.add(cur[1]);
            res.add(curL);
            
            if(cur[2] == nums2.length - 1) continue;
            pq.add(new int[]{cur[0], nums2[cur[2] + 1], cur[2] + 1});
        }
        
        return res;
    }
}

//https://leetcode.com/problems/find-k-pairs-with-smallest-sums/discuss/84551/simple-Java-O(KlogK)-solution-with-explanation
