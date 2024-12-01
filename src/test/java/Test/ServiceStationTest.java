package Test;

import Dinner.PeopleDinner;
import Dinner.RobotDinner;
import Dinner.Dineable;
import FuelStation.ElectricStation;
import FuelStation.GasStation;
import FuelStation.Refuelable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ServiceStationTest {

    private Dineable peopleDinner;
    private Dineable robotDinner;
    private Refuelable electricStation;
    private Refuelable gasStation;

    @BeforeEach
    public void setUp() {
        // Initialize service objects before each test
        peopleDinner = new PeopleDinner();
        robotDinner = new RobotDinner();
        electricStation = new ElectricStation();
        gasStation = new GasStation();

    }

    @Test
    public void testRefueling() {
        // Test refueling operations
        electricStation.refuel("E1");
        gasStation.refuel("G1");
        electricStation.refuel("E2");

        // Assert fuel counts
        assertEquals(2, ElectricStation.getElectricCarsFueled(), "Electric cars refueled count should be 2.");
        assertEquals(1, GasStation.getGasCarsRefueled(), "Gas cars refueled count should be 1.");
    }

    @Test
    public void testDining() {
        // Test dining operations
        peopleDinner.serveDinner("P1");
        robotDinner.serveDinner("R1");
        peopleDinner.serveDinner("P2");

        // Assert dinner counts
        assertEquals(2, PeopleDinner.getPeopleServed(), "People served count should be 2.");
        assertEquals(1, RobotDinner.getRobotsServed(), "Robots served count should be 1.");
    }

}

