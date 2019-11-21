package BackApp;

public class Location {
    private String neighbourhood;
    public String getNeighbourhood() {
        return neighbourhood;
    }

    private String address;
    public String getAddress() {
        return address;
    }

    private double latitude;
    public double getLatitude() {
        return latitude;
    }

    private double longitude;
    public double getLongitude() {
        return longitude;
    }

    public Location(String _neighbourhood, String _address, double _latitude, double _longitude) {
        this.neighbourhood = _neighbourhood;
        this.address = _address;
        this.latitude = _latitude;
        this.longitude = _longitude;
    }
}
