class Passenger  {
    public int checkinTime;
    public String startStation;
    int checkoutTime;
    String endStation;
    public void checkIn(int checkinTime, String startStation) {
        this.checkinTime = checkinTime;
        this.startStation = startStation;
    }
    public void checkOut(int checkoutTime, String endStation) {
        this.checkoutTime = checkoutTime;
        this.endStation = endStation;        
    }
}
class Route {
    String startStation;
    String endStation;
    int totalTime;
    int totalTrips;
    public Route (String startStation, String endStation) {
        this.startStation = startStation;
        this.endStation = endStation;
        this.totalTime = 0;
        this.totalTrips = 0;
    }
    public double getAverageTime() {
        return (double) totalTime / totalTrips;
    }
    public void addTime(int time) {totalTime += time;}
    public void addTrip() {totalTrips++;}
}

class UndergroundSystem {
    Map<Integer,Passenger> passengerMap;
    Map<String,Route> routeMap;
    public UndergroundSystem() {
        passengerMap = new HashMap<>();
        routeMap = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        if (!passengerMap.containsKey(id)) {
            Passenger passenger = new Passenger();
            passenger.checkIn(t, stationName);
            passengerMap.put(id, passenger);
        }
    }
    
    public void checkOut(int id, String stationName, int t) {
        if (passengerMap.containsKey(id)) {
            Passenger passenger = passengerMap.get(id);
            passenger.checkOut(t, stationName);
            
            String routeKey = passenger.startStation + "," + passenger.endStation;
            Route route = routeMap.getOrDefault(routeKey, new Route(passenger.startStation, passenger.endStation));
            route.addTrip();
            route.addTime(passenger.checkoutTime - passenger.checkinTime);
            routeMap.put(routeKey, route);
            passengerMap.remove(id);
        }
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String routeKey = startStation + "," + endStation;
        return routeMap.get(routeKey).getAverageTime();
    }
}
