package services;

import models.Order;

public interface KitchenService {
    void addOrder(Order order);
    Order getNextOrder();
    void markOrderAsPrepared(Order order);
}