import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.JUnitCore;

//import java.util.ArrayList;

public class TrainTest {

    // Engine Tests
    @Test
    public void testEngineConstructor() {
        FuelType f = FuelType.ELECTRIC;
        double currentFuelLevel = 40.0;
        double fuelCapacity = 100.0;
        //ArrayList<Car> cars; //(office hour question)
        //NumberOfCars = 3;
        Engine testEngine = new Engine(f, currentFuelLevel, fuelCapacity);
        assertEquals(f, testEngine.getFuelType());
        assertEquals(currentFuelLevel, testEngine.getCurrentFuel(), 0.2);
        assertEquals(fuelCapacity, testEngine.getMaxFuel(), 0.2);
        //assertEquals()
        //Train train = new Train(FuelType.ELECTRIC, 40.0, 100.0, 3, 4);
        //fail();
    }
    @Test
    public void testEngineGo() {
        Engine testEngine = new Engine(FuelType.ELECTRIC, 40.0, 100.0);

        assertEquals("starts with 40 fuel", 40, testEngine.getCurrentFuel(), 0.2);

        testEngine.go();
        assertEquals("reduce fuel level by 1", 39, testEngine.getCurrentFuel(), 0.2 );

        testEngine.go();
        testEngine.go();
        
        assertTrue("should return true if there is fuel available", testEngine.go());
        assertEquals("should reduce fuel level by 1", 37, testEngine.getCurrentFuel(), 37);
    
        assertTrue("should return true if fuel available for second time", testEngine.go() );
        assertEquals("should reduce to 0 after second go", 36, testEngine.getCurrentFuel(), 36);

        assertFalse("should return false if no fuel available", testEngine.go());
        assertEquals("should not reduce fuel level after no fuel", 0.0, testEngine.getCurrentFuel(), 0.01);
        //fail();
    }

    // Car Tests
    @Test
    public void testCarAddPassenger() {
        Car c = new Car(2 );
        Passenger p1 = new Passenger("Hadiya");

        c.addPassenger(p1);
        assertEquals("Seats remaining decreased by 1 ", 1, c.seatsRemaining());
      
        //fail();
    } 

    @Test
    public void testCarRemovePassenger() {
        Car c = new Car(2);
        Passenger p1 = new Passenger("Hadiya");
        c.addPassenger(p1);

        // when passenger leaves
        c.removePassenger(p1);
        
        //remaining seat should increase
        assertEquals("Seats remaining increased by 1", 2, c.seatsRemaining());
        //fail();
    }

    // Passenger Tests
    @Test
    public void testPassengerBoardCarWithSpace() {
        Car c = new Car(5);
        Passenger p = new Passenger("Jamiila");

        boolean add = c.addPassenger(p);
        assertTrue(add); //returns true if passenger is added
        assertEquals(4, c.seatsRemaining()); //Seats remaining decreased by 1 after adding passenger

        //fail();
    }

    @Test
    public void testPassengerBoardCarFull() {
        Car c = new Car(2);
        Passenger p1 = new Passenger("Haweeya");
        Passenger p2 = new Passenger("Xaawa");
        Passenger p3 = new Passenger("Ayaan");
        Passenger p4 = new Passenger("Fadxi");
        Passenger p5 = new Passenger("Suuban");

        c.addPassenger(p1);
        c.addPassenger(p2);
        c.addPassenger (p3);
        c.addPassenger(p4);
        boolean add = c.addPassenger(p5);

        assertFalse("passengers cannot be added, the car is full", add);
        assertEquals("no seats remaining in the car", 0, c.seatsRemaining());
        //fail();
    }

    // Train Tests
    @Test
    public void testTrainConstructor() {
        Train train = new Train(FuelType.ELECTRIC, 40.0, 100.0, 3, 4);
        assertEquals(3, train.getNumberOfCars()); //should get the number of cars
        assertNotNull("Train has an engine", train.getEngine());
        //fail();
    }

    @Test
    public void testTrainPassengerCount() {
        Train train = new Train(FuelType.ELECTRIC, 40.0, 100.0, 3, 4);
        Passenger p1 = new Passenger("Hibo");

        train.getCar(0).addPassenger(p1);

        assertEquals(train.getMaxCapacity() - 1, train.seatsRemaining()); //seats remaining in the train
        //fail();
    }

    @Test
    public void testTrainGetCar() {
        Train train = new Train(FuelType.ELECTRIC, 40.0, 100.0, 3, 4);

        assertNotNull("Train has a car", train.getCar(0));
        assertNotNull(train.getCar(1));
        assertNotSame(train.getCar(0), train.getCar(1)); //should not be the same car
        //fail();
    }

    @Test
    public void testTrainPrintManifest(){
        Train train = new Train(FuelType.ELECTRIC, 40.0, 100.0, 3, 4);
        Passenger p1 = new Passenger("Hibo");
        Passenger p2 = new Passenger("Hadiya");

        train.getCar(0).addPassenger(p1);
        train.getCar(1).addPassenger(p2);

        // compare if its giving the right output
        //String expected = "Train manifest\nPassengers aboard\nHibo\nNo passengers in the car\n";
        train.printManifest();
        //assertEquals(expected, train.printManifest());
        //fail();
    }
    public static void main(String[] args){
        JUnitCore.main("TrainTest");
    }
    //public static void main(String[] args) {
        //Result result = JUnitCore.runClasses(TrainTest.class);

       // for (Failure failure : result.getFailures()) {
            //System.out.println(failure.toString());
       // }

       // System.out.println("All tests passed: " + result.wasSuccessful());
    }
    
    

