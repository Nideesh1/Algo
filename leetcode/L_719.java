class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        //System.out.println(Arrays.toString(nums));
        int l = 0, r = nums[nums.length - 1] - nums[0];
        while (l <= r) {
            int m = (l+r) / 2;
            
            int left = 0, right = 0, count = 0;
            while (right < nums.length) {
                if (nums[right] - nums[left] > m) {
                    left++;
                }
                else{
                    count += right - left;
                    right++;
                }
            }
            
            if (count >= k) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        
        return l;
    }
}


//https://leetcode.com/problems/find-k-th-smallest-pair-distance/discuss/1024240/Java-Simple-Binary-Search-wExplanation

class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int minDist = 0; // minimum distance between 2 numbers is 0 if they are the same
        int maxDist = nums[nums.length - 1] - nums[0]; // max distance in sorted array is leftmost - rightmost element
        
        // now we have our upper and lower bounds which represent all possible distances between pairs in the input array
        while(minDist <= maxDist) { // time to implement our binary search
            
            int midDist = minDist + (maxDist - minDist)/2;
            // (minDist + maxDist)/2 also works but can cause overflow errors in some languages
            
            // since we want the k-th smallest distance pair we now need to count the number of pairs with a distance
            // greater than midDist so that we can decide how to modify our search space
            
            int left = 0;
            int right = 0;
            int count = 0;
            
            while(right < nums.length) {
                if(nums[right] - nums[left] > midDist) {
                    // if this condition is met then the current number and all numbers to its right will be greater
                    // than midDist fom nums[left] because the array is sorted so we can just increment left
                    left++;
                } else {
                    count += right - left; // adds the number of pairs between right and left
                    // for example: distance of 0 = 1 pair, distance of 2 = 2 pairs
                    // distance of 3 = 1 + 2 = 3 pairs
                    // distance of 4 = 1 + 2 + 3 = 6 pairs and so on
                    right++;
                }
            }
            
            if(count >= k) {
                // we found too many pairs which means the k-th smallest distance pair must have a distance that is
                // less than our guess so we remove the lower half of our search space
                maxDist = midDist - 1;
            } else {
                // we found too few pairs which means the k-th smallest distance pair must have a distance that is
                // greater than our guess so we remove the lower half of our search space
                minDist = midDist + 1;
            }
        }
        return minDist;
    }
}
