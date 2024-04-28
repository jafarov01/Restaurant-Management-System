package models;

import java.util.Map;

public class Order {
    private static int idGenerator = 0;
    private final int id;
    private Map<MenuItem, Integer> items;
    private double totalPrice;
    private boolean status; //completed = true, incomplete = false

    public Order(Map<MenuItem, Integer> items, double totalPrice) {
        this.id = ++idGenerator;
        this.items = items;
        this.totalPrice = totalPrice;
        this.status = false;
    }

    @Override
    public String toString() {
        StringBuilder itemsString = new StringBuilder();
        items.forEach((menuItem, quantity) -> itemsString.append(String.format("\n\t\t%s (Quantity: %d)", menuItem, quantity)));

        return """
            Order:
                ID: %d,
                Items: %s,
                Total Price: %.2f,
                Status: %s
            """.formatted(id, itemsString.toString(), totalPrice, status ? "completed" : "incomplete");
    }

    // Getters
    public int getId() {
        return id;
    }

    public Map<MenuItem, Integer> getItems() {
        return items;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public boolean isStatus() {
        return status;
    }

    // Setters
    public void setItems(Map<MenuItem, Integer> items) {
        this.items = items;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
