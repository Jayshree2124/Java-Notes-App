import java.io.*;
import java.util.Scanner;

public class NotesApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filename = "notes.txt";

        while (true) {
            System.out.println("\n--- Notes App ---");
            System.out.println("1. Write Note");
            System.out.println("2. Read Notes");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter your note: ");
                    String note = scanner.nextLine();
                    writeToFile(filename, note);
                    break;
                case 2:
                    readFromFile(filename);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    public static void writeToFile(String filename, String content) {
        try (FileWriter fw = new FileWriter(filename, true)) { // true = append mode
            fw.write(content + "\n");
            System.out.println("Note saved successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public static void readFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            System.out.println("\n--- Your Notes ---");
            while ((line = br.readLine()) != null) {
                System.out.println("- " + line);
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }
}
