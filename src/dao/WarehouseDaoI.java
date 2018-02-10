package dao;

import model.Warehouse;

import java.sql.SQLException;

public interface WarehouseDaoI {

    Warehouse getWarehouse(String item) throws SQLException;
}
