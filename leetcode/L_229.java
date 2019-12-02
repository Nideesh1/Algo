//after the 2 slots are filled any number which might take one of the spots will be cancelling vote of both the candidates. the candidate which drops past zero first will be eliminated.

//we fill array count to zero to recount and return right result
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> l = new ArrayList<>();
        int[] count = new int[2];
        int[] elem = new int[2];
        elem[0] = 0;
        elem[1] = 1;
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == elem[0]){
                count[0]++;
            }else if(nums[i] == elem[1]){
                count[1]++;
            }else if(count[0] == 0){
                elem[0] = nums[i];
                count[0]++;
            }else if(count[1] == 0){
                elem[1] = nums[i];
                count[1]++;
            }else{
                count[0]--;
                count[1]--;
            }

        
        }

        Arrays.fill(count,0);
        
        for(int i : nums){
            if(i == elem[0]) count[0]++;
            else if(i == elem[1]) count[1]++;
        }
       
        
        for(int i = 0; i < 2; i++){
            if(!l.contains(elem[i]) && count[i] > nums.length/3){
                l.add(elem[i]);
            }
        }
        
        return l;
        
    }
}

//https://leetcode.com/problems/majority-element-ii/discuss/63584/Concise-JAVA-solution-based-on-Moore's-Voting-Algorithm
