package models;

import services.MenuService;
import services.TableService;

public class Admin extends User{
    private MenuService menuService;

    private TableService tableService;

    public Admin(String name,MenuService menuService, TableService tableService){
        super(name,Role.ADMIN);
        this.menuService = menuService;
        this.tableService = tableService;
    }

    public void addMenuItem(String name, double price, boolean veg, String category){
        menuService.addItem(name,price,veg,category);
    }

    public void updateItemPrice(String name, double newPrice){
        menuService.updateItemPrice(name,newPrice);
    }

    public void removeMenuItem(String name){
        menuService.removeItem(name);
    }

    public void allocateTable(int tableNumber){
        tableService.allocateTable(tableNumber);
    }

    public void vacateTable(int tableNumber){
        tableService.vacateTable(tableNumber);
    }
}
