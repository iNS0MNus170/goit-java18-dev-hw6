package global.goit.entity;

public class ProjectPrices {
    private String name;
    private int price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "name - " + name +
                ", price - " + price + "\n";
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
