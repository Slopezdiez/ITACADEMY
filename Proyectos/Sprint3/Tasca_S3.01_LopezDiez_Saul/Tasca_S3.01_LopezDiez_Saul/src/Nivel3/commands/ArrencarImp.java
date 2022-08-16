package Nivel3.commands;

public class ArrencarImp implements IOperacion {

    private Vehicle vehicle;


    public ArrencarImp(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public void execute(){this.vehicle.arrencar(this.vehicle);}
}
