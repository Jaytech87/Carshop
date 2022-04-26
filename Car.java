/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaProject;

/**
 *
 * @author Josh Lytle
 */
public class Car {

    //Attributes
    private String vin;
    private String make;
    private String model;
    private int year;
    private int mileage;
    private float price;
    //Default constructor

    public Car() {
        vin = "19UYA31581L000000";
        make = "Honda";
        model = "Accord";
        year = 2008;
        mileage = 18;
        price = 1100;
    }
    //Parameterized constructor

    public Car(String vin, String make, String model, int year, int mileage, float price) {
        this.vin = vin;
        this.make = make;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.price = price;
    }
    //Setters

    public void setVin(String vin) {
        this.vin = vin;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    //Getters

    public String getVin() {
        return vin;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public int getMileage() {
        return mileage;
    }

    public float getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Vin: " + vin + ", Make: " + make + ", Model: " + model + ", Year: " + year + ", Mileage: " + mileage + ", Price: $" + String.format("%.2f", price);
    }

    @Override
    //Check 2 cars are equal or not
    public boolean equals(Object obj) {
        if (obj instanceof Car) {
            Car car = (Car) obj;
            return car.vin.equals(vin);
        } else {
            return false;
        }
    }

}
