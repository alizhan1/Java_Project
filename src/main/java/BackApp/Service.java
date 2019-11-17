package BackApp;

public interface Service {

    public boolean addToCart(String meal);

    public Integer availableTables();

    public String getRestaurantName();

    public boolean bookTable(Integer tableId);
}
