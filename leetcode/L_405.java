class Solution {
    Map<Integer,String> map = new HashMap<>();
    public String toHex(int num) {
        
        // int one = (int) num & (1 << 4) - 1; one >>= 4;
        // int two = (int) num & (1 << 4) - 1; one >>= 4;
        // int three = (int) num & (1 << 4) - 1; one >>= 4;
        // int four = (int) num & (1 << 4) - 1; one >>= 4;
        // int five = (int) num & (1 << 4) - 1; one >>= 4;
        // int six = (int) num & (1 << 4) - 1; one >>= 4;
        // int seven = (int) num & (1 << 4) - 1; one >>= 4;
        // int eight = (int) num & (1 << 4) - 1; one >>= 4;
        each();
        if(num == 0) return map.get(0);
        List<Integer> l = new ArrayList<>();
        
        for(int i = 0; i < 8; i++){
            l.add(0, (int) num & (1 << 4) - 1);
            num >>= 4;
        }
        System.out.println(l);
        String res = "";
        for(int i : l){
            res += map.get(i);
        }

        int ind  = -1;
        int p = 0;
        while(res.charAt(p) == '0'){
            p++;
        }
        System.out.println(p);
        if(p != -1) {return res.substring(p);}
        return res;
    }
    
    public String each(){
        map.put(0, "0");
        map.put(1, "1");
        map.put(2, "2");
        map.put(3, "3");
        map.put(4, "4");
        map.put(5, "5");
        map.put(6, "6");
        map.put(7, "7");
        map.put(8, "8");
        map.put(9, "9");
        map.put(10, "a");
        map.put(11, "b");
        map.put(12, "c");
        map.put(13, "d");
        map.put(14, "e");
        map.put(15, "f");

        
        
        
        return "";
    }
}

//https://leetcode.com/problems/convert-a-number-to-hexadecimal/
