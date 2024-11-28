package Car;

public class Car {
    private final String carID;
    private final String fuelType;
    private final String passangerType;
    private final boolean needsDinner;

    public Car(String carID, String fuelType, String passangerType, boolean needsDinner){
        this.carID = carID;
        this.fuelType = fuelType;
        this.passangerType = passangerType;
        this.needsDinner = needsDinner;
    }

    public String getCarID(){
        return carID;
    }

    public String getFuelType(){
        return fuelType;
    }

    public String getPassangerType(){
        return passangerType;
    }

    public boolean needsDinner(){
        return needsDinner;
    }
}
