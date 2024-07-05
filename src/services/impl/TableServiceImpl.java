package services.impl;

import models.Table;
import services.TableService;

import java.util.ArrayList;
import java.util.List;

public class TableServiceImpl implements TableService {
    private List<Table> tables;

    public TableServiceImpl(int numberOfTables) {
        tables = new ArrayList<>();
        for (int i = 1; i <= numberOfTables; i++) {
            tables.add(new Table(i));
        }
    }

    @Override
    public void allocateTable(int tableNumber) {
        Table table = getTable(tableNumber);
        if (!table.isOccupied()) {
            table.setOccupied(true);
        }
    }

    @Override
    public void vacateTable(int tableNumber) {
        Table table = getTable(tableNumber);
        if (table.isOccupied()) {
            table.setOccupied(false);
        }
    }

    @Override
    public Table getTable(int tableNumber) {
        return tables.get(tableNumber - 1);
    }

    @Override
    public List<Table> getAllTables() {
        return tables;
    }
}
