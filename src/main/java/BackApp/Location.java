package BackApp;

public class Location {
    private String neighbourhood;
    private String address;
    private double latitude;
    private double longitude;

    public Location(String neighbourhood, String address, double latitude, double longitude) {
        this.neighbourhood = neighbourhood;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getNeighbourhood() {
        return neighbourhood;
    }

    public String getAddress() {
        return address;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
