package model;

public class Suzuki extends Motorbike{
    @Override
    public String startEngine() {
        return "Motor Suzuki Started!";
    }

    @Override
    public String stopEngine() {
        return "Motor Suzuki Stopped!";
    }

    @Override
    public String drive() {
        return "Motor Suzuki is Driving...";
    }
}
