package Nivel3.commands;

public class FrenarImp implements IOperacion {

    private Vehicle vehicle;


    public FrenarImp(Vehicle vehicle) {
        this.vehicle = vehicle;

    }


    @Override
    public void execute(){this.vehicle.frenar(this.vehicle);}
}
