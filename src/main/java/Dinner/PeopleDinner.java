package Dinner;

public class PeopleDinner implements Dineable{
    private static int peopleServed = 0;

    @Override
    public void serveDinner(String carID){
        System.out.println("Serving dinner to people in car " + carID);
        peopleServed++;
    }

    public static int getPeopleServed(){
        return peopleServed;
    }
}
