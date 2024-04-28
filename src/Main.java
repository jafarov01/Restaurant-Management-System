public class Main {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        MenuManagementInputHandler menuManagementInputHandler = new MenuManagementInputHandler(restaurant);
        ReservationInputHandler reservationInputHandler = new ReservationInputHandler(restaurant);
        OrderInputHandler orderInputHandler = new OrderInputHandler(restaurant);

        boolean isRunning = true;

        while (isRunning) {
            int choice = MenuInputHandler.promptMainMenu();

            switch (choice) {
                case 1:
                    menuManagementInputHandler.handleMenuManagement();
                    break;
                case 2:
                    reservationInputHandler.handleReservationInput();
                    break;
                case 3:
                    orderInputHandler.handleOrderProcessing();
                    break;
                case 4:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        MenuInputHandler.closeScanner();
    }
}