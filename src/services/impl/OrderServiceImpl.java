package services.impl;

import models.MenuItem;
import models.Order;
import models.Table;
import services.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    @Override
    public void addItemToOrder(Table table, MenuItem item, int quantity) {
        Order order = getOrCreateCurrentOrder(table);
        order.addItem(item, quantity);
    }

    @Override
    public void removeItemFromOrder(Table table, MenuItem item) {
        Order order = getCurrentOrder(table);
        if (order != null) {
            order.removeItem(item);
        }
    }

    @Override
    public void updateItemQuantityInOrder(Table table, MenuItem item, int quantity) {
        Order order = getCurrentOrder(table);
        if (order != null) {
            order.updateItemQuantity(item, quantity);
        }
    }

    @Override
    public double calculateTotal(Order order, double taxRate, boolean cardPayment) {
        return order.calculateTotal(taxRate, cardPayment);
    }

    private Order getOrCreateCurrentOrder(Table table) {
        Order orders = table.getOrders();
//        if (orders.isEmpty() || orders.get(orders.size() - 1).isPrepared()) {
//            Order newOrder = new Order();
//            table.addOrder(newOrder);
//            return newOrder;
//        }
        if(orders == null || orders.isPrepared()) {
            Order order = new Order();
            table.addOrder(order);
            return order;
        }
        return orders;
    }

    private Order getCurrentOrder(Table table) {
        Order orders = table.getOrders();
//        if (!orders.isEmpty() && !orders.get(orders.size() - 1).isPrepared()) {
//            return orders.get(orders.size() - 1);
//        }

        if(orders != null){
            return orders;
        }
        return null;
    }
}
