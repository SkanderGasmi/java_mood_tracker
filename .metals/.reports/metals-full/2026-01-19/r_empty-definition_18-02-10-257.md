error id: file:///C:/Users/skand/OneDrive/Desktop/skander/coursera_projects/java_mood_tracker/src/MoodTracker.java:java/lang/String#
file:///C:/Users/skand/OneDrive/Desktop/skander/coursera_projects/java_mood_tracker/src/MoodTracker.java
empty definition using pc, found symbol in pc: java/lang/String#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 122
uri: file:///C:/Users/skand/OneDrive/Desktop/skander/coursera_projects/java_mood_tracker/src/MoodTracker.java
text:
```scala
import java.util.ArrayList;
import java.util.Scanner;

public class MoodTracker {

    public static void main(String@@[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Mood> moods = new ArrayList<>();

        while (true) {

            System.out.println("\n=== Mood Tracker Menu ===");
            System.out.println("A - Add Mood");
            System.out.println("D - Delete Mood");
            System.out.println("E - Edit Mood Notes");
            System.out.println("S - Search Mood");
            System.out.println("W - Write Moods to File");
            System.out.println("Exit - Exit Application");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("Exit")) {
                System.out.println("Exiting Mood Tracker...");
                break;
            }

            // Placeholder for switch-case (next task)
            System.out.println("You selected: " + choice);
        }

        scanner.close();
    }
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: java/lang/String#