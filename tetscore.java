import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TestScoreStatistics {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Double> scores = new ArrayList<>();

    
    System.out.println("Enter the number of students: ");
    int numStudents = scanner.nextInt();

    System.out.println("Enter test scores for each student (separated by spaces):");
    for (int i = 0; i < numStudents; i++) {
      scores.add(scanner.nextDouble());
    }

    
    double totalScore = 0;
    for (double score : scores) {
      totalScore += score;
    }
    double averageScore = totalScore / scores.size();

    
    int aboveAverage = 0, atAverage = 0, belowAverage = 0;
    Collections.sort(scores); // Sort for median calculation

    double medianScore;
    if (scores.size() % 2 == 0) {
     
      int midIndex = scores.size() / 2 - 1;
      medianScore = (scores.get(midIndex) + scores.get(midIndex + 1)) / 2.0;
    } else {
     
      int midIndex = scores.size() / 2;
      medianScore = scores.get(midIndex);
    }

    
    for (double score : scores) {
      if (score > averageScore) {
        aboveAverage++;
      } else if (score == averageScore) {
        atAverage++;
      } else {
        belowAverage++;
      }
    }

    
    System.out.println("\nTest Score Summary:");
    System.out.println("Number of Students Above Average: " + aboveAverage);
    System.out.println("Number of Students at Average: " + atAverage);
    System.out.println("Number of Students Below Average: " + belowAverage);
    System.out.println("Median Score: " + medianScore);
  }
}