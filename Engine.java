
public class Engine implements EngineRequirements{
// Attribute
private FuelType fuelType;
private double currentFuelLevel;
private double maxFuelLevel;
/*@param f the fuel type of the engine
 * @param currentFuellevel the current fuel level of the engine
 * @param maxFuellevel the maximum fuel level of the engine
 */

public Engine(FuelType fuelType, double currentFuelLevel, double maxFuelLevel){
    this.fuelType = fuelType;
    this.currentFuelLevel = currentFuelLevel;
    this.maxFuelLevel = maxFuelLevel;



}
@Override
public FuelType getFuelType(){
    return this.fuelType;
}
public double getMaxFuel(){
    return this.maxFuelLevel;
}

public double getCurrentFuel(){
    return this.currentFuelLevel;
}
@Override
public void refuel(){
    this.currentFuelLevel = this.maxFuelLevel;

}
//System.out.println("Remaining fuel:" + this.currentFuelLevel);

public boolean go(){
    if(this.currentFuelLevel > 0){
        this.currentFuelLevel -= 1; // each go reduces the fuel level by 1 unit
        return true; // return true if there is fuel still left
    } else {
        return false;

    }
}
// Overide toString to print the status of the engine
@Override
public String toString(){
    return ("Engine has fuel type:" + this.fuelType + " current fuel level:" + this.currentFuelLevel + "and max fuel level:" + this.maxFuelLevel); 
}

//main method to test the Engine class

public static void main(String[] args){
    Engine myEngine = new Engine(FuelType.ELECTRIC,40.0,100.0);
    // simulate the engine running until it runs out of fuel
    while (myEngine.go()){
        System.out.println("Choo Choo");
}
        System.out.println("Out of fuel");
}}