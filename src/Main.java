import models.*;
import services.*;
import services.impl.KitchenServiceImpl;
import services.impl.MenuServiceImpl;
import services.impl.OrderServiceImpl;
import services.impl.TableServiceImpl;
import utils.Utils;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        MenuService menuService = new MenuServiceImpl();
        TableService tableService = new TableServiceImpl(10);
        OrderService orderService = new OrderServiceImpl();
        KitchenService kitchenService = new KitchenServiceImpl();

        Admin admin = new Admin("Alice", menuService, tableService);
        Table table = tableService.getTable(1);
        Customer customer = new Customer("Bob", orderService, table);

        System.out.println("Add a new item to the menu ");
        admin.addMenuItem("Spaghetti Carbonara", 499, true, "Starter");
        Utils.printMenu(menuService.getItems());

        System.out.println("Update the price of an existing menu item" );
        admin.addMenuItem("Cheeseburger", 350, false, "Main Course");
        Utils.printMenu(menuService.getItems());
        admin.updateItemPrice("Cheeseburger", 299);
        Utils.printMenu(menuService.getItems());

        System.out.println("Remove an item from the menu ");
         admin.addMenuItem("French Fries", 150, true, "Appetizer");
        Utils.printMenu(menuService.getItems());
        admin.removeMenuItem("French Fries");
        Utils.printMenu(menuService.getItems());

        System.out.println("Allocate empty table to customer ");
        admin.allocateTable(1);
        Utils.printTables(tableService.getAllTables());

        System.out.println("Mark the table as occupied and then vacant after bill payment");
        admin.allocateTable(1);
        admin.allocateTable(1);
        Utils.printTables(tableService.getAllTables());
        admin.vacateTable(1);
        Utils.printTables(tableService.getAllTables());

        // 6. Make a reservation for a specific table
        admin.allocateTable(7);
        Utils.printTables(tableService.getAllTables());

        System.out.println(" Display the status of all tables to show changes ");
        Utils.printTables(tableService.getAllTables());

        System.out.println(" Browse the menu with / without filters and add items to an order");
        customer.addItemToOrder(menuService.getItems().get(0), 2);
        customer.addItemToOrder(menuService.getItems().get(1), 1);
        Order order = table.getOrders();
        Utils.printOrder(order);

        List<MenuItem> menuItems = menuService.filterMenu(false,"dee");
        if(menuItems.size() == 0){
            System.out.println("No items with the mentioned categories");
        }
        else
            customer.addItemToOrder(menuItems.get(0),1);
        Utils.printOrder(order);

        System.out.println(" Remove an item from the order ");
        customer.removeItemFromOrder(menuService.getItems().get(1));
        Utils.printOrder(order);

        System.out.println(" Change the quantity of an item in the order ");
        customer.updateItemQuantityInOrder(menuService.getItems().get(0), 3);
        Utils.printOrder(order);

        System.out.println(" Place the order ");
        kitchenService.addOrder(order);
        Order nextOrder = kitchenService.getNextOrder();
        kitchenService.markOrderAsPrepared(nextOrder);

        // 12. Customers can ask for the bill
        double total = customer.calculateTotal(0.07, true);
        System.out.println("Total: $" + total);

        Utils.printTables(tableService.getAllTables());

        // 13. Accept payment in various forms
        double totalWithCardCharge = customer.calculateTotal(0.07, true);
        System.out.println("Total with card charge: $" + totalWithCardCharge);

        double totalWithoutCardCharge = customer.calculateTotal(0.07, false);
        System.out.println("Total without card charge: $" + totalWithoutCardCharge);
    }
}
