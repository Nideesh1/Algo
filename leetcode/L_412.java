class Solution {
    public List<String> fizzBuzz(int n) {
        Map<Integer,String> map = new HashMap<>();
        map.put(3, "Fizz");
        map.put(5, "Buzz");
        
        List<String> res = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            
            String temp = "";
            
            for(Integer k : map.keySet()){
                if(i % k == 0){
                    temp += map.get(k);
                }
            }
            if(temp.equals(""))
            temp += i;
            
            res.add(temp);
            
        }
        return res;
    }
}

//https://leetcode.com/problems/fizz-buzz/
