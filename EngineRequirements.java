interface EngineRequirements {

    FuelType getFuelType(); 
    double getMaxFuel();
    double getCurrentFuel(); 
    void refuel(); 
    boolean go();  
    
}
