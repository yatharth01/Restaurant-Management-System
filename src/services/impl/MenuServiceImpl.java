package services.impl;

import models.MenuItem;
import services.MenuService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MenuServiceImpl implements MenuService {
    private List<MenuItem> items;

    public MenuServiceImpl() {
        this.items = new ArrayList<>();
    }

    public void addItem(String name, double price, boolean veg, String category) {
        items.add(new MenuItem(name, price, veg, category));
    }

    public void updateItemPrice(String name, double newPrice) {
        for (MenuItem item : items) {
            if (item.getName().equals(name)) {
                item.setPrice(newPrice);
                return;
            }
        }
    }

    @Override
    public void removeItem(String name) {
        items.removeIf(item -> item.getName().equals(name));
    }

    @Override
    public List<MenuItem> filterMenu(Boolean veg, String category) {
        return items.stream()
                .filter(item -> (veg == null || item.isVeg() == veg) &&
                        (category == null || item.getCategory().equals(category)))
                .collect(Collectors.toList());
    }

    public List<MenuItem> getItems() {
        return items;
    }
}

