package BackApp;

public interface Service {

    public boolean addToCart(String meal);

    public Integer availableTables();

    public String getName();

    public boolean bookTable(Integer tableId);
}
