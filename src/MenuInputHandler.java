import java.util.Scanner;

public class MenuInputHandler {
    private static final Scanner scanner = new Scanner(System.in);

    public static int promptMainMenu() {
        System.out.println("============ Main Menu ============");
        System.out.println("1. Manage Menu");
        System.out.println("2. Handle Reservations");
        System.out.println("3. Process Orders");
        System.out.println("4. Exit\n");
        System.out.print("Please enter your choice: ");

        int choice = -1;
        boolean isValidChoice = false;

        while (!isValidChoice) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice >= 1 && choice <= 4) {
                    isValidChoice = true;
                } else {
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }

        return choice;
    }

    public static void closeScanner() {
        scanner.close();
    }
}
