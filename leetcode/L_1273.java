class Solution {
public int deleteTreeNodes(int nodes, int[] parent, int[] value) {
        for(int i=nodes-1;i>0;i--){
            value[parent[i]] += value[i];
        }
        HashSet<Integer> hs = new HashSet();
        int count = 0;
        for(int i=0;i<nodes;i++){
            if(hs.contains(parent[i])){
                value[i] = 0; 
            }
            if(value[i] == 0){
                hs.add(i);
                count ++;
            }
        }
        return nodes-count;
    }
}

//https://leetcode.com/problems/delete-tree-nodes/discuss/440792/JavaO(n)
