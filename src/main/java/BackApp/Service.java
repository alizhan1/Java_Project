package BackApp;

public interface Service {

    public boolean orderFood(String meal);

    public Integer availableTables();

    public String getRestaurantName();

    public boolean bookTable(Integer tableId);
}
