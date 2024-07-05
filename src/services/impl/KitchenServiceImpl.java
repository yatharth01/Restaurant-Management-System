package services.impl;

import models.Order;
import services.KitchenService;

import java.util.LinkedList;
import java.util.Queue;

public class KitchenServiceImpl implements KitchenService {
    private Queue<Order> ordersQueue;

    public KitchenServiceImpl() {
        this.ordersQueue = new LinkedList<>();
    }

    @Override
    public void addOrder(Order order) {
        ordersQueue.add(order);
    }

    @Override
    public Order getNextOrder() {
        return ordersQueue.poll();
    }

    @Override
    public void markOrderAsPrepared(Order order) {
        order.setPrepared(true);
    }
}
