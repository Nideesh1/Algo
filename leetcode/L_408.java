class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        Queue<Character> w = new LinkedList<>();
        Queue<Character> a = new LinkedList<>();
        System.out.println(word.length());
        for(char c : abbr.toCharArray()){
            a.add(c);
        }
        for(char c : word.toCharArray()){
            w.add(c);
        }  
        

       
        int num = 0;
        outer :
        while(!a.isEmpty()){
            
            if(Character.isLetter(a.peek())){
                if(a.peek() != w.peek()) return false;
                
                a.poll();
                w.poll();
            }else if(Character.isDigit(a.peek())){
                
                if(a.peek() == '0'){
                  return false;      
                }
                
                String str = "";
                inner:
                while(Character.isDigit(a.peek())){
                    str += a.poll();
                    if(a.size() == 0) break inner;
                }
                num = Integer.valueOf(str);
                while(num != 0 && w.size() > 0){
                    w.poll(); num--;
                }
            }

        
        }

        System.out.println(num);
        return a.equals(w) && num == 0;
    }
}

//https://leetcode.com/problems/valid-word-abbreviation/
