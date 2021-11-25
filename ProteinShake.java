import java.util.Objects;

public class ProteinShake {

    private String brand;
    private String flavour;
    private String size;
    private String price;

    public ProteinShake(String brand, String flavour, String size, String price) {
        this.brand = brand;
        this.flavour = flavour;
        this.size = size;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getFlavour() {
        return flavour;
    }

    public void setFlavour(String flavour) {
        this.flavour = flavour;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProteinShake)) return false;
        ProteinShake that = (ProteinShake) o;
        return Objects.equals(getBrand(), that.getBrand()) && Objects.equals(getFlavour(), that.getFlavour()) && Objects.equals(getSize(), that.getSize()) && Objects.equals(getPrice(), that.getPrice());
    }

    @Override
    public String toString() {
        return "ProteinShake{" +
                "brand='" + brand + '\'' +
                ", flavour='" + flavour + '\'' +
                ", size='" + size + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
