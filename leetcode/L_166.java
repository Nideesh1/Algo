class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        
        StringBuilder builder = new StringBuilder();
        
        // if negative, append -
        if(numerator < 0 && denominator > 0 || numerator > 0 && denominator < 0) builder.append("-");
        
        // avoid integer overflow by converting to long
        long divisor = Math.abs((long) numerator);
        long dividend = Math.abs((long) denominator);
        
        long remainder = divisor % dividend;
        builder.append(divisor / dividend);
        
        // no decimal 
        if(remainder == 0) return builder.toString();
        
        builder.append(".");
        
        // key is the remainder, value is the position in the result string
        Map<Long, Integer> map = new HashMap<>();
        
        while(remainder != 0) {
            // check if remainder is repeating
            if(map.containsKey(remainder)) {
                //insert ( before the repeating num
                builder.insert(map.get(remainder), "(");
                //insert ) after the repeatingn num
                builder.append(")");
                break;
            }
            
            // first time seeing the remainder
            // position is the end of the string
            map.put(remainder, builder.length());
            // continue to divide the dividend so we should *= 10 as per normal long division
            remainder *= 10;
            builder.append(remainder / dividend);
            remainder %= dividend;
        }
        
        return builder.toString();
    }
}

//https://leetcode.com/problems/fraction-to-recurring-decimal/discuss/1639085/Clean-Java-With-Comment
