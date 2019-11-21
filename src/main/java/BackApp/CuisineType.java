package BackApp;

public class CuisineType {
    private String name;
    public String getName() {
        return this.name;
    }

    private String countryOfOrigin;
    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    private String description;
    public String getDescription() {
        return description;
    }

    public CuisineType(String _name, String _countryOfOrigin, String _description) {
        this.name = _name;
        this.countryOfOrigin = _countryOfOrigin;
        this.description = _description;
    }
}
