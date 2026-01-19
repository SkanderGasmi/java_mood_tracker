import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class MoodTracker {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Mood> moods = new ArrayList<>();

        while (true) {
            System.out.println(
                    "\nPress:\n 'a' to add mood\n" +
                    "'d' to delete mood(s)\n" +
                    "'e' to edit mood\n" +
                    "'s' to search for moods\n" +
                    "'M' to get all moods\n" +
                    "'w' to write the moods to a file\n" +
                    "Type 'Exit' to exit"
            );

            String menuOption = scanner.nextLine();

            switch (menuOption) {

                /* =====================
                   ADD MOOD
                   ===================== */
                case "a":
                    try {
                        System.out.print("Enter mood name: ");
                        String name = scanner.nextLine();

                        System.out.print("Enter date (yyyy-mm-dd) or press Enter: ");
                        String dateInput = scanner.nextLine();

                        System.out.print("Enter time (HH:mm) or press Enter: ");
                        String timeInput = scanner.nextLine();

                        LocalDate date = dateInput.isEmpty()
                                ? LocalDate.now()
                                : LocalDate.parse(dateInput);

                        LocalTime time = timeInput.isEmpty()
                                ? LocalTime.MIDNIGHT
                                : LocalTime.parse(timeInput);

                        Mood newMood = new Mood(name, date, time);

                        for (Mood m : moods) {
                            if (m.equals(newMood)) {
                                throw new InvalidMoodException(
                                        "Mood already exists for this date and time"
                                );
                            }
                        }

                        moods.add(newMood);
                        System.out.println("Mood added successfully.");

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    continue;

                /* =====================
                   DELETE MOOD(S)
                   ===================== */
                case "d":
                    System.out.println("1 - Delete moods by date");
                    System.out.println("2 - Delete specific mood");
                    String deleteOption = scanner.nextLine();

                    if (deleteOption.equals("1")) {
                        System.out.print("Enter date (yyyy-mm-dd): ");
                        LocalDate date = LocalDate.parse(scanner.nextLine());

                        Iterator<Mood> iterator = moods.iterator();
                        boolean deleted = false;

                        while (iterator.hasNext()) {
                            if (iterator.next().getDate().equals(date)) {
                                iterator.remove();
                                deleted = true;
                            }
                        }

                        System.out.println(
                                deleted ? "Mood(s) deleted." : "No moods found."
                        );

                    } else if (deleteOption.equals("2")) {
                        System.out.print("Enter mood name: ");
                        String name = scanner.nextLine();

                        System.out.print("Enter date (yyyy-mm-dd): ");
                        LocalDate date = LocalDate.parse(scanner.nextLine());

                        System.out.print("Enter time (HH:mm): ");
                        LocalTime time = LocalTime.parse(scanner.nextLine());

                        Mood target = new Mood(name, date, time);
                        boolean removed = moods.remove(target);

                        System.out.println(
                                removed ? "Mood deleted." : "Mood not found."
                        );
                    }
                    continue;

                /* =====================
                   EDIT MOOD
                   ===================== */
                case "e":
                    System.out.print("Enter mood name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter date (yyyy-mm-dd): ");
                    LocalDate date = LocalDate.parse(scanner.nextLine());

                    System.out.print("Enter time (HH:mm): ");
                    LocalTime time = LocalTime.parse(scanner.nextLine());

                    boolean found = false;

                    for (Mood m : moods) {
                        if (m.equals(new Mood(name, date, time))) {
                            System.out.print("Enter new notes: ");
                            m.setNotes(scanner.nextLine());
                            System.out.println("Notes updated.");
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Mood not found.");
                    }
                    continue;

                /* =====================
                   SEARCH MOOD(S)
                   ===================== */
                case "s":
                    System.out.println("1 - Search by date");
                    System.out.println("2 - Search specific mood");
                    String searchOption = scanner.nextLine();

                    if (searchOption.equals("1")) {
                        System.out.print("Enter date (yyyy-mm-dd): ");
                        LocalDate searchDate = LocalDate.parse(scanner.nextLine());

                        for (Mood m : moods) {
                            if (m.getDate().equals(searchDate)) {
                                System.out.println(m);
                            }
                        }

                    } else if (searchOption.equals("2")) {
                        System.out.print("Enter mood name: ");
                        String searchName = scanner.nextLine();

                        System.out.print("Enter date (yyyy-mm-dd): ");
                        LocalDate searchDate = LocalDate.parse(scanner.nextLine());

                        System.out.print("Enter time (HH:mm): ");
                        LocalTime searchTime = LocalTime.parse(scanner.nextLine());

                        for (Mood m : moods) {
                            if (m.equals(new Mood(searchName, searchDate, searchTime))) {
                                System.out.println(m);
                                break;
                            }
                        }
                    }
                    continue;

                /* =====================
                   GET ALL MOODS
                   ===================== */
                case "M":
                    if (moods.isEmpty()) {
                        System.out.println("No moods recorded.");
                    } else {
                        for (Mood m : moods) {
                            System.out.println(m);
                        }
                    }
                    continue;

                case "w":
                    try (PrintWriter writer = new PrintWriter(new FileWriter("moodtracker.txt"))) {
                        for (Mood mood : moods) {
                            writer.println(mood + "\n");
                        }
                        System.out.println("Moods written to moodtracker.txt");
                    } catch (IOException e) {
                        System.err.println("Error writing to file: " + e.getMessage());
                    }
                    continue;


                case "Exit":
                    System.out.println("Thank you for using the MoodTracker. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Not a valid input!");
            }
        }
    }
}
