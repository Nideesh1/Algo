class Solution {
    public String minimizeResult(String expression) {
        String[] sp = expression.split("\\+");
        String left = sp[0];
        String right = sp[1];
        
        int min = Integer.MAX_VALUE;
        String result = "(" + expression + ")";
		
        for(int i=0; i<left.length(); i++) { //Index at which we add `(`  for left
            int leftMul = left.substring(0, i).equals("") ? 1 : Integer.parseInt(left.substring(0,i));
            int leftNum = Integer.parseInt(left.substring(i));
            
            for(int j=1; j<=right.length(); j++) { //Index at which we add `)` for right
                int rightMul = right.substring(j).equals("") ? 1 : Integer.parseInt(right.substring(j));
                int rightNum = Integer.parseInt(right.substring(0,j));
                
                int sum = leftMul * (leftNum + rightNum) * rightMul;
                if(sum < min) {
                    min = sum;
                    result = left.substring(0, i) + "(" + left.substring(i) + "+" + right.substring(0, j) + ")" + right.substring(j);
                }
            }
        }
        return result;
    }
}

//https://leetcode.com/problems/minimize-result-by-adding-parentheses-to-expression/discuss/1931208/Java-or-Easy-to-understand
