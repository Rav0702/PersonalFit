import java.util.List;

public class HomeTrainerBike extends Bike {

    public HomeTrainerBike(String brand, String model, List<String> muscleGroups, boolean display, String price) {
        super(brand, model, muscleGroups, display, price);
    }

    @Override
    public String toString() {
        return "HomeTrainerBike{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", muscleGroups=" + muscleGroups +
                ", display=" + display +
                ", price='" + price + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
}
