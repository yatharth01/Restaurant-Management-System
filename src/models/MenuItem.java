package models;

public class MenuItem {
    private String name;
    private double price;
    private boolean  veg;
    private String category;

    public MenuItem(String name, double price, boolean veg, String category) {
        this.name = name;
        this.price = price;
        this.veg = veg;
        this.category = category;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public boolean isVeg() { return veg; }
    public void setVeg(boolean veg) { this.veg = veg; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
}
