package utils;

import models.MenuItem;
import models.Order;
import models.OrderItem;
import models.Table;

import java.util.List;

public class Utils {
    public static void printMenu(List<MenuItem> menu) {
        for (MenuItem item : menu) {
            System.out.println(item.getName() + " - " + item.getPrice() + " Rupees - " + (item.isVeg() ? "Veg" : "Non-Veg") + " - " + item.getCategory());
        }
    }

    public static void printTables(List<Table> tables) {
        for (Table table : tables) {
            System.out.println("Table " + table.getTableNumber() + ": " + (table.isOccupied() ? "Occupied" : "Vacant"));
        }
    }

    public static void printOrder(Order order) {
        for (OrderItem orderItem : order.getOrderItems()) {
            System.out.println(orderItem.getItem().getName() + " x " + orderItem.getQuantity() + " - " + orderItem.getTotalPrice() + " Rupees");
        }
    }
}
