package model;

public abstract class Motorbike {
    private int id;
    private int year;
    private int price;
    private String brand;
    private String model;

    // abstract method
    public abstract void startEngine();
    public abstract void stopEngine();
    public abstract void drive();

    //display method
    public void display(){
        System.out.println("Brand: " + model);
        System.out.println("ID: " + id);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Price: " + price + "$");
    }

    //setter and getter method
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
}
