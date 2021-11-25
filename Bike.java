import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Bike {
    protected String brand;
    protected String model;
    protected List<String> muscleGroups= new ArrayList<>();
    protected boolean display;
    protected String price;

    public Bike(String brand, String model, List<String> muscleGroups, boolean display, String price) {
        this.brand = brand;
        this.model = model;
        this.muscleGroups = muscleGroups;
        this.display = display;
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

    public List<String> getMuscleGroups() {
        return muscleGroups;
    }

    public void setMuscleGroups(List<String> muscleGroups) {
        this.muscleGroups = muscleGroups;
    }

    public boolean isDisplay() {
        return display;
    }

    public void setDisplay(boolean display) {
        this.display = display;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public abstract String toString();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bike)) return false;
        Bike bike = (Bike) o;
        return isDisplay() == bike.isDisplay() && Objects.equals(getBrand(), bike.getBrand()) && Objects.equals(getModel(), bike.getModel()) && Objects.equals(getMuscleGroups(), bike.getMuscleGroups()) && Objects.equals(getPrice(), bike.getPrice());
    }

}
