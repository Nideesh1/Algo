class Solution {
    public String largestNumber(int[] nums) {
        if(nums.length == 0)return "";
        
        int n = nums.length;
        String[] ar = new String[n];
        
        for(int i = 0; i < nums.length; i++){
            ar[i] = String.valueOf(nums[i]);
        }
        
        Comparator<String> co = new Comparator<String>(){
            public int compare(String s1, String s2){
                String one = s1 + s2;
                String two = s2 + s1;
                return two.compareTo(one);
            }
        };
        
        StringBuilder sb = new StringBuilder();
        Arrays.sort(ar, co);
        
        if(ar[0].charAt(0) == '0'){
            return "0";
        }
        
        for(String s : ar){
            sb.append(s);
        }
        return sb.toString();
    }
}

//https://leetcode.com/problems/largest-number/solution/
