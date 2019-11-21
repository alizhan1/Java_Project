package BackApp;

public class Food {
    private String name;
    private Integer price;
    private String description;
    private boolean isReady = false;

    public Food(String name, String description, Integer price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public  String getDescription() {
        return this.description;
    }

    public Integer getPrice() {
        return this.price;
    }

    public boolean getIsReady() {
        return this.isReady;
    }

    public void setReady(boolean ready) {
        isReady = ready;
    }

    public void setPrice(Integer newPrice) {
        price = newPrice;
    }
}
