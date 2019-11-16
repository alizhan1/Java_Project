package BackApp;

public class Restaurant implements Service {
    @Override
    public boolean addToCart(String meal) {
        return false;
    }

    @Override
    public Integer availableTables() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public boolean bookTable(Integer tableId) {
        return false;
    }
}
