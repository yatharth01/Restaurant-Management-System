package models;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<OrderItem> orderItems;
    private boolean isPrepared;

    public Order() {
        this.orderItems = new ArrayList<>();
        this.isPrepared = false;
    }

    public void addItem(MenuItem item, int quantity) {
        for (OrderItem orderItem : orderItems) {
            if (orderItem.getItem().equals(item)) {
                orderItem.setQuantity(orderItem.getQuantity() + quantity);
                return;
            }
        }
        orderItems.add(new OrderItem(item, quantity));
    }

    public void removeItem(MenuItem item) {
        orderItems.removeIf(orderItem -> orderItem.getItem().equals(item));
    }

    public void updateItemQuantity(MenuItem item, int quantity) {
        for (OrderItem orderItem : orderItems) {
            if (orderItem.getItem().equals(item)) {
                orderItem.setQuantity(quantity);
                return;
            }
        }
    }

    public double calculateTotal(double taxRate, boolean cardPayment) {
        double total = orderItems.stream().mapToDouble(OrderItem::getTotalPrice).sum();
        total += total * taxRate;
        if (cardPayment) {
            total += total * 0.01;
        }
        return total;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public boolean isPrepared() {
        return isPrepared;
    }

    public void setPrepared(boolean prepared) {
        isPrepared = prepared;
    }
}
