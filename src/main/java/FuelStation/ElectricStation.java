package FuelStation;

public class ElectricStation implements Refuelable{
    private static int electricCarsFueled = 0;

    @Override
    public void refuel(String carID){
        System.out.println("Refueling electric car " + carID);
        electricCarsFueled++;
    }

    public static int getElectricCarsFueled(){
        return electricCarsFueled;
    }
}
