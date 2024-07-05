package services;

import models.MenuItem;
import models.Order;
import models.Table;

public interface OrderService {
    void addItemToOrder(Table table, MenuItem item, int quantity);
    void removeItemFromOrder(Table table, MenuItem item);
    void updateItemQuantityInOrder(Table table, MenuItem item, int quantity);
    double calculateTotal(Order order, double taxRate, boolean cardPayment);
}
