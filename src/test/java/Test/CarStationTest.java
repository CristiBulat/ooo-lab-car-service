package Test;
import Car.*;
import Dinner.*;
import FuelStation.*;

public class CarStationTest {
    public static void main(String[] args) {
        // Create service implementations
        Dineable peopleDiningService = new PeopleDinner();
        Dineable robotDiningService = new RobotDinner();
        Refuelable electricRefuelingService = new ElectricStation();
        Refuelable gasRefuelingService = new GasStation();

        // Create CarStation
        CarStation carStation = new CarStation(
                peopleDiningService, robotDiningService,
                electricRefuelingService, gasRefuelingService
        );

        // Add cars to the station
        carStation.addCar(new Car("C1", "electric", "people", true));
        carStation.addCar(new Car("C2", "gas", "robots", true));
        carStation.addCar(new Car("C3", "electric", "robots", false));
        carStation.addCar(new Car("C4", "gas", "people", false));

        // Serve cars
        carStation.serveCars();
    }
}
