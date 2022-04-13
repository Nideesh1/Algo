class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] res = new double[queries.size()];
        Map<String,Map<String,Double>> map = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> eq = equations.get(i);
            String u = eq.get(0), v = eq.get(1);
            double val = values[i];
            
            Map<String,Double> one = map.getOrDefault(u, new HashMap<>());
            one.put(v, val);
            map.put(u, one);

            Map<String,Double> two = map.getOrDefault(v, new HashMap<>());
            two.put(u, 1/val);
            map.put(v, two);        
        
        } 
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String dividend = query.get(0), divisor = query.get(1);
            if (!map.containsKey(dividend) || !map.containsKey(divisor)) {
                res[i] = -1;
            } else if (divisor == dividend) {
                res[i] = 1;
            } else {
                Set<String> set = new HashSet<>();
                res[i] = dfs (map, dividend, divisor, 1, set);
            }
        }
        //System.out.println(map);
        return res;
    }
    public double dfs(Map<String,Map<String,Double>> map, String cur, String target, double mul, Set<String> set) {
        if (!map.containsKey(cur)) return -1;
        double res = -1;
        set.add(cur);
        
        Map<String,Double> neis = map.get(cur);
        if (neis.containsKey(target)) {
            res = mul * neis.get(target);
        } else {
            for (String nei : neis.keySet()) {
                if (set.contains(nei)) continue;
                res = dfs(map, nei, target, mul * neis.get(nei), set);
                //we found it, stop recursion
                if (res != -1) break;
            }
        }
        
        
        set.remove(cur);
        return res;
    }
    
}
