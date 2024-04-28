import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import models.*;

public class ReservationInputHandler {

    private Restaurant restaurant;
    private Scanner scanner;

    public ReservationInputHandler(Restaurant restaurant) {
        this.restaurant = restaurant;
        this.scanner = new Scanner(System.in);
    }

    public void handleReservationInput() {
        boolean isRunning = true;

        while (isRunning) {
            int choice = promptReservationMenu();

            switch (choice) {
                case 1:
                    addReservation();
                    break;
                case 2:
                    viewReservations();
                    break;
                case 3:
                    cancelReservation();
                    break;
                case 4:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addReservation() {
        System.out.println("Enter customer name: ");
        String customerName = scanner.nextLine();

        System.out.println("Enter date and time of reservation (dd-MM-yyyy HH:mm): ");
        String dateTimeString = scanner.nextLine();

        try {
            LocalDateTime dateTime = LocalDateTime.parse(dateTimeString, DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
            Reservation newReservation = new Reservation(customerName, dateTime);
            restaurant.addReservation(newReservation);
            System.out.println("Reservation added successfully!");
        } catch (Exception e) {
            System.out.println("Invalid date and time format. Please enter in the format dd-MM-yyyy HH:mm.");
        }
    }

    private void viewReservations() {
        System.out.println("=== Reservations ===");
        restaurant.displayReservations();
    }

    private void cancelReservation() {
        System.out.println("Enter the ID of the reservation to cancel: ");
        int reservationId = Integer.parseInt(scanner.nextLine());

        Reservation reservationToCancel = null;
        for (Reservation reservation : restaurant.getReservations()) {
            if (reservation.getId() == reservationId) {
                reservationToCancel = reservation;
                break;
            }
        }

        if (reservationToCancel != null) {
            restaurant.cancelReservation(reservationToCancel);
            System.out.println("Reservation cancelled successfully!");
        } else {
            System.out.println("Reservation with ID " + reservationId + " not found.");
        }
    }

    private int promptReservationMenu() {
        System.out.println("=== Reservation Handling ===");
        System.out.println("1. Add Reservation");
        System.out.println("2. View Reservations");
        System.out.println("3. Cancel Reservation");
        System.out.println("4. Back to Main Menu");
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
}
