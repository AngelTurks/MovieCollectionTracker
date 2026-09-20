import java.util.ArrayList;

public class MovieService {
    private ArrayList<Movie> movies = new ArrayList();

    public MovieService() {
    }

    public void addMovie(Movie movie) {
        boolean exists = false;

        for(int i = 0; i < this.movies.size(); ++i) {
            Movie currentMovie = (Movie)this.movies.get(i);
            if (currentMovie.getTitle().equalsIgnoreCase(movie.getTitle())) {
                System.out.println("\nMovie already exists. Try another title.");
                exists = true;
                break;
            }
        }

        if (!exists) {
            this.movies.add(movie);
            System.out.println("\nMovie was added successfully!");
        }

    }

    public void viewMovies() {
        if (this.movies.isEmpty()) {
            System.out.println("\nNo movies in collection.");
        } else {
            for(Movie movie : this.movies) {
                System.out.println(movie);
            }
        }

    }

    public void deleteMovie(String title) {
        boolean found = false;

        for(int i = 0; i < this.movies.size(); ++i) {
            Movie currentMovie = (Movie)this.movies.get(i);
            if (currentMovie.getTitle().equalsIgnoreCase(title)) {
                this.movies.remove(i);
                found = true;
                System.out.println("\nMovie deleted successfully!");
                break;
            }
        }

        if (!found) {
            System.out.println("\nMovie not found");
        }

    }
}
