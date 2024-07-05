package services;

import models.Table;

import java.util.List;

public interface TableService {
    void allocateTable(int tableNumber);
    void vacateTable(int tableNumber);
    Table getTable(int tableNumber);
    List<Table> getAllTables();
}
