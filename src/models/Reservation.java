package models;


import java.time.LocalDateTime;

public class Reservation {
    private static int idGenerator = 0;
    private final int id;
    private String customerName;
    private LocalDateTime dateTime;

    public Reservation(String customerName, LocalDateTime dateTime) {
        this.id = ++idGenerator;
        this.customerName = customerName;
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return """
                ID: %d
                Customer Name: %s,
                Date and Time: %s,
                """.formatted(this.id, this.customerName, this.dateTime);
    }

    // Getters
    public String getCustomerName() {
        return customerName;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    // Setters
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
