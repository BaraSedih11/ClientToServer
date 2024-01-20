package UDP;
public class Vehicle {
    private String plateId;
    private String make;
    private String model;
    private int year;
    private String color;

    public Vehicle(String plateId, String make, String model, int year, String color) {
        this.plateId = plateId;
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
    }

    public String getPlateId() {
        return plateId;
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

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return make + ", " + model + ", " + year + ", " + color;
    }
}
