public class Movie {
    private String title;
    private String genre;
    private int rating;

    public Movie() {
        this.title = "N/A";
        this.genre = "N/A";
        this.rating = 0;
    }

    public Movie(String title, String genre, int rating) {
        this.title = title;
        this.genre = genre;
        this.rating = rating;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return this.genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getRating() {
        return this.rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String toString() {
        return "Title: " + title +
                "\nGenre: " + genre +
                "\nRating: " + rating + "/10";
    }
}
