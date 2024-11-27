package Dinner;

public class RobotDinner implements Dineable{
    private static int robotsServed = 0;

    @Override
    public void serveDinner(String carID){
        System.out.println("Serving dinner to robots in car " + carID);
        robotsServed++;
    }

    public static int getRobotsServed(){
        return robotsServed;
    }
}
