import java.util.HashMap;
import java.util.Scanner;

public class MovieRating {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    HashMap<String, RatingInfo> ratings = new HashMap<>();
    System.out.println("Enter the number of movies: ");
    int numMovies = scanner.nextInt();

    for (int i = 0; i < numMovies; i++) {
      System.out.println("\nMovie " + (i + 1) + " details:");
      System.out.print("Category (e.g., PG, PG-13, R): ");
      String category = scanner.next();
      System.out.print("Rating (1-5): ");
      int rating = scanner.nextInt();
      RatingInfo categoryInfo = ratings.get(category);
      if (categoryInfo == null) {
        categoryInfo = new RatingInfo(category);
        ratings.put(category, categoryInfo);
      }
      categoryInfo.addRating(rating);
    }
    System.out.println("\nMovie Rating Summary:");
    for (String category : ratings.keySet()) {
      RatingInfo info = ratings.get(category);
      System.out.println("Category: " + category);
      System.out.println("  Number of Movies: " + info.numMovies);
      System.out.printf("  Average Rating: %.2f\n", info.averageRating);
    }
  }
}

class RatingInfo {
  String category;
  int numMovies;
  double totalRating;

  public RatingInfo(String category) {
    this.category = category;
    this.numMovies = 0;
    this.totalRating = 0.0;
  }

  public void addRating(int rating) {
    numMovies++;
    totalRating += rating;
  }

  public double averageRating() {
    if (numMovies == 0) {
      return 0.0;
    }
    return totalRating / numMovies;
  }
}