import javax.xml.transform.Result;
import java.sql.*;
import java.util.Scanner;

public class DatabaseConnectionTest {
    String url = "jdbc:sqlite:data/movie_collection.db";

    public void testConnection() {
        String sql = "SELECT * FROM movies";

        try (
            Connection conn = DriverManager.getConnection(url);
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet result = stmt.executeQuery()
            ){

            System.out.println("Connected to the database successfully!");

            while (result.next()) {
                System.out.println(result.getString("title"));
                System.out.println(result.getString("genre"));
                System.out.println(result.getDouble("rating"));

            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void insertMovie() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter movie title: ");
        String title = scanner.nextLine();

        System.out.println("Enter movie genre: ");
        String genre = scanner.nextLine();

        System.out.println("Enter rating: ");
        double rating = scanner.nextDouble();

        String insertSql = "INSERT INTO movies(title, genre, rating)" + " "+ "VALUES (?, ?, ?)";
        String checkSql = "SELECT title FROM movies WHERE LOWER(title) = LOWER(?)";

        try (
                Connection conn = DriverManager.getConnection(url);
                PreparedStatement insertStmt = conn.prepareStatement(insertSql);
                PreparedStatement checkStmt = conn.prepareStatement(checkSql);
                ){
            checkStmt.setString(1, title);

            try (ResultSet  result = checkStmt.executeQuery()) {
                if (result.next()) {
                    System.out.println("Movie already exists. Please enter a different movie title.");
                } else {
                    insertStmt.setString(1, title);
                    insertStmt.setString(2, genre);
                    insertStmt.setDouble(3, rating);
                    insertStmt.executeUpdate();
                    System.out.println("Successfully added movie!");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void viewAll() {
        String viewSql = "SELECT * FROM movies";

        try (
                Connection conn = DriverManager.getConnection(url);
                PreparedStatement viewStmt = conn.prepareStatement(viewSql);
                ResultSet result = viewStmt.executeQuery();
                ){
            //display message saying movies to have all the movies displayed below it with a line

            while (result.next()) {
                String title = result.getString("title");
                String genre = result.getString("genre");
                double rating = result.getDouble("rating");

                System.out.println("Title: " + title);
                System.out.println("Genre: " + genre);
                System.out.println("Rating: " + rating);
                System.out.println();
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void removeMovie() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the title of the movie you want to delete: ");
        String title = scanner.nextLine();

        String deleteSql = "DELETE FROM movies WHERE title = ?";

        try (
                Connection conn = DriverManager.getConnection(url);
                PreparedStatement deleteStmt = conn.prepareStatement(deleteSql);
        ){
                deleteStmt.setString(1, title);
                int rowsChanged = deleteStmt.executeUpdate();
                if (rowsChanged > 0) {
                    System.out.println("Movie was deleted!");
                }else {
                    System.out.println("Movie was not found. Please try again.");
                }


        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        DatabaseConnectionTest test1 = new DatabaseConnectionTest();
        test1.removeMovie();
    }
}
