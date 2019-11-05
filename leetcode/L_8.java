class Solution {
    public int myAtoi(String str) {
        str = str.trim();
        if(str.isEmpty()) return 0;
        int sign = 1;
        int build = 0;
        int i = 0;
    while (str.charAt(i) == ' ')
        i++;
        if(str.charAt(i) == '-' || str.charAt(i) == '+'){
            sign = str.charAt(i++) == '-' ? -1 : 1;
        }
        
        while( i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9'){
            
            
            if(build > Integer.MAX_VALUE/10 || (build == Integer.MAX_VALUE/10 && (str.charAt(i) - '0' > Integer.MAX_VALUE % 10)))
               {
                   return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
               }
            build = build * 10 + (str.charAt(i++) - '0') ;
        }
               
        return build * sign;
    }
}

//https://leetcode.com/problems/string-to-integer-atoi/
//https://leetcode.com/problems/string-to-integer-atoi/discuss/4654/My-simple-solution
