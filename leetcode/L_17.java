class Solution {
    Map<Character,String> map = new HashMap<>();
    public List<String> letterCombinations(String digits) {


        map.put('2', "abc");
        map.put('3', "def"); 
        map.put('4', "ghi");        
        map.put('5', "jkl");
        map.put('6', "mno"); 
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz"); 
        
        
        List<String> res = new ArrayList<>();
        if(digits.length() == 0)return res;
        res.add("");
        for(char c : digits.toCharArray())
        {
            res = add(res, c);
            System.out.println(res);
        }        
        return res;
    }
    
    public List<String> add(List<String> res, char c){
        List<String> ret = new ArrayList<>();
        for(String r : res){
            for(char ch : map.get(c).toCharArray()){
                String temp = r + ch;
                ret.add(temp);
            }
        }
        return ret;
    }
}
//https://leetcode.com/problems/letter-combinations-of-a-phone-number/
