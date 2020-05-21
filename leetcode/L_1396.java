class UndergroundSystem {

    private Map<String,Pair<Double,Double>> journey = new HashMap<>();
    
    //32, <Cambridge,22>
    private Map<Integer,Pair<String,Integer>> checkIn = new HashMap<>();
    
    public UndergroundSystem() {
        
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkIn.put(id, new Pair<>(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Pair<String,Integer> val = checkIn.get(id);
        String outS = val.getKey();
        Integer outT = val.getValue();
        
        String key = outS + "->" + stationName;
        Pair<Double,Double> stats = journey.getOrDefault(key, new Pair<>(0.0,0.0));
        
        Double totalTime = stats.getKey();
        Double totalTrips = stats.getValue();
        
        double thisTrip = t - outT;
        totalTime += thisTrip;
        journey.put(key, new Pair<>(totalTime, totalTrips + 1));
        
        checkIn.remove(id);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String key = startStation+"->"+endStation;
        Double totalTime = journey.get(key).getKey();
        Double times = journey.get(key).getValue();
        return totalTime/times;
    }
}
//https://leetcode.com/problems/design-underground-system/solution/