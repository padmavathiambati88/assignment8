import java.util.HashMap;
import java.util.Scanner;

public class BookReview {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    HashMap<Integer, Integer> ratings = new HashMap<>();
    int positive = 0, neutral = 0, negative = 0;

    
    System.out.println("Enter the number of book reviews: ");
    int numReviews = scanner.nextInt();

    for (int i = 0; i < numReviews; i++) {
      System.out.println("\nReview " + (i + 1) + " details:");
      System.out.print("Rating (1-10): ");
      int rating = scanner.nextInt();
      System.out.print("Review Sentiment (positive, neutral, negative): ");
      String sentiment = scanner.next().toLowerCase();

    
      int rangeStart = (rating - 1) / 5 * 5 + 1;
      int rangeEnd = rangeStart + 4;
      ratings.put(rangeStart, ratings.getOrDefault(rangeStart, 0) + 1);

      
      switch (sentiment) {
        case "positive":
          positive++;
          break;
        case "neutral":
          neutral++;
          break;
        case "negative":
          negative++;
          break;
        default:
          System.out.println("Invalid sentiment. Review ignored.");
      }
    }

   
    System.out.println("\nBook Review Summary:");

   
    for (int i = 1; i <= 10; i += 5) {
      int count = ratings.getOrDefault(i, 0);
      System.out.println("Ratings [" + i + "-" + (i + 4) + " stars]: " + count);
    }

    System.out.println("Positive Reviews: " + positive);
    System.out.println("Neutral Reviews: " + neutral);
    System.out.println("Negative Reviews: " + negative);
  }
}