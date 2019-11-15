class Solution {
    public List<String> removeComments(String[] source) {
        List<String> res = new ArrayList<>();
        boolean block = false;
        StringBuilder nl = new StringBuilder();
        
        for(String line : source){
            int i = 0;
            char[] ar = line.toCharArray();
            if(!block) nl = new StringBuilder();
            while(i < line.length()){
                if(!block && i+1 < line.length() && ar[i] == '/' && ar[i+1] == '*'){
                    block = true;
                    i++;
                }
                else if(block && i+1 < line.length() && ar[i] == '*' && ar[i+1] == '/'){
                    block = false;
                    i++;
                }
                else if (!block && i + 1 < line.length() && ar[i] == '/' && ar[i+1] == '/'){
                    break;
                }
                else if(!block){
                    nl.append(ar[i]);
                }
                i++;
                                
            }
                
                if(!block && nl.length() > 0){
                    res.add(new String(nl));
                }            
        }
        return res;
    }
}

//https://leetcode.com/problems/remove-comments/solution/
