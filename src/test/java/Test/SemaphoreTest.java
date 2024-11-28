package Test;

import Car.*;
import queue.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SemaphoreTest {

    @Test
    void testGuideCars() {
        // Mock CarStation for Gas and Electric cars
        CarStation gasStation = new CarStation();
        CarStation electricStation = new CarStation();

        // Create Semaphore instance
        Semaphore semaphore = new Semaphore(gasStation, electricStation);

        // JSON input for test, updated based on Car class properties
        String jsonCars = """
                [
                    {"id": 1, "type": "ELECTRIC", "passengers": "PEOPLE", "isDining": false, "consumption": 42},
                    {"id": 2, "type": "ELECTRIC", "passengers": "ROBOTS", "isDining": false, "consumption": 45},
                    {"id": 3, "type": "GAS", "passengers": "PEOPLE", "isDining": false, "consumption": 13},
                    {"id": 4, "type": "GAS", "passengers": "ROBOTS", "isDining": true, "consumption": 24}
                ]
                """;

        // Execute the guideCars method
        semaphore.guideCars(jsonCars);

        // Assertions for car counts
        assertEquals(2, semaphore.getGasCarCount(), "Gas car count should be 2");
        assertEquals(2, semaphore.getElectricCarCount(), "Electric car count should be 2");

        // Verify the cars in the Gas station queue
        Queue<Car> gasCars = gasStation.getQueue();
        assertEquals(2, gasCars.size(), "Gas station should have 2 cars in queue");
        assertEquals("GAS", gasCars.dequeue().getFuelType(), "First car in Gas station should be of type 'gas'");
        assertEquals("GAS", gasCars.dequeue().getFuelType(), "Second car in Gas station should be of type 'gas'");

        // Verify the cars in the Electric station queue
        Queue<Car> electricCars = electricStation.getQueue();
        assertEquals(2, electricCars.size(), "Electric station should have 2 cars in queue");
        assertEquals("ELECTRIC", electricCars.dequeue().getFuelType(), "First car in Electric station should be of type 'electric'");
        assertEquals("ELECTRIC", electricCars.dequeue().getFuelType(), "Second car in Electric station should be of type 'electric'");
    }
}
