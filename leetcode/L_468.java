class Solution {
    public String validIPAddress(String IP) {
        if(ip4(IP)){
            return "IPv4";
        }
        if(ip6(IP)){
            return "IPv6";
        }
        return "Neither";
    }
    
    public boolean ip4(String tok){
        if(tok.length() < 7)return false;
        if(tok.charAt(0) == '.' || tok.charAt(tok.length() - 1) == '.') return false;
        String[] toks = tok.split("\\.");
        if(toks.length != 4)return false;
        for(String t : toks){
            if(!ip4tok(t)) return false;
        }
        return true;
    }
    public boolean ip4tok(String tok){
        
        if(tok.startsWith("0") && tok.length() > 1) return false;
        try{
            int pint = Integer.parseInt(tok);
            if(pint < 0 || pint > 255) return false;
            if(pint == 0 && tok.charAt(0) != '0') return false;
        }catch(NumberFormatException nfe){
            return false;
        }
        
        return true;
    }
    
    public boolean ip6(String tok){
        if(tok.length() < 15)return false;
        if(tok.charAt(0) == ':' || tok.charAt(tok.length() - 1) == ':') return false;
        String[] toks = tok.split(":");
        if(toks.length != 8)return false;  
        for(String t : toks){
            if(!ip6tok(t)) return false;
        }
        return true;               
    }
    public boolean ip6tok(String tok){
        if(tok.length() > 4 || tok.length() == 0) return false;
        char[] ch = tok.toCharArray();
        for(char c : ch){
            boolean dig = c >= 48 && c <= 57;
            boolean up = c >= 65 && c <= 70;
            boolean low = c >= 97 && c <= 102;
            if(!(dig || up || low))return false;
        }
            
        return true;
    }
}

//https://leetcode.com/problems/validate-ip-address/discuss/95491/Java-Simple-Solution
