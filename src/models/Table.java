package models;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private int tableNumber;
    private boolean isOccupied;
    private Order orders;

    public Table(int tableNumber) {
        this.tableNumber = tableNumber;
        this.isOccupied = false;
     //   this.orders = new ArrayList<>();
    }

    public int getTableNumber() { return tableNumber; }
    public boolean isOccupied() { return isOccupied; }
    public void setOccupied(boolean occupied) { isOccupied = occupied; }

    public void addOrder(Order order) {
        this.orders = order;
    }

    public Order getOrders() {
        return orders;
    }
}

