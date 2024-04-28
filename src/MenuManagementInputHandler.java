import models.Category;
import models.MenuItem;

import java.util.Scanner;

public class MenuManagementInputHandler {

    private Restaurant restaurant;
    private Scanner scanner;

    public MenuManagementInputHandler(Restaurant restaurant) {
        this.restaurant = restaurant;
        this.scanner = new Scanner(System.in);
    }

    public void handleMenuManagement() {
        boolean isRunning = true;

        while (isRunning) {
            int choice = promptMenuManagementMenu();

            switch (choice) {
                case 1:
                    addMenuItem();
                    break;
                case 2:
                    updateMenuItem();
                    break;
                case 3:
                    deleteMenuItem();
                    break;
                case 4:
                    restaurant.displayMenuItems();
                    break;
                case 5:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addMenuItem() {
        System.out.println("Enter name of the new menu item: ");
        String name = scanner.nextLine();

        System.out.println("Enter price of the new menu item: ");
        double price = Double.parseDouble(scanner.nextLine());

        System.out.println("Enter category of the new menu item (APPETIZER, MAIN_COURSE, DESSERT): ");
        Category category = Category.valueOf(scanner.nextLine());

        MenuItem newItem = new MenuItem(name, price, category);

        restaurant.addMenuItem(newItem);

        System.out.println("Menu item added successfully!");
    }

    private void updateMenuItem() {
        System.out.println("Enter the ID of the menu item to update: ");
        int itemId = Integer.parseInt(scanner.nextLine());

        MenuItem menuItemToUpdate = null;
        for (MenuItem menuItem : restaurant.getMenuItems()) {
            if (menuItem.getId() == itemId) {
                menuItemToUpdate = menuItem;
                break;
            }
        }

        if (menuItemToUpdate != null) {
            System.out.println("Enter new name for the menu item: ");
            String newName = scanner.nextLine();
            System.out.println("Enter new price for the menu item: ");
            double newPrice = Double.parseDouble(scanner.nextLine());
            System.out.println("Enter new category for the menu item (APPETIZER, MAIN_COURSE, DESSERT): ");
            Category newCategory = Category.valueOf(scanner.nextLine());

            MenuItem newMenuItem = new MenuItem(newName, newPrice, newCategory);

            restaurant.updateMenuItem(menuItemToUpdate, newMenuItem);

            System.out.println("Menu item updated successfully!");
        } else {
            System.out.println("Menu item with ID " + itemId + " not found.");
        }
    }


    private void deleteMenuItem() {
        System.out.println("Enter the ID of the menu item to delete: ");
        int itemId = Integer.parseInt(scanner.nextLine());

        MenuItem menuItemToDelete = null;
        for (MenuItem menuItem : restaurant.getMenuItems()) {
            if (menuItem.getId() == itemId) {
                menuItemToDelete = menuItem;
                break;
            }
        }

        if (menuItemToDelete != null) {
            restaurant.deleteMenuItem(menuItemToDelete);

            System.out.println("Menu item deleted successfully!");
        } else {
            System.out.println("Menu item with ID " + itemId + " not found.");
        }
    }

    private int promptMenuManagementMenu() {
        System.out.println("=== Menu Management ===");
        System.out.println("1. Add Menu Item");
        System.out.println("2. Update Menu Item");
        System.out.println("3. Delete Menu Item");
        System.out.println("4. Display Menu Items");
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
