class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer,Integer> existingSequences = new HashMap<>();
        Map<Integer,Integer> createNewSequence = new HashMap<>();
        
        for(int i : nums){
            createNewSequence.put(i, createNewSequence.getOrDefault(i,0) +1);
        }        
        for(int i : nums){
                if(createNewSequence.get(i) == 0) continue;
                if(existingSequences.getOrDefault(i,0) > 0){
                    existingSequences.put(i, existingSequences.get(i)-1);
                    existingSequences.put(i+1, existingSequences.getOrDefault(i+1, 0)+1);
                    createNewSequence.put(i, createNewSequence.get(i)-1);                    
                }
                else if(createNewSequence.getOrDefault(i, 0) > 0 && createNewSequence.getOrDefault(i+1, 0) > 0 && createNewSequence.getOrDefault(i+2, 0) > 0){
                        createNewSequence.put(i, createNewSequence.get(i)-1);                    
                        createNewSequence.put(i+1, createNewSequence.get(i+1)-1);
                        createNewSequence.put(i+2, createNewSequence.get(i+2)-1);
                        existingSequences.put(i+3, existingSequences.getOrDefault(i+3,0)+1); 
                }
                else{
                        return false;
                }
            
            }
              
        return true;
    }
}

//https://leetcode.com/problems/split-array-into-consecutive-subsequences/
