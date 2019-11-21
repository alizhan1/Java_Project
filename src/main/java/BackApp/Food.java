package BackApp;

public class Food {
    private String name;
    public String getName() {
        return this.name;
    }

    private String description;
    public  String getDescription() {
        return this.description;
    }

    private int price;
    public  int getPrice() {
        return this.price;
    }

    private boolean isReady = false;
    public boolean isReady() {
        return this.isReady;
    }


    public Food(String _name, String _description, int _price) {
        this.name = _name;
        this.description = _description;
        this.price = _price;
    }

    public void makeReady() {
        isReady = true;
    }

    public void changePrice(int newPrice) {
        this.price = newPrice;
    }
}
