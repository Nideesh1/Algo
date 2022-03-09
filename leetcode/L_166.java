public class Solution {

public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
    
        String sign = (numerator > 0) == (denominator > 0) ? "" : "-"; //Sign
    
        long num = Math.abs((long) numerator), den = Math.abs((long) denominator); 
    
        return sign + (num / den) + fraction(num % den, den);
    } 
    
    private static String fraction(long numerator, long denominator) {
        if (numerator == 0) return "";
        
        StringBuilder res = new StringBuilder();
        res.append(".");
        
        HashMap<Long, Integer> map = new HashMap<Long, Integer>(); //Numerator->Index
        map.put(numerator, res.length());
        
        while (numerator != 0) {
            numerator *= 10;
            res.append(numerator / denominator);
            numerator %= denominator;
            
            //If the same numerator is observed before
            // Add the brackets to index where that numerator was observed
            if (map.containsKey(numerator)) {
                int index = map.get(numerator);
                res.insert(index, "(");
                res.append(")");
                break;
            }
            
            map.put(numerator, res.length());
        }
        return res.toString();
    }
}

//https://leetcode.com/problems/fraction-to-recurring-decimal/discuss/51106/My-clean-Java-solution/622877
