package services;

import models.MenuItem;

import java.util.List;

public interface MenuService {

    void addItem(String name, double price, boolean veg, String category);
    void updateItemPrice(String name, double newPrice);
    void removeItem(String name);
    List<MenuItem> filterMenu(Boolean veg, String category);

    List<MenuItem> getItems();
}