class Solution {
    public String reverseStr(String s, int k) {
        int n = s.length(); int i = 0;
        
        StringBuilder sb = new StringBuilder();
        
        for( i = 0; i + 2*k < n; i += 2*k){
            int j = i + 2*k;
            int m = (i+j)/2;
            String s1 = s.substring(i,m);
            String s2 = s.substring(m,j);
            sb.append(  new StringBuilder(s1).reverse().toString() );
            sb.append(s2);

        }

        int left = n - i;
        //System.out.println(left + " " + s.substring(i));
        if( left < k){
            sb.append(  new StringBuilder(s.substring(i)).reverse().toString() );
        }else{
            String s3 = s.substring(i,i+k);
            String s4 = s.substring(i+k);
            sb.append(  new StringBuilder(s3).reverse().toString() );
            sb.append(s4);            
        }
        //System.out.println(sb.toString());
        return sb.toString();
    }
}

//https://leetcode.com/problems/reverse-string-ii/description/
