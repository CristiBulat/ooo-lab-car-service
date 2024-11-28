package Car;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;

public class Semaphore {
    private final CarStation gasCarStation;
    private final CarStation electricCarStation;
    private int gasCarCount = 0;
    private int electricCarCount = 0;

    public Semaphore(CarStation gasCarStation, CarStation electricCarStation) {
        this.gasCarStation = gasCarStation;
        this.electricCarStation = electricCarStation;
    }

    public void guideCars(String jsonCars) {
        try {
            // Parse JSON string into a list of Car objects
            ObjectMapper objectMapper = new ObjectMapper();
            List<Car> cars = objectMapper.readValue(jsonCars,
                    objectMapper.getTypeFactory().constructCollectionType(List.class, Car.class));

            // Assign cars to the correct CarStation
            for (Car car : cars) {
                if ("gas".equalsIgnoreCase(car.getFuelType())) {
                    gasCarStation.addCar(car);
                    gasCarCount++;
                } else if ("electric".equalsIgnoreCase(car.getFuelType())) {
                    electricCarStation.addCar(car);
                    electricCarCount++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getGasCarCount() {
        return gasCarCount;
    }

    public int getElectricCarCount() {
        return electricCarCount;
    }
}
