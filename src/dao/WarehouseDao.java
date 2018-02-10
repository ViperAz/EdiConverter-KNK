package dao;

import Controller.DatabaseManager;
import model.Warehouse;

import java.sql.ResultSet;
import java.sql.SQLException;

public class WarehouseDao implements WarehouseDaoI {

    private static String PREFIX = "         ";
    private DatabaseManager db;

    public WarehouseDao(DatabaseManager db){
        this.db = db;
    }
    @Override
    public Warehouse getWarehouse(String item) throws SQLException {
        String SQL = "select t_cwar from ttdisa001803 where t_item = '"+PREFIX+item.trim()+"'";

        ResultSet rs = this.db.executeQuery(SQL);
        String output = "";
        // Iterate through the data in the result set and display it.
        while (rs.next()) {
            output = rs.getString(1);
        }


        return new Warehouse(output);
    }


    public  String getCurrentDB(){
        return  this.db.toString();
    }
}
