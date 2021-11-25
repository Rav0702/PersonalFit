import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class SpinningBike extends HomeTrainerBike{

    private String weight;
    private String resistance;

    public SpinningBike(String brand, String model, List<String> muscleGroups, boolean display, String weight, String resistance, String price) {
        super(brand, model, muscleGroups, display, price);
        this.weight = weight;
        this.resistance = resistance;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getResistance() {
        return resistance;
    }

    public void setResistance(String resistance) {
        this.resistance = resistance;
    }

    @Override
    public String toString() {
        return "SpinningBike{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", muscleGroups=" + muscleGroups +
                ", display=" + display +
                ", price='" + price + '\'' +
                ", weight=" + weight +
                ", resistance='" + resistance + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SpinningBike)) return false;
        if (!super.equals(o)) return false;
        SpinningBike that = (SpinningBike) o;
        return weight == that.weight && Objects.equals(resistance, that.resistance);
    }


}
