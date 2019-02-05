/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        int res = 0;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> importance = new HashMap<>();
        for(Employee e: employees){
            graph.put(e.id, e.subordinates);
            importance.put(e.id, e.importance);
        }
        Set<Integer> set = new HashSet<Integer>();
        Queue<Integer> q = new LinkedList<>();
        q.add(id); set.add(id); res+= importance.get(id);
        while(!q.isEmpty()){
            int p = q.poll();
            List<Integer> l = graph.get(p);
            for(Integer i : l){
                if(!set.contains(i)){
                    q.add(i); res+= importance.get(i); set.add(i);
                }
            }
        }
        return res;
        
    }
}

//https://leetcode.com/problems/employee-importance/description/
