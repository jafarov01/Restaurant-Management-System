import java.util.Scanner;
import java.util.HashMap;
import models.*;

public class OrderInputHandler {

    private Restaurant restaurant;
    private Scanner scanner;

    public OrderInputHandler(Restaurant restaurant) {
        this.restaurant = restaurant;
        this.scanner = new Scanner(System.in);
    }

    public void handleOrderProcessing() {
        boolean isRunning = true;

        while (isRunning) {
            int choice = promptOrderProcessingMenu();

            switch (choice) {
                case 1:
                    createOrder();
                    break;
                case 2:
                    restaurant.displayOrders();
                    break;
                case 3:
                    updateOrder();
                    break;
                case 4:
                    finalizeOrder();
                    break;
                case 5:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void createOrder() {
        restaurant.addOrder(newOrder());
    }

    private double calculateTotalPrice(HashMap <MenuItem, Integer> items) {
        double totalPrice = 0.0;
        for (MenuItem menuItem : items.keySet()) {
            int quantity = items.get(menuItem);
            totalPrice += menuItem.getPrice() * quantity;
        }
        return totalPrice;
    }

    private Order newOrder() {
        restaurant.displayMenuItems();

        System.out.println("Enter IDs of menu items to add to the order (comma-separated): ");
        String[] itemIds = scanner.nextLine().split(",");

        HashMap <MenuItem, Integer> selectedItems = new HashMap<>();

        for (String itemId : itemIds) {
            try {
                int id = Integer.parseInt(itemId.trim());
                MenuItem menuItem = null;
                for (MenuItem mi : restaurant.getMenuItems()) {
                    if (mi.getId() == id) {
                        menuItem = mi;
                        break;
                    }
                }

                if (menuItem != null) {
                    System.out.printf("Enter quantity for '%s': ", menuItem.getName());
                    int quantity = Integer.parseInt(scanner.nextLine());
                    selectedItems.put(menuItem, quantity);
                } else {
                    System.out.println("Invalid menu item ID: " + id);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid menu item ID.");
            }
        }

        double totalPrice = calculateTotalPrice(selectedItems);

        System.out.println("Order created successfully!");

        return new Order(selectedItems, totalPrice);
    }

    private void updateOrder() {
        System.out.println("Enter the ID of the order to update: ");
        int orderId = Integer.parseInt(scanner.nextLine());

        Order orderToBeUpdated = null;
        for (Order order : restaurant.getOrders()) {
            if (order.getId() == orderId) {
                orderToBeUpdated = order;
                break;
            }
        }

        if (orderToBeUpdated != null) {
            Order newOrder = newOrder();
            restaurant.updateOrder(orderToBeUpdated, newOrder);
            System.out.println("Order updated successfully!");
        } else {
            System.out.println("Order with ID " + orderId + " not found.");
        }
    }

    private void finalizeOrder() {
        System.out.println("Enter the ID of the order to finalize: ");
        int orderId = Integer.parseInt(scanner.nextLine());

        // Find the order in the list based on the identifier
        Order orderToFinalize = null;
        for (Order order : restaurant.getOrders()) {
            if (order.getId() == orderId) {
                orderToFinalize = order;
                break;
            }
        }

        if (orderToFinalize != null) {
            restaurant.finalizeOrder(orderToFinalize);
            System.out.println("Order finalized successfully!");
        } else {
            System.out.println("Order with ID " + orderId + " not found.");
        }
    }

    private int promptOrderProcessingMenu() {
        System.out.println("=== Order Processing ===");
        System.out.println("1. Create Order");
        System.out.println("2. View Orders");
        System.out.println("3. Update Order");
        System.out.println("4. Finalize Order");
        System.out.println("5. Back to Main Menu");
        System.out.print("Please enter your choice: ");

        int choice = -1;
        boolean isValidChoice = false;

        while (!isValidChoice) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice >= 1 && choice <= 5) {
                    isValidChoice = true;
                } else {
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }

        return choice;
    }
}


