package Car;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Car {
    private final String carID;
    private final String fuelType;
    private final String passangerType;
    private final boolean needsDinner;
    private final int consumption;

    @JsonCreator
    public Car(@JsonProperty("id") String carID,
               @JsonProperty("type") String fuelType,
               @JsonProperty("passengers") String passangerType,
               @JsonProperty("isDining") boolean needsDinner,
               @JsonProperty("consumption") int consumption)  {
        this.carID = carID;
        this.fuelType = fuelType;
        this.passangerType = passangerType;
        this.needsDinner = needsDinner;
        this.consumption = consumption;
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
