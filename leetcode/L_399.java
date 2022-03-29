class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] res = new double[queries.size()];
        UF uf = new UF();
        for (int i = 0; i < equations.size(); i++) {
            uf.union(equations.get(i).get(0), equations.get(i).get(1), values[i]);
        }
        for (int i = 0; i < queries.size(); i++) {
            String x = queries.get(i).get(0);
            String y = queries.get(i).get(1);
            
            res[i] = uf.parents.containsKey(x) && uf.parents.containsKey(y) &&
                uf.find(x) == uf.find(y) ? uf.vals.get(x) / uf.vals.get(y) : -1;
        }
        return res;
    }
    
    class UF {
        Map<String,String> parents;
        Map<String,Double> vals;
        UF () {
            parents = new HashMap<>();
            vals = new HashMap<>();
        }
        public void union (String x , String y, double v) {
            add(x); add(y);
            String px = find(x); String py = find(y);
            // x/px -> vals.get(x) y/py -> vals.get(y). px -> vals.get(y) / vals.get(x) * y/x
            // y/x is v
            parents.put(px, py);
            vals.put(px, v * vals.get(y) / vals.get(x));
        }
        public String find (String x) {
            String p = parents.getOrDefault(x, x);
            if (x != p) {
                String pp = find(p);
                vals.put(x , vals.get(x) * vals.get(p));
                parents.put(x, pp);
            }
            return parents.getOrDefault(x,x);
        }
        
        
        public void add (String x) {
            if (parents.containsKey(x)) return;
            parents.put(x, x);
            vals.put(x, 1.0);
        }
        
    }
}


class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values,
            List<List<String>> queries) {

        HashMap<String, HashMap<String, Double>> graph = new HashMap<>();

        // Step 1). build the graph from the equations
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String dividend = equation.get(0), divisor = equation.get(1);
            double quotient = values[i];

            if (!graph.containsKey(dividend))
                graph.put(dividend, new HashMap<String, Double>());
            if (!graph.containsKey(divisor))
                graph.put(divisor, new HashMap<String, Double>());

            graph.get(dividend).put(divisor, quotient);
            graph.get(divisor).put(dividend, 1 / quotient);
        }
        System.out.println(graph);
        // Step 2). Evaluate each query via bactracking (DFS)
        // by verifying if there exists a path from dividend to divisor
        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String dividend = query.get(0), divisor = query.get(1);

            if (!graph.containsKey(dividend) || !graph.containsKey(divisor))
                results[i] = -1.0;
            else if (dividend == divisor)
                results[i] = 1.0;
            else {
                HashSet<String> visited = new HashSet<>();
                results[i] = backtrackEvaluate(graph, dividend, divisor, 1, visited);
            }
        }

        return results;
    }

    private double backtrackEvaluate(HashMap<String, HashMap<String, Double>> graph, String currNode, String targetNode, double accProduct, Set<String> visited) {
        if (!graph.containsKey(currNode)) return -1;
        // mark the visit
        visited.add(currNode);
        double ret = -1.0;

        Map<String, Double> neighbors = graph.get(currNode);
        if (neighbors.containsKey(targetNode))
            ret = accProduct * neighbors.get(targetNode);
        else {
            for (Map.Entry<String, Double> pair : neighbors.entrySet()) {
                String nextNode = pair.getKey();
                if (visited.contains(nextNode))
                    continue;
                ret = backtrackEvaluate(graph, nextNode, targetNode,
                        accProduct * pair.getValue(), visited);
                if (ret != -1.0)
                    break;
            }
        }

        // unmark the visit, for the next backtracking
        visited.remove(currNode);
        return ret;
    }
}
