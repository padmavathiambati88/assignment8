import java.util.ArrayList;
import java.util.Scanner;

class Project {
  String name;
  int dueDate;
  int completionTime;

  public Project(String name, int dueDate, int completionTime) {
    this.name = name;
    this.dueDate = dueDate;
    this.completionTime = completionTime;
  }

  public String getStatus() {
    if (completionTime < dueDate) {
      return "early";
    } else if (completionTime > dueDate) {
      return "late";
    } else {
      return "on time";
    }
  }
}

public class ProjectCompletion {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Project> projects = new ArrayList<>();
    System.out.println("Enter the number of students: ");
    int numStudents = scanner.nextInt();

    for (int i = 0; i < numStudents; i++) {
      System.out.println("Enter student " + (i + 1) + " details:");
      System.out.print("Project Name: ");
      String name = scanner.next();
      System.out.print("Due Date (days): ");
      int dueDate = scanner.nextInt();
      System.out.print("Completion Time (days): ");
      int completionTime = scanner.nextInt();

      projects.add(new Project(name, dueDate, completionTime));
    }
    int onTime = 0, late = 0, early = 0;
    double totalTime = 0;
    for (Project project : projects) {
      totalTime += project.completionTime;
      switch (project.getStatus()) {
        case "on time":
          onTime++;
          break;
        case "late":
          late++;
          break;
        case "early":
          early++;
          break;
      }
    }

    double averageTime = totalTime / projects.size();
 System.out.println("\nProject Completion Summary:");
    System.out.println("On Time: " + onTime);
    System.out.println("Late: " + late);
    System.out.println("Early: " + early);
    System.out.printf("Average Completion Time: %.2f days\n", averageTime);
  }
}