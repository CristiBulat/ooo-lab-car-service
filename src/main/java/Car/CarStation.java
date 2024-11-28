package Car;
import Dinner.*;
import FuelStation.*;
import queue.LinkedQueue;
import queue.Queue;

public class CarStation {
    private final Dineable peopleDiningService;
    private final Dineable robotDiningService;
    private final Refuelable electricRefuelingService;
    private final Refuelable gasRefuilingservice;
    private final LinkedQueue<Car> queue;

   public CarStation(){
        this.peopleDiningService = new PeopleDinner();
        this.robotDiningService = new RobotDinner();
        this.electricRefuelingService = new ElectricStation();
        this.gasRefuilingservice = new GasStation();
        this.queue = new LinkedQueue<>();
   }

    public void addCar(Car car) {
        queue.enqueue(car);
        System.out.println("Car with the id " + car.getCarID() + " added to the queue.");
    }

    public void serveCars() {
        while (!queue.isEmpty()) {
            Car car = queue.dequeue();

            // Handle dining based on passenger type
            if (car.needsDinner()) {
                if ("people".equalsIgnoreCase(car.getPassangerType())) {
                    peopleDiningService.serveDinner(car.getCarID());
                } else if ("robots".equalsIgnoreCase(car.getPassangerType())) {
                    robotDiningService.serveDinner(car.getCarID());
                }
            }

            // Handle refueling based on fuel type
            if ("electric".equalsIgnoreCase(car.getFuelType())) {
                electricRefuelingService.refuel(car.getCarID());
            } else if ("gas".equalsIgnoreCase(car.getFuelType())) {
                gasRefuilingservice.refuel(car.getCarID());
            }
        }
        System.out.println("All cars have been served.");
    }

    public Queue<Car> getQueue() {
       return queue;
    }
}
