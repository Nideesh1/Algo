class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        UF dsu = new UF(10001);
        Map<String, String> emailToName = new HashMap();
        Map<String, Integer> emailToID = new HashMap();
        int id = 0;
        for (List<String> account: accounts) {
            String name = "";
            for (String email: account) {
                if (name == "") {
                    name = email;
                    continue;
                }
                emailToName.put(email, name);
                if (!emailToID.containsKey(email)) {
                    emailToID.put(email, id++);
                }
                dsu.union(emailToID.get(account.get(1)), emailToID.get(email));
            }
        }

        Map<Integer, List<String>> ans = new HashMap();
        for (String email: emailToName.keySet()) {
            int index = dsu.find(emailToID.get(email));
            ans.computeIfAbsent(index, x-> new ArrayList()).add(email);
        }
        for (List<String> component: ans.values()) {
            Collections.sort(component);
            component.add(0, emailToName.get(component.get(0)));
        }
        return new ArrayList(ans.values());
    }
}
class UF{
    Sub[] ar;
    UF(int size){
        ar = new Sub[size];
        for(int i = 0; i < size; i++){
            ar[i] = new Sub(i, 0);
        }
    }
    
    public int find(int x){
        if(x != ar[x].par){
            ar[x].par = find(ar[x].par);
        }
        return ar[x].par;
    }
    
    public void union(int x, int y){
        int xp = find(x); int yp = find(y);
        if(xp != yp){
            if(ar[xp].rank < ar[yp].rank){
                ar[xp].par = yp;
            }
            else if(ar[xp].rank > ar[yp].rank){
                ar[yp].par = xp;
            }else{
                ar[xp].par = yp;
                ar[yp].rank++;
            }
        }
    }
}

class Sub{
    int par;
    int rank;
    Sub(int par, int rank){
        this.par = par;
        this.rank = rank;
    }
}
