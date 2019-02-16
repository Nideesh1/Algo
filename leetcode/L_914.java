class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        if(deck.length < 2){return false;}
        
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < deck.length; i++){
            map.put(deck[i], map.getOrDefault(deck[i], 0) + 1);
        }
        System.out.println(map);
        int gcd = Collections.min(map.values());
        for(int i : map.values()){
            gcd = gcd(gcd, i);
        }
        for(int i : map.values()){
            if(i % gcd != 0){return false;}
        }
        System.out.println(gcd);
        return gcd == 1 ? false : true;
    }
    
        public  int gcd(int a, int b) 
        { 
          if (b == 0) 
            return a; 
          return gcd(b, a % b);  
        } 
}

//https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/description/
