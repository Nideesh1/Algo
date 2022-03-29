class TrafficLight {
    ReentrantLock lock;
    boolean green;
    public TrafficLight() {
        lock = new ReentrantLock(true);
        green = true;
    }
    
    public void carArrived(
        int carId,           // ID of the car
        int roadId,          // ID of the road the car travels on. Can be 1 (road A) or 2 (road B)
        int direction,       // Direction of the car
        Runnable turnGreen,  // Use turnGreen.run() to turn light to green on current road
        Runnable crossCar    // Use crossCar.run() to make car cross the intersection 
    ) throws InterruptedException {
        lock.lock();
        try{
            if ((!green && roadId == 1) || (green && roadId == 2)) {
                green = !green;
                turnGreen.run();
            }
            crossCar.run();
        }
        finally{
            lock.unlock();
        }
    }
}

//https://leetcode.com/problems/traffic-light-controlled-intersection/discuss/1015108/Java-ReentrantLock-with-boolean-Concise-solution
