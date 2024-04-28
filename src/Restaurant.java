import models.*;
import java.util.ArrayList;

public class Restaurant {

    private ArrayList<MenuItem> menuItems;
    private ArrayList<Order> orders;

    private ArrayList<Order> finalizedOrders;
    private ArrayList<Reservation> reservations;
    private ArrayList<Reservation> cancelledReservations;

    public Restaurant() {
        menuItems = new ArrayList<>();
        orders = new ArrayList<>();
        finalizedOrders = new ArrayList<>();
        reservations = new ArrayList<>();
        cancelledReservations = new ArrayList<>();
    }

    // Menu Management
    public void addMenuItem(MenuItem menuItem) {
        menuItems.add(menuItem);
    }

    public void displayMenuItems() {
        for (MenuItem menuItem : menuItems) {
            System.out.println(menuItem);
        }
    }

    public void updateMenuItem(MenuItem menuItemToBeUpdated, MenuItem newMenuItem) {
        menuItems.remove(menuItemToBeUpdated);
        menuItems.add(newMenuItem);
    }

    public void deleteMenuItem(MenuItem menuItemToBeDeleted) {
        menuItems.remove(menuItemToBeDeleted);
    }


    // Reservation Handling
    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    public void displayReservations() {
        for (Reservation reservation : reservations) {
            System.out.println(reservation);
        }
    }

    public void cancelReservation(Reservation reservationToBeCancelled) {
        reservations.remove(reservationToBeCancelled);
        cancelledReservations.add(reservationToBeCancelled);
    }

    // Order Processing
    public void addOrder(Order orderToBeAdded) {
        orders.add(orderToBeAdded);
    }

    public void displayOrders() {
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    public void updateOrder(Order orderToBeUpdated, Order newOrder) {
        orders.remove(orderToBeUpdated);
        orders.add(newOrder);
    }

    public void finalizeOrder(Order orderToBeFinalized) {
        orderToBeFinalized.setStatus(true);
        finalizedOrders.add(orderToBeFinalized);
        orders.remove(orderToBeFinalized);
    }

    // ------------------------------


    @Override
    public String toString() {
        return "Restaurant{" +
                "menuItems=" + menuItems +
                ", orders=" + orders +
                ", finalizedOrders=" + finalizedOrders +
                ", reservations=" + reservations +
                ", cancelledReservations=" + cancelledReservations +
                '}';
    }

    // Getters

    public ArrayList<Order> getFinalizedOrders() {
        return finalizedOrders;
    }

    public ArrayList<MenuItem> getMenuItems() {
        return menuItems;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    public ArrayList<Reservation> getCancelledReservations() {
        return cancelledReservations;
    }
}
