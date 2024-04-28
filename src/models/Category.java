package models;

public enum Category {
    APPETIZER,
    MAIN_COURSE,
    DESSERT;

    @Override
    public String toString() {
        return switch (this) {
            case APPETIZER -> "Appetizer";
            case MAIN_COURSE -> "Main Course";
            case DESSERT -> "Dessert";
            default -> throw new IllegalArgumentException();
        };
    }
}