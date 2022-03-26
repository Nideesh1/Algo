class Solution {
    public int minMeetingRooms(int[][] intervals) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for (int[] inter : intervals) {
            map.put(inter[0], map.getOrDefault(inter[0], 0 ) + 1);
            map.put(inter[1], map.getOrDefault(inter[1], 0 ) - 1);
        }
        int room = 0, res = 0;
        for (int val : map.values()) {
            room += val;
            res = Math.max(res, room);
        }
        return res;
    }
}

//https://leetcode.com/problems/meeting-rooms-ii/discuss/203658/HashMapTreeMap-resolves-Scheduling-Problem
