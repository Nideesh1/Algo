public class Codec {
    Map<String,String> map = new HashMap<>();
    
    
    String rand = "foijaslbjbaodijfijwaetoij109083thuv039tj";
    
    Random r = new Random();
    public String rand(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < 10; i ++){
            sb.append(rand.charAt(r.nextInt(15)));
        }
        return sb.toString();
    }
    
    String key = rand();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        
        while(map.containsKey(key)){
            key = rand();
        }
        map.put(key, longUrl);
        return "http://tinyurl.com/" + key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl.replace("http://tinyurl.com/", ""));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));

//https://leetcode.com/problems/encode-and-decode-tinyurl/solution/
