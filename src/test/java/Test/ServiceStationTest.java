package Test;
import Dinner.*;
import FuelStation.*;

public class ServiceStationTest {
    public static void main(String[] args) {
        // Create service objects
        Dineable peopleDinner = new PeopleDinner();
        Dineable robotDinner = new RobotDinner();
        Refuelable electricStation = new ElectricStation();
        Refuelable gasStation = new GasStation();

        // Test refueling
        electricStation.refuel("E1");
        gasStation.refuel("G1");
        electricStation.refuel("E2");

        // Test dining
        peopleDinner.serveDinner("P1");
        robotDinner.serveDinner("R1");
        peopleDinner.serveDinner("P2");

        // Output counts
        System.out.println("\nStatistics:");
        System.out.println("Electric cars served: " + ElectricStation.getElectricCarsFueled());
        System.out.println("Gas cars served: " + GasStation.getGasCarsRefueled());
        System.out.println("People served: " + PeopleDinner.getPeopleServed());
        System.out.println("Robots served: " + RobotDinner.getRobotsServed());
    }
}

