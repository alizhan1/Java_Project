package BackApp;

public class Review {
    private String name;
    public String getName() {
        return name;
    }

    private String date;
    public String getDate() {
        return date;
    }

    private int rating;
    public int getRating() {
        return rating;
    }

    private String comments;
    public String getComments() {
        return comments;
    }

    public Review(String _name, String _date, int _rating, String _comments) {
        this.name = _name;
        this.date = _date;
        this.rating = _rating;
        this.comments = _comments;
    }
}
