import java.util.Scanner;

// Handles all user input and validation
public class InputHelper {
    private static Scanner sc = new Scanner(System.in);

    private static String readLine() {
        if (!sc.hasNextLine()) {
            System.out.println("\nNo more input. Exiting...");
            System.exit(0);
        }
        return sc.nextLine().trim();
    }

    public static int readInt(String message) {
        while (true) {
            System.out.print(message);
            String input = readLine();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a whole number.");
            }
        }
    }

    public static int readIntInRange(String message, int min, int max) {
        while (true) {
            int value = readInt(message);
            if (value >= min && value <= max) {
                return value;
            }
            System.out.println("Please enter a number between " + min + " and " + max + ".");
        }
    }

    public static String readText(String message) {
        while (true) {
            System.out.print(message);
            String input = readLine();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("Input cannot be empty!");
        }
    }

    public static void pause() {
        System.out.print("\nPress Enter to continue...");
        readLine();
    }
}
