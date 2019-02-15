class Solution {
    public boolean validMountainArray(int[] A) { int n = A.length;
    
        if(n < 3){return false;}                                                  
                                                
        int i = 0; int j = n-1; 
        while( A[i] < A[i+1]  ){
            i++;
            if(i+1 == n){break;}
        }
        while( A[j] < A[j-1] ){
            j--;
            if( j-1 == 0){break;}
        }
        System.out.println(i);
        if(i == 0 || j == n-1){return false;}                                                                                                         System.out.println(j);
        return i == j;                                        
    }
}

//https://leetcode.com/problems/valid-mountain-array/description/
