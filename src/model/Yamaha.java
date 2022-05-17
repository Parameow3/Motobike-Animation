package model;

public class Yamaha extends Motorbike{
    @Override
    public String startEngine() {
        return "Motor Yamaha Started!";
    }

    @Override
    public String stopEngine() {
        return "Motor Yamaha Stopped!";
    }

    @Override
    public String drive() {
        return "Motor Yamaha is Driving...";
    }
}
