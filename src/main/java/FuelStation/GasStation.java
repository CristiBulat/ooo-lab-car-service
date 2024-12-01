package FuelStation;

public class GasStation implements Refuelable{
    private static int gasCarsRefueled = 0;

    @Override
    public void refuel(String carID){
        gasCarsRefueled++;
        System.out.println("Gas cars refueled: " + carID);
    }

    public static int getGasCarsRefueled(){
        return gasCarsRefueled;
    }
}
