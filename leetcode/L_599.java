class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String,List<Integer>> map = new HashMap<>();
            for(int i = 0; i < list1.length;i++){
            List<Integer> l = new ArrayList<>();
            l.add(i);
                map.put(list1[i], l);
            }
        
            for(int i = 0; i < list2.length;i++){
                if(map.containsKey(list2[i])){
                    List<Integer> t = map.get(list2[i]);
                    t.add(i);
                }
            }
        
            int min = Integer.MAX_VALUE;
            List<String> list = new ArrayList<>();
            for(String s : map.keySet()){
                if(map.get(s).size() == 1){continue;}
                int sum = 0;
                for(Integer i : map.get(s)){
                    sum += i;
                }
                min = Math.min(sum, min);
            }
      
            for(String s : map.keySet()){
                if(map.get(s).size() == 1){continue;}
                int sum = 0;
                for(Integer i : map.get(s)){
                    sum += i;
                }
                if(sum == min){
                    list.add(s);
                }
            }        
            
        String[] res = new String[list.size()];
        for(int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }
        System.out.println(list);
        return res;
    }
}

//https://leetcode.com/problems/minimum-index-sum-of-two-lists/
