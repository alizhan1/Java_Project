package BackApp;

public interface Service {

    public void orderFood(String meal);

    public Integer availableTables();

    public String getRestaurantName();

    public void bookTable(Integer tableId);
}
