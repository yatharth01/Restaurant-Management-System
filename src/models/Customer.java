package models;

import services.OrderService;

public class Customer extends User {
    private OrderService orderService;
    private Table table;

    public Customer(String name, OrderService orderService, Table table) {
        super(name, Role.CUSTOMER);
        this.orderService = orderService;
        this.table = table;
    }

    public void addItemToOrder(MenuItem item, int quantity) {
        orderService.addItemToOrder(table, item, quantity);
    }

    public void removeItemFromOrder(MenuItem item) {
        orderService.removeItemFromOrder(table, item);
    }

    public void updateItemQuantityInOrder(MenuItem item, int quantity) {
        orderService.updateItemQuantityInOrder(table, item, quantity);
    }

    public double calculateTotal(double taxRate, boolean cardPayment) {
        Order currentOrder = table.getOrders();
        table.setOccupied(false);
        return orderService.calculateTotal(currentOrder, taxRate, cardPayment);
    }
}

