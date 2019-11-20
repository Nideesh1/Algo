class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] ar = new int[m+n];
        
        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                
                int p1 = i + j; int p2 = i + j + 1;
                int sum = mul + ar[p2];
                
                ar[p1] += sum/10;
                ar[p2] =(sum % 10);
            }
        }
        System.out.println(Arrays.toString(ar));
        StringBuilder sb = new StringBuilder();
        for(int a : ar){
            if(!(sb.length() == 0 && a == 0)){
               sb.append(a);
            }
        }
         return sb.length() == 0 ?  "0" : sb.toString();
    }
}

//https://leetcode.com/problems/multiply-strings/
