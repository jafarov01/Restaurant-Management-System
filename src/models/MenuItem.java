package models;

public class MenuItem {

    private static int idGenerator = 0;
    private final int id;
    private String name;
    private double price;
    private Category category;

    public MenuItem(String name, double price, Category category) {
        id = ++idGenerator;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    @Override
    public String toString() {
        return """
                ID: %d
                Name: %s
                Price: %.2f
                Category: %s
                """.formatted(this.id, this.name, this.price, category.toString());
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public static int getIdGenerator() {
        return idGenerator;
    }

    public static void setIdGenerator(int idGenerator) {
        MenuItem.idGenerator = idGenerator;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
