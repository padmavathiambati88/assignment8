import java.util.HashMap;
import java.util.Scanner;

public class RestaurantRating {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    HashMap<Integer, RatingInfo> ratings = new HashMap<>(); // Rating range counts

   
    System.out.println("Enter the number of restaurants: ");
    int numRestaurants = scanner.nextInt();

    for (int i = 0; i < numRestaurants; i++) {
      System.out.println("\nRestaurant " + (i + 1) + " details:");
      System.out.print("Rating (1-10): ");
      int rating = scanner.nextInt();

      
      int rangeStart = (rating - 1) / 5 * 5 + 1;
      int rangeEnd = rangeStart + 4;
      RatingInfo rangeInfo = ratings.get(rangeStart);
      if (rangeInfo == null) {
        rangeInfo = new RatingInfo(rangeStart, rangeEnd);
        ratings.put(rangeStart, rangeInfo);
      }
      rangeInfo.addRating(rating);
    }

   
    System.out.println("\nRestaurant Rating Summary:");
    for (RatingInfo info : ratings.values()) {
      System.out.println("Ratings [" + info.rangeStart + "-" + info.rangeEnd + " stars]: ");
      System.out.println("  Number of Restaurants: " + info.numRatings);
      System.out.printf("  Average Rating: %.2f\n", info.averageRating);
    }
  }
}

class RatingInfo {
  int rangeStart;
  int rangeEnd;
  int numRatings;
  double totalRating;

  public RatingInfo(int rangeStart, int rangeEnd) {
    this.rangeStart = rangeStart;
    this.rangeEnd = rangeEnd;
    this.numRatings = 0;
    this.totalRating = 0.0;
  }

  public void addRating(int rating) {
    numRatings++;
    totalRating += rating;
  }

  public double averageRating() {
    if (numRatings == 0) {
      return 0.0;
    }
    return totalRating / numRatings;
  }
}