class SnapshotArray {
    int snap_id;
    TreeMap<Integer,Integer>[] arr;
    public SnapshotArray(int length) {
        arr = new TreeMap[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new TreeMap<>();
            arr[i].put(0,0);
        }
        snap_id = 0;
    }
    
    public void set(int index, int val) {
        arr[index].put(snap_id, val);
    }
    
    public int snap() {
        return snap_id++;
    }
    
    public int get(int index, int snap_id) {
        return arr[index].floorEntry(snap_id).getValue();
    }
}

//https://leetcode.com/problems/snapshot-array/discuss/350562/JavaPython-Binary-Search
