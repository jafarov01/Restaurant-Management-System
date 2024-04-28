Restaurant Management System

Overview:
Develop a simple console-based Restaurant Management System in Java. The system should allow for managing menus,
handling reservations, and processing orders. You will apply foundational Java concepts, including classes, objects,
loops, conditions, and more.

Detailed Assignment Requirements

1. Basic System Setup
   Main Menu: Implement a console-based menu system that users interact with. This menu should provide options such as "
   Manage Menu," "Handle Reservations," "Process Orders," and "Exit."
   Example of Interaction: When the program runs, users should see a list of options and be prompted to enter a number
   to select an option.
   Exit Option: Include a way for users to exit the program gracefully, ensuring all operations are safely concluded
   before the application closes.

2. Menu Management
   Add Menu Item: Create functionality that allows users to input details for a new menu item. This includes name,
   price, and category. Ensure proper validations are in place (e.g., price should be a positive number).
   Input Fields: Name (String), Price (Double), Category (String - predefined options like appetizer, main course,
   dessert).
   Display Menu: Display the entire list of menu items in a structured format. Each item should show all its details
   clearly.
   Formatting: Consider aligning text for better readability and perhaps showing items categorized.
   Update Menu Item: Allow users to select an existing menu item by an identifier (like an ID or name) and update any of
   its fields (name, price, category).
   Delete Menu Item: Enable deletion of menu items through a user-specified identifier. Confirm deletion with the user
   to avoid accidental removals.

3. Reservation Handling
   Add Reservation: Provide a form where users can add a new reservation. Collect details such as the customer's name,
   and the date and time of the reservation. Include input validation (e.g., the date format should be correct, and time
   slots should be available).
   View Reservations: Display all reservations in a list, sorted by date and time. Ensure that the list is easy to read
   and well formatted.
   Cancel Reservation: Allow users to cancel a reservation by a specific identifier (such as a reservation number).
   Confirm cancellation to prevent accidental deletions.


4. Order Processing
   Create Order: Allow the user to create a new order by selecting items from the menu. The user should be able to
   specify quantities for each item.
   Order Details: Each order should have a unique order ID, list of items, quantities, and the total price calculated.
   View Orders: Show a list of all current orders with their details. Orders should be easily identifiable and viewable.
   Update Order: Give options to add more items to the order or remove items from an existing order. Changes should
   update the order’s total cost automatically.
   Finalize Order: Include an option to complete the order process. This should show the final order summary and mark
   the order as completed (or paid).
