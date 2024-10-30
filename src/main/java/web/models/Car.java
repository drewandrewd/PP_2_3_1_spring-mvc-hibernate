package web.models;

public class Car {

    private String model;
    private int horsePower;
    private int maxSpeed;

    public Car() {
    }

    public Car(String model, int horsePower, int maxSpeed) {
        this.model = model;
        this.horsePower = horsePower;
        this.maxSpeed = maxSpeed;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}
