package BackApp;

public class Review {
    private String name;
    private String date;
    private double rating;
    private String comments;

    public Review(String _name, String _date, double _rating, String _comments) {
        this.name = _name;
        this.date = _date;
        this.rating = _rating;
        this.comments = _comments;
    }

    public String getName() {
        return name;
    }
    public String getDate() {
        return date;
    }
    public double getRating() {
        return rating;
    }
    public String getComments() {
        return comments;
    }
}
