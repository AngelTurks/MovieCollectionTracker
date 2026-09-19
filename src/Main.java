import java.util.Scanner;

public class Main {

    private static Scanner scan = new Scanner(System.in);
    private static MovieService movieService = new MovieService();

    public static void main(String[] args) {

        int choice = 0;
        final int EXIT_VALUE = 4;

        //show menu
        do {
            System.out.println("\n====== Movie Collection Tracker ======");
            System.out.println("1) Add Movie");
            System.out.println("2) View Movies");
            System.out.println("3) Delete Movie");
            System.out.println("4) Exit");

            //get user choice
            System.out.print("Enter your choice: ");
            choice = scan.nextInt();
            scan.nextLine(); // use up ENTER key

            // run code based on choice

            switch (choice) {
                case 1:
                    addMovie();
                    pause();
                    break;
                case 2:
                    viewMovies();
                    pause();
                    break;
                case 3:
                    deleteMovie();
                    pause();
                    break;
                case 4:
                    System.out.println("\nGoodbye!");
                    break;
                default:
                    System.out.println("\nError. Please select from the menu.");
                    pause();
                    break;
            }
        }
        while (choice != EXIT_VALUE);


    }//ends main



    public static void addMovie() {
        //ask user for movie info
        System.out.print("Enter a movie: ");
        String title = scan.nextLine();
        System.out.print("Enter the genre: ");
        String genre = scan.nextLine();
        System.out.print("Enter a rating (1 - 10): ");
        int rating = scan.nextInt();
        scan.nextLine(); //use up Enter key

        //create new object
        Movie movie = new Movie(title, genre, rating);

        movieService.addMovie(movie);

    }

    public static void viewMovies() {
        System.out.println("Movies: ");
        System.out.println("============");
        movieService.viewMovies();
        System.out.println("============");
    }

    public static void deleteMovie() {
        System.out.println("Enter the title of movie you want to delete: ");
        String removeTitle = scan.nextLine();

        movieService.deleteMovie(removeTitle);
    }



    public static void pause() {
        System.out.print("\nPress ENTER to continue...");
        scan.nextLine();
        System.out.println("\n\n");
    }
}//ends class
