package model;

public class Honda extends Motorbike{
    @Override
    public String startEngine() {
        return "Motor Honda Started!";
    }

    @Override
    public String stopEngine() {
        return "Motor Honda Stopped!";
    }

    @Override
    public String drive() {
        return "Motor Honda is Driving...";
    }

}
