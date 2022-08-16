package Nivel3.commands;

public class AcelerarImp implements IOperacion {

    private Vehicle vehicle;
    public AcelerarImp(Vehicle vehicle) {
        this.vehicle = vehicle;
    }


    @Override
    public void execute(){this.vehicle.accelerar(this.vehicle);}
}
