package BackApp;

public class Location {

    private String neighbourhood;
    private String address;
    private double latitude;
    private double longitude;

    public Location(String _neighbourhood, String _address, double _latitude, double _longitude) {
        this.neighbourhood = _neighbourhood;
        this.address = _address;
        this.latitude = _latitude;
        this.longitude = _longitude;
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
