class Solution {
    public boolean canThreePartsEqualSum(int[] A) {
        int totalSum = 0;
        for(int a : A){
            totalSum += a;
        }
        
        if(totalSum % 3 != 0) return false;
        int segSum = totalSum/3;
        int segNum = 1;
        
        
        int temp = 0;
        for(int i = 0; i < A.length; i++){
            temp += A[i];
            
            if(temp == segSum && segNum <= 2){
                segNum++;
                temp = 0;
            }
        }
        
        if(temp == segSum && segNum == 3) 
            return true;
        
    }
}

//https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum/
