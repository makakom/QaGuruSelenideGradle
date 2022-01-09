package fourTest;

public class Notebook {
    private String model;
    private String operatingSystem;
    private int price;

    public Notebook(String model, String operatingSystem, int price) {
        this.model = model;
        this.operatingSystem = operatingSystem;
        this.price = price;
    }

    public Notebook() {};

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Notebook: " +
                "model: " + this.model + ", " +
                "operatingSystem: " + this.operatingSystem  + ", " +
                "price: " + this.price;
    }
}
