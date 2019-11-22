package BackApp;

public class CuisineType {
    private String name;
    private String countryOfOrigin;
    private String description;

    public CuisineType(String name, String countryOfOrigin, String description) {
        this.name = name;
        this.countryOfOrigin = countryOfOrigin;
        this.description = description;
    }

    public String getName() {
        return this.name;
    }
    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }
    public String getDescription() {
        return description;
    }
}
