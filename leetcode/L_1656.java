class OrderedStream {
    String[] ar;
    int p;
    public OrderedStream(int n) {
        ar = new String[n+1];
        p = 1;
    }
    
    public List<String> insert(int idKey, String value) {
        List<String> res = new ArrayList<>();
        ar[idKey] = value; 
        if (idKey > p) return res;
        while (p < ar.length && ar[p] != null) {
            res.add(ar[p++]);
        }
        return res;
    }
}

class OrderedStream {
    //String[] ar;
    List<String> ar;
    int p;
    public OrderedStream(int n) {
        //ar = new String[n+1];
        ar = Arrays.asList(new String[n+1]);
        p = 1;
    }
    
    public List<String> insert(int idKey, String value) {
        List<String> res = new ArrayList<>();
        //ar[idKey] = value; 
        ar.set(idKey, value);
        if (idKey > p) return res;
        while (p < ar.size() && ar.get(p) != null) {
            res.add(ar.get(p++));
        }
        return res;
    }
}
